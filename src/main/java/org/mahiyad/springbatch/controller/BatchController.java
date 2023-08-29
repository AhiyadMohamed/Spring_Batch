package org.mahiyad.springbatch.controller;

import org.mahiyad.springbatch.data.entities.BatchJobExecution;
import org.mahiyad.springbatch.data.repositories.BatchJobIntanceRepository;
import org.mahiyad.springbatch.data.repositories.BatchjobexecutionRepository;
import org.mahiyad.springbatch.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @Autowired
    private BatchJobIntanceRepository jobInstanceRepository;

    @Autowired
    private BatchjobexecutionRepository batchjobexecutionRepository;


    @GetMapping("/execution")
    List<BatchJobExecution> getAllExecution(){
        return batchService.getAllExecution();
    }

    @GetMapping("/completed-count")
    public long getCompletedJobExecutionsCount() {
        return batchService.countCompletedJobExecutions();
    }

    @GetMapping("/failed-count")
    public long getFailedJobExecutionsCount(){
        return batchService.countFailedJobExecutions();
    }

    @GetMapping("/stopped-count")
    public long getStoppedJobExecutionsCount(){
        return batchService.countStoppedJobExecutions();
    }


    @GetMapping("/job-name")
    public List<String> getUniqueBatchNames() {
        return jobInstanceRepository.findDistinctJobNames();
    }

    @GetMapping("/count-job")
    public long getBatchCount(){
        return batchService.countDistinctBatches();
    }

    @GetMapping("/list-job")
    public List<String> listBatch(){
        return batchService.listBatch();
    }

    @GetMapping("/job-instance")
    private List<Object[]> countJobInstancesByJobName(){
        return batchService.countJobInstancesByJobName();
    }

    @GetMapping("/search/{keyword}")
    public List<BatchJobExecution> searchByBatchName(@PathVariable String keyword) {
        return batchService.searchByBatchName(keyword);
    }

    @GetMapping("/job-executions-and-logs")
    public List<Object[]> getJobExecutionsAndLogs() {
        return batchjobexecutionRepository.getJobExecutionsAndLogs();
    }



}
