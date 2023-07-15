package org.mahiyad.springbatch.controller;

import org.mahiyad.springbatch.config.processor.BankTransactionItemAnalyticsProcessor;
import org.mahiyad.springbatch.config.stop.JobService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class JobRestController {

    @Autowired private JobLauncher jobLauncher;
    @Autowired private Job job1;
    @Autowired private BankTransactionItemAnalyticsProcessor analyticsProcessor;




    @GetMapping("/startJob")
    public BatchStatus load() throws Exception{
        Map<String , JobParameter> jobParams = new HashMap<>();
        jobParams.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(jobParams);
        JobExecution jobExecution = jobLauncher.run(job1,jobParameters);
        while (jobExecution.isRunning()){
            Thread.sleep(10000);
            System.out.println(".....");
        }
        return jobExecution.getStatus();
    }



    @GetMapping("/analytics")
    public Map<String,Double> analytics(){
        Map<String,Double> map = new HashMap<>();
        map.put("Total Credit : ",analyticsProcessor.getTotalCredit());
        map.put("Total Debit : ",analyticsProcessor.getTotalDebit());
        return map;
    }


    @Autowired
    private JobService jobService;



        @PostMapping("/{jobName}/stop")
        public void stopBatch(@PathVariable String jobName) throws NoSuchJobExecutionException, JobExecutionNotRunningException {
            jobService.stopBatchByName(jobName);
        }



}
