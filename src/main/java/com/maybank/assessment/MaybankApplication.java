package com.maybank.assessment;

import com.maybank.assessment.database.TransactionDao;
import com.maybank.assessment.service.TransactionService;
import com.maybank.assessment.service.TransactionServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MaybankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaybankApplication.class, args);
    }

    @Bean
    public TransactionService transactionService(TransactionDao transactionDao){
        return new TransactionServiceImpl(transactionDao);
    }

}
