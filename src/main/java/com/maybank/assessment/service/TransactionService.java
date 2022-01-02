package com.maybank.assessment.service;


import com.maybank.assessment.model.TransactionResponse;

public interface TransactionService {
    TransactionResponse processTransactionRequest(int pageSize, int pageNumber,
                                                  String customerId, String accountNumber,
                                                  String description);
}
