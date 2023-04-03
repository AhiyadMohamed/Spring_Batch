package org.mahiyad.springbatch.config.processor;

import lombok.Getter;
import org.mahiyad.springbatch.data.entities.BankTransaction;
import org.springframework.batch.item.ItemProcessor;

@Getter
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction,BankTransaction> {
    private double totalDebit;
    private double totalCredit;

    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        if(bankTransaction.getTransactionType().equals("D")) totalDebit += bankTransaction.getAmount();
        else if (bankTransaction.getTransactionType().equals("C")) totalCredit += bankTransaction.getAmount();
        return bankTransaction;
    }
}
