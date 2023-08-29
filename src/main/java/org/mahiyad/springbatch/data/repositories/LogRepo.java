package org.mahiyad.springbatch.data.repositories;

import org.mahiyad.springbatch.data.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepo extends JpaRepository<Log,Long> {

}
