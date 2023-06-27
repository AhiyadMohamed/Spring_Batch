package org.mahiyad.springbatch.service;


import org.mahiyad.springbatch.data.entities.BatchJobExecution;
import org.mahiyad.springbatch.data.repositories.BatchJobIntanceRepository;
import org.mahiyad.springbatch.data.repositories.BatchjobexecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class BatchServiceimpl implements BatchService{

    @Autowired
    private BatchjobexecutionRepository jobExecutionRepository;


    @Override
    public List<BatchJobExecution> getAllExecution() {
        return jobExecutionRepository.findAll();
    }

    @Override
    public long countCompletedJobExecutions() {
        return jobExecutionRepository.countCompletedJobExecutions();
    }

    @Override
    public long countFailedJobExecutions() {
        return jobExecutionRepository.countFailedJobExecutions();
    }

    @Override
    public long countStoppedJobExecutions() {
        return jobExecutionRepository.stoppedFailedJobExecutions();
    }




}
