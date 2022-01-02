package com.maybank.assessment.service;

import com.maybank.assessment.database.TransactionDao;
import com.maybank.assessment.model.Transaction;
import com.maybank.assessment.model.TransactionResponse;
import com.maybank.assessment.model.common.Amount;
import com.maybank.assessment.model.common.Pagination;
import com.maybank.assessment.model.database.TransactionEntity;
import com.maybank.assessment.util.PaginationUtil;
import com.maybank.assessment.util.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService{

    TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionDao transactionDao){
        this.transactionDao = transactionDao;
    }

    @Override
    public TransactionResponse processTransactionRequest(int pageSize, int pageNumber,
                                                         String customerId, String accountNumber,
                                                         String description) {

        pageNumber = pageNumber - 1;
        TransactionResponse transactionResponse = new TransactionResponse();

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        customerId = reformatQueryString(customerId);
        accountNumber = reformatQueryString(accountNumber);
        description = reformatQueryString(description);

        Page<TransactionEntity> transactionEntities = transactionDao.getTransactionsByAccountNoAndCustomerIdAndDesc(accountNumber,
                customerId, description, pageable);

        List<Transaction> transactions = new ArrayList<>();
        for (TransactionEntity transactionEntity: transactionEntities){
           Transaction transaction = new Transaction();
           transaction.setTransactionId(transactionEntity.getTransactionId());
           transaction.setAccountNumber(transactionEntity.getAccountNumber());

           Amount amount = new Amount();
           amount.setValue(transactionEntity.getAmount());
           transaction.setAmount(amount);
           transaction.setCustomerId(transactionEntity.getCustomerId());
           transaction.setDescription(transactionEntity.getDescription());
           transaction.setTransactionDate(DateUtil.convertToStandardDateStringFormat(transactionEntity.getTransactionDate().getTime()));
           transaction.setRecordCreateDate(DateUtil.convertToStandardDateStringFormat(transactionEntity.getRecordCreateDate().getTime()));
           transaction.setRecordUpdateDate(DateUtil.convertToStandardDateStringFormat(transactionEntity.getRecordUpdateDate().getTime()));

           transactions.add(transaction);
        }

        transactionResponse.setRecords(transactions);

        Pagination pagination = PaginationUtil.createPagination((int)transactionEntities.getTotalElements(), pageSize, pageNumber);
        transactionResponse.setPagination(pagination);

        return transactionResponse;
    }

    private String reformatQueryString(String input){
        if (input==null || input.replace(" ", "").length() == 0){
            return null;
        } else {
            return "%" + input + "%";
        }
    }
}
