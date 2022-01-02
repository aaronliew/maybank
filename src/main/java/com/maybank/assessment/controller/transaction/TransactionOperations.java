package com.maybank.assessment.controller.transaction;


import com.maybank.assessment.model.TransactionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/transaction")
public interface TransactionOperations {
    @GetMapping("/")
    TransactionResponse getTransactions(@RequestParam("pageSize") int pageSize,
                                              @RequestParam("pageNumber") int pageNumber,
                                              @RequestParam("customerId") String customerId,
                                              @RequestParam("accountNumber") String accountNumber,
                                              @RequestParam("description") String description);

}
