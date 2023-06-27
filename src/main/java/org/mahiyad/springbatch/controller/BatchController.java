package org.mahiyad.springbatch.controller;

import org.mahiyad.springbatch.data.entities.BatchJobExecution;
import org.mahiyad.springbatch.data.repositories.BatchJobIntanceRepository;
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



}
