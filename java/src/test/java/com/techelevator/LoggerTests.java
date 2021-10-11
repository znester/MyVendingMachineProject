package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerTests {

    Logger testLogger = new Logger("testLog.txt");


    @Test

    public void _01_test_transaction_int10_int20_outs_in_correct_string_sequence(){

        String actualOut = testLogger.logTransaction("test transaction", 10, 20);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        //Creates var of "now's" date/time
        LocalDateTime logNow = LocalDateTime.now();
        //Formats "now's" date/time
        String logDateAndTime = dtf.format(logNow);
        //Sets format for $
        DecimalFormat df = new DecimalFormat("0.00");
        //Converts penny math int to doubles
        Double money1InDollars = Double.valueOf(10) / 100;
        Double money2InDollars = Double.valueOf(20) / 100;
        //Defines format for log entry
        String expected = logDateAndTime + " " + "test transaction" + " $" + df.format(money1InDollars) + " $" + df.format(money2InDollars);

        Assert.assertEquals(expected, actualOut);

    }

    //(String transactionDetail, Integer money1, Integer money2)

}
