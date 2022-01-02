package com.maybank.assessment.model;

import com.maybank.assessment.model.common.BaseResponseWithPagination;

import java.util.List;

public class TransactionResponse extends BaseResponseWithPagination {
    List<Transaction> records;

    public List<Transaction> getRecords() {
        return records;
    }

    public void setRecords(List<Transaction> records) {
        this.records = records;
    }
}
