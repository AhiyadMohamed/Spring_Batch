package org.mahiyad.springbatch.data.repositories;

import org.mahiyad.springbatch.data.entities.BatchJobInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchJobIntanceRepository extends JpaRepository<BatchJobInstance,Long> {

    @Query("SELECT DISTINCT j.jobName FROM BatchJobInstance j")
    List<String> findDistinctJobNames();

    @Query("SELECT COUNT(DISTINCT ji.jobName) FROM BatchJobInstance ji WHERE ji.jobName IS NOT NULL")
    int countDistinctBatchInstances();

    @Query("SELECT ji.jobName, COUNT(ji) FROM BatchJobInstance ji GROUP BY ji.jobName")
    List<Object[]> countJobInstancesByJobName();

}
