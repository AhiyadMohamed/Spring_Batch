package org.mahiyad.springbatch.data.repositories;

import org.mahiyad.springbatch.data.entities.BatchJobExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchjobexecutionRepository extends JpaRepository<BatchJobExecution,Long> {
}
