package com.maybank.assessment;

import com.maybank.assessment.database.TransactionDao;
import com.maybank.assessment.service.TransactionService;
import com.maybank.assessment.service.TransactionServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MaybankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaybankApplication.class, args);
    }

    @Bean
    public TransactionService transactionService(TransactionDao transactionDao){
        return new TransactionServiceImpl(transactionDao);
    }

}
