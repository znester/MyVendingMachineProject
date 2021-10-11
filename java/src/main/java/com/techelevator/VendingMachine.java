package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class VendingMachine{


    //Instance variables
    private SortedMap<String, Stack<Product>> inventory = new TreeMap<String, Stack<Product>>(); //String = slot identifier , Stack<product> = inventory place content
    private CoinBox vmCoinBox = new CoinBox();
    private Logger vmLogger;

    //Default constructor
    public VendingMachine(){};

    // Vending machine constructor, builds inventory
    public VendingMachine(String pathToInventoryFile) {
        File inputFile = new File(pathToInventoryFile);
        try (Scanner fileReader = new Scanner(inputFile)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String [] newProDetail = line.split("\\|");

               //building the main inventory map
                Product newProduct = new Product(newProDetail[1],newProDetail[2],newProDetail[3]);
                Stack<Product> fiveOfNewProd = new Stack<Product>();
                //Puts 5 of each product with corresonding key(slot identifier)
                for(int i = 0; i < 5; i++){
                    fiveOfNewProd.push(newProduct);
                }
                inventory.put(newProDetail[0],fiveOfNewProd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Initializes this vending machine's Logger***I"m not sure why this is here***
    {
        vmLogger = new Logger("log.txt");
    }
    //Method displys items when user chooses "1" from main menu
    public void displayItems() {
        for (SortedMap.Entry<String, Stack<Product>> entry : inventory.entrySet()) {
            if (!entry.getValue().isEmpty()) {//.isEmpty() returns boolean
                Double price = Double.valueOf(entry.getValue().peek().getPrice()) / 100.00;
                DecimalFormat df = new DecimalFormat("0.00");
                int stackDisplaySize = entry.getValue().size();
                String itemName = entry.getValue().peek().getName();
                //Formats display to look nice
                System.out.printf("%s| %-18s | $ %s | %s %n", entry.getKey(), itemName, df.format(price), stackDisplaySize);
            } else {
                System.out.println(entry.getKey() + "| Item out of stock  | ****** | 0");
            }
        }
    }

    //Method adds fed amount to vm's coin moneyDeposited
    public void feedMoney(int feedDollarsInPennies){
            vmCoinBox.feed(feedDollarsInPennies);
            vmLogger.logTransaction("FEED MONEY:", feedDollarsInPennies, vmCoinBox.getMoneyDeposited());
    }

    //Method handles logic to select product/if not enough money or sold out
    public void selectProduct(String slotIdentifier) {
        if (!inventory.get(slotIdentifier).empty()) {  //If not empty then dispense item
            if (inventory.get(slotIdentifier).peek().getPrice() <= vmCoinBox.getMoneyDeposited()) { //If enough money to but selected item
                String nameOfProduct = inventory.get(slotIdentifier).peek().getName();//gets name of product
                int moneyBefore = vmCoinBox.getMoneyDeposited(); // money before subtracted by cost of product
                vmCoinBox.spend(inventory.get(slotIdentifier).peek().getPrice()); //=money deposited - price of product
                this.dispenseDialog(inventory.get(slotIdentifier).peek().getName(),inventory.get(slotIdentifier).peek().getPrice(), inventory.get(slotIdentifier).peek().getProductType());
                inventory.get(slotIdentifier).pop();  //if enough money, dispensed
                vmLogger.logTransaction(nameOfProduct, moneyBefore, vmCoinBox.getMoneyDeposited()); //Logs transaction
            } else {
                System.out.println("Please insert more money to make purchase");
            }
        } else {
            System.out.println("SOLD OUT");
        }
    }

    //Method gives back change
    public void finishTransaction(){
        int moneyBefore = vmCoinBox.getMoneyDeposited();
        vmCoinBox.dispenseChange();//get money in coinbox and dispense it
        vmLogger.logTransaction("GIVE CHANGE:", moneyBefore, vmCoinBox.getMoneyDeposited());
        }

    //Method handles exit message
    public void exitDialogue() {
        vmLogger.logTransaction("TRANSACTION ENDED:", 0,0);
        vmLogger.logSeparator();//Puts space in between log entries
        System.out.println("Thank you for using Vendomatic4000, have a nice day.");
    }

    //Method handles dispense message
    public String dispenseDialog(String itemName, int itemPrice, String productType){
        Double price = Double.valueOf(itemPrice)/100.00;
        DecimalFormat df = new DecimalFormat("0.00");

        String outDialog = "Dispensing " + itemName + ", it cost $" + df.format(price) + ".";
        System.out.println(outDialog);

        this.displayAmountInMachine();
        //Handles different messages for product types
        if(productType.equals("Chip")){
            System.out.println("Crunch Crunch, Yum!");
        } else if(productType.equals("Candy")){
            System.out.println("Munch Munch, Yum!");
        } else if(productType.equals("Drink")){
            System.out.println("Glug Glug, Yum!");
        } else if(productType.equals("Gum")){
            System.out.println("Chew Chew, Yum!");
        }else{
            System.out.println("Yum!");
        }

        return outDialog;
    }

    //Method shows money in machine during the current transaction
    public void displayAmountInMachine(){
        Double moneyInDollars = Double.valueOf(vmCoinBox.getMoneyDeposited())/ 100;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Current Balance: $" + df.format(moneyInDollars));
    }
}


