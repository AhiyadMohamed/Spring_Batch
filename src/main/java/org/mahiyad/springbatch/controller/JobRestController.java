package org.mahiyad.springbatch.controller;

import lombok.extern.slf4j.Slf4j;
import org.mahiyad.springbatch.config.processor.BankTransactionItemAnalyticsProcessor;
import org.mahiyad.springbatch.config.stop.JobService;
import org.mahiyad.springbatch.data.entities.Log;
import org.mahiyad.springbatch.data.repositories.LogRepo;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@Slf4j
public class JobRestController {

    @Autowired private JobLauncher jobLauncher;
    @Autowired private BankTransactionItemAnalyticsProcessor analyticsProcessor;
    @Autowired private JobService jobService;
    @Autowired private LogRepo logRepo;
    @Autowired  private Job purgeAuditableTablesJob;



    @GetMapping("/startJob")
    public BatchStatus load() throws Exception {
        JobExecution jobExecution = null;
        try {
            Map<String, JobParameter> jobParams = new HashMap<>();
            jobParams.put("time", new JobParameter(System.currentTimeMillis()));
            JobParameters jobParameters = new JobParameters(jobParams);
            jobExecution = jobLauncher.run(purgeAuditableTablesJob, jobParameters);
            while (jobExecution.isRunning()) {
                // Thread.sleep(10000);
                log.info(".....");
            }
            if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

                log.info("==================================================");
                log.info("================== SUCCESS =======================");
                log.info("PurgeAuditableTablesJob - SUCCESS : ID du job : " +jobExecution.getId());
                log.info("==================================================");
                log.info("==================================================");

                Log log1 = new Log();
                log1.setLogMessage("PurgeAuditableTablesJob - Succes : ID du job  " +jobExecution.getId());
                log1.setJobExecution_id(jobExecution.getId());
                logRepo.save(log1);
                return jobExecution.getStatus();
            } else {

                log.info("==================================================");
                log.info("================== FAILED =======================");
                log.info("PurgeAuditableTablesJob - Failed : ID du job : " +jobExecution.getId());
                log.info("==================================================");
                log.info("==================================================");

                Log log1 = new Log();
                log1.setLogMessage("INFO "+"PurgeAuditableTablesJob - FAILED : ID du job "+jobExecution.getId());
                log1.setJobExecution_id(jobExecution.getId());
                logRepo.save(log1);
                return jobExecution.getStatus();

            }
        } catch (Exception e) {
            log.info("===============================================");
            log.info("===============================================");
            log.error("Error occurred while running the batch job.", e);
            log.info("===============================================");
            log.info("===============================================");
            Log log1 = new Log();
            assert jobExecution != null;
            log1.setLogMessage("ERROR "+"PurgeAuditableTablesJob - Failed : ID du job  " + jobExecution.getId());
            log1.setJobExecution_id(jobExecution.getId());
            logRepo.save(log1);
            throw e;
        }
    }


    @PostMapping("/{jobName}/stop")
    public ResponseEntity<String> stopJob(@PathVariable String jobName) throws NoSuchJobExecutionException, JobExecutionNotRunningException {
        boolean batchStopped = jobService.stopJobByName(jobName);

        if (batchStopped) {
            return ResponseEntity.ok("Batch stopped successfully.");
        } else {
            return ResponseEntity.badRequest().body("No batch is currently running for the specified job.");
        }
    }

    @GetMapping("/analytics")
    public Map<String,Double> analytics(){
        Map<String,Double> map = new HashMap<>();
        map.put("Total Credit : ",analyticsProcessor.getTotalCredit());
        map.put("Total Debit : ",analyticsProcessor.getTotalDebit());
        return map;
    }

}



