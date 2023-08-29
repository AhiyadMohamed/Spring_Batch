package org.mahiyad.springbatch.service;


import org.mahiyad.springbatch.data.entities.BatchJobExecution;

import java.util.List;

public interface BatchService {


    List<BatchJobExecution> getAllExecution();

    List<String> listBatch();

    long countCompletedJobExecutions();

    long countFailedJobExecutions();
    long countStoppedJobExecutions();


    int countDistinctBatches();

    List<Object[]> countJobInstancesByJobName();

    List<BatchJobExecution> searchByBatchName(String keyword);


}
