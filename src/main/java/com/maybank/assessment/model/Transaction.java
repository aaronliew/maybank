package com.maybank.assessment.model;

import com.maybank.assessment.model.common.Amount;

public class Transaction {
    int transactionId;
    String accountNumber;
    Amount amount;
    String customerId;
    String description;
    String transactionDate;
    String recordCreateDate;
    String recordUpdateDate;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getRecordCreateDate() {
        return recordCreateDate;
    }

    public void setRecordCreateDate(String recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }

    public String getRecordUpdateDate() {
        return recordUpdateDate;
    }

    public void setRecordUpdateDate(String recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }
}
