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

    @Autowired
    private BatchJobIntanceRepository batchJobIntanceRepository;


    @Override
    public List<BatchJobExecution> getAllExecution() {
        return jobExecutionRepository.findAll();
    }

    @Override
    public List<String> listBatch() {
        return batchJobIntanceRepository.findDistinctJobNames();
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


    @Override
    public int countDistinctBatches() {
        return batchJobIntanceRepository.countDistinctBatchInstances();
    }

    @Override
    public List<Object[]> countJobInstancesByJobName() {
        return batchJobIntanceRepository.countJobInstancesByJobName();
    }

    @Override
    public List<BatchJobExecution> searchByBatchName(String keyword) {
        return jobExecutionRepository.findByJobNameContaining(keyword);
    }


}
