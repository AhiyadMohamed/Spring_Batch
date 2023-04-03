package org.mahiyad.springbatch.data.repositories;

import org.mahiyad.springbatch.data.entities.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransaction,Long> {
}
