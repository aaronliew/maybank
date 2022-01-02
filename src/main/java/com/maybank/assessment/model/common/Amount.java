package com.maybank.assessment.model.common;

import com.maybank.assessment.constant.Constants;

public class Amount {
    long value;
    String currency;
    String subCurrency;

    public Amount(){
        this.currency = Constants.Currency.MYR.getType();
        this.subCurrency = Constants.SubCurrency.CENT.getType();
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSubCurrency() {
        return subCurrency;
    }

    public void setSubCurrency(String subCurrency) {
        this.subCurrency = subCurrency;
    }
}
