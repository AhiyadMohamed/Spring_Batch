package org.mahiyad.springbatch.data.repositories;

import org.mahiyad.springbatch.data.entities.BatchJobExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BatchjobexecutionRepository extends JpaRepository<BatchJobExecution,Long> {


    @Query("SELECT COUNT(je) FROM BatchJobExecution je WHERE je.status = 'COMPLETED'")
    long countCompletedJobExecutions();

    @Query("SELECT COUNT(je) FROM BatchJobExecution je WHERE je.status = 'FAILED'")
    long countFailedJobExecutions();

    @Query("SELECT COUNT(je) FROM BatchJobExecution je WHERE je.status = 'STOPPED'")
    long stoppedFailedJobExecutions();





}
