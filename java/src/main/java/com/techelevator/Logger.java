package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private String pathToLogFile;
    private File logFile;
    public Logger(String pathToLogFile, File logFile) {
        this.pathToLogFile = pathToLogFile;
        this.logFile = logFile;
    }


    public Logger(String pathToLogFile) throws IOException {
        this.pathToLogFile = pathToLogFile;
        this.logFile = new File(pathToLogFile);

       try{ if(logFile.createNewFile()){ //creates new log.txt file if it does not already exist, can delete this if statement later
           System.out.println(this.pathToLogFile + " created");
           System.out.println(logFile.getAbsolutePath());
        } else{
           System.out.println(this.pathToLogFile + " already exists");
           System.out.println(logFile.getAbsolutePath());
       }
       } catch (IOException io){
           System.out.println(io);
       }


    }

    public void logTransaction(String transactionDetail, Integer money1, Integer money2){
        //01/01/2016 12:00:15 PM FEED MONEY: $5.00 $10.00

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("/MM/dd/yyyy HH:mm:ss");

        LocalDateTime logNow = LocalDateTime.now();

        String logDateAndTime = dtf.format(logNow);

        //System.out.println(logDateAndTime);

        DecimalFormat df = new DecimalFormat("0.00");

        Double money1InDollars = Double.valueOf(money1)/100;

        Double money2InDollars = Double.valueOf(money2)/100;

        String logEntry = logDateAndTime + transactionDetail + " $"+ df.format(money1InDollars) + " $" + df.format(money2InDollars);
        //String logEntry = logDateAndTime + transactionDetail + " $"+ money1InDollars + " $" + money2InDollars;

        System.out.println(logEntry);

    }


}
