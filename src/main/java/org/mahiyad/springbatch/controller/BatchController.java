package org.mahiyad.springbatch.controller;


import org.mahiyad.springbatch.data.entities.BatchJobExecution;
import org.mahiyad.springbatch.data.entities.BatchJobInstance;
import org.mahiyad.springbatch.data.repositories.BatchJobIntanceRepository;
import org.mahiyad.springbatch.data.repositories.BatchjobexecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BatchController {

    @Autowired
    private BatchJobIntanceRepository instanceRepository;

    @Autowired
    private BatchjobexecutionRepository executionRepository;


    @GetMapping("/instance")
    List<BatchJobInstance> getAllInstance(){
        return instanceRepository.findAll();
    }

    @GetMapping("/execution")
    List<BatchJobExecution> getAllExecution(){
        return executionRepository.findAll();
    }


}
