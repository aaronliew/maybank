package com.maybank.assessment.constant;

public class Constants {

    public enum Currency{
        MYR("MYR");

        String type;

        Currency(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public enum SubCurrency{
        CENT("CENT");

        String type;

        SubCurrency(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
