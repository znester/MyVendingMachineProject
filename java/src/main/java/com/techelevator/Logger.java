package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    //Instance variables
    private final String PATH_TO_LOG_FILE;
    private final File LOG_FILE;
    //Need another file for "Sales Report" if we do it

    //Default constructor
    public Logger(String pathToLogFile, File logFile) {
        this.PATH_TO_LOG_FILE = pathToLogFile;
        this.LOG_FILE = logFile;
    }
    //Overload constructor w/logic for create new log.txt file if does not exist
    public Logger(String pathToLogFile) {
        this.PATH_TO_LOG_FILE = pathToLogFile;
        this.LOG_FILE = new File(pathToLogFile);

       try{ if(LOG_FILE.createNewFile()){ //creates new log.txt file if it does not already exist, can delete this if statement later
           System.out.println(this.PATH_TO_LOG_FILE + " created");
           System.out.println(LOG_FILE.getAbsolutePath());
        } else{
           System.out.println(this.PATH_TO_LOG_FILE + " already exists");
           System.out.println(LOG_FILE.getAbsolutePath());
       }
       } catch (IOException ioEx){
           System.out.println("I/O exception");
       }

    }
    //Method to write transaction logs to the file
    public void logTransaction(String transactionDetail, Integer money1, Integer money2) {
        //Formats date/time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        //Creates var of "now's" date/time
        LocalDateTime logNow = LocalDateTime.now();
        //Formats "now's" date/time
        String logDateAndTime = dtf.format(logNow);
        //Sets format for $
        DecimalFormat df = new DecimalFormat("0.00");
        //Converts penny math int to doubles
        Double money1InDollars = Double.valueOf(money1) / 100;
        Double money2InDollars = Double.valueOf(money2) / 100;
        //Defines format for log entry
        String logEntry = logDateAndTime + " " + transactionDetail + " $" + df.format(money1InDollars) + " $" + df.format(money2InDollars);

        //Appends above log entry to file of a new line
        try(PrintWriter writeToLogFile = new PrintWriter(new FileOutputStream(LOG_FILE,true))) {
            writeToLogFile.println(logEntry);
        } catch (IOException ioEx) {
            System.out.println("I/O Exception");
        }
    }
    //Method to separate log entries, "*****" is printed after "End Transaction" is selected
    public void logSeparator() {
        try(PrintWriter writeToLogFile = new PrintWriter(new FileOutputStream(LOG_FILE,true))) {
            writeToLogFile.println("*****");
        } catch (IOException ioEx) {
            System.out.println("Something can go wrong");
        }
    }
}
