package org.mahiyad.springbatch.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private Long accountID;
    private Date transactionDate;
    @Transient
    private String strTransactionDate;
    private String transactionType ;
    private Double amount;

}
