package com.maybank.assessment.util;

import com.maybank.assessment.constant.Constants;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateUtil {
    public static String KL_TIME_ZONE = "Asia/Kuala_Lumpur";
    public static String TRANSACTION_RECORD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String STANDARD_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static final SimpleDateFormat transactionRecordDateFormat = new SimpleDateFormat(TRANSACTION_RECORD_DATE_FORMAT);
    private static final SimpleDateFormat standardDateFormat = new SimpleDateFormat(STANDARD_DATE_FORMAT);

    public static long convertToTimestamp(String date, String time) throws ParseException {
        String transactionDate = date + " " + time;
        TimeZone malaysianTimeZone = TimeZone.getTimeZone(KL_TIME_ZONE);
        transactionRecordDateFormat.setTimeZone(malaysianTimeZone);
        Date transactionDateObj = new Date(transactionRecordDateFormat.parse(transactionDate).getTime());
        return transactionDateObj.getTime();
    }

    public static String convertToStandardDateStringFormat(long timestamp) {
        TimeZone malaysianTimeZone = TimeZone.getTimeZone(KL_TIME_ZONE);
        standardDateFormat.setTimeZone(malaysianTimeZone);
        java.util.Date dateObj = new java.util.Date(timestamp);
        return standardDateFormat.format(dateObj.getTime());
    }
}
