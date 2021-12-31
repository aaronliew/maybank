package com.maybank.assessment.job.transaction;

import com.maybank.assessment.constant.Constants;
import com.maybank.assessment.model.database.TransactionEntity;
import com.maybank.assessment.model.job.transaction.Transaction;
import com.maybank.assessment.util.DateUtil;
import org.springframework.batch.item.ItemProcessor;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TransactionItemProcessor implements ItemProcessor<Transaction, TransactionEntity> {



    @Override
    public TransactionEntity process(Transaction transaction) throws Exception {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountNumber(transaction.getAccountNumber());
        long amountInSen = (long) (Double.parseDouble(transaction.getTransactionAmount()) * 100);
        transactionEntity.setAmount(amountInSen);
        transactionEntity.setDescription(transaction.getDescription());

        long timestamp = DateUtil.convertToTimestamp(transaction.getTransactionDate(), transaction.getTransactionTime());
        transactionEntity.setTransactionDate(new Timestamp(timestamp));
        transactionEntity.setCustomerId(transaction.getCustomerId());
        return transactionEntity;
    }
}
