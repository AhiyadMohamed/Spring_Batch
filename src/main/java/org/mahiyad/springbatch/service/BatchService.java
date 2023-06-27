package org.mahiyad.springbatch.service;


import org.mahiyad.springbatch.data.entities.BatchJobExecution;

import java.util.List;

public interface BatchService {


    List<BatchJobExecution> getAllExecution();


    long countCompletedJobExecutions();

    long countFailedJobExecutions();
    long countStoppedJobExecutions();


}
