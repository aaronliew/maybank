package com.maybank.assessment.controller.transaction;

import com.maybank.assessment.exception.InvalidPaginationException;
import com.maybank.assessment.model.TransactionResponse;
import com.maybank.assessment.service.TransactionService;
import com.maybank.assessment.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TransactionController implements TransactionOperations{

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionService transactionService;

    @Override
    public TransactionResponse getTransactions(int pageSize, int pageNumber,
                                                     String customerId, String accountNumber,
                                                     String description) {

        try {
            PaginationUtil.validatePagination(pageNumber, pageSize);
            TransactionResponse transactionResponse =
                    transactionService.processTransactionRequest(pageSize, pageNumber, customerId, accountNumber, description);
            return transactionResponse;
        } catch (InvalidPaginationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid page number or size");
        }
    }

}
