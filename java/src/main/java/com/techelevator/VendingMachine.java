package com.techelevator;
//import com.techelevator.Product;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


public class VendingMachine{

    private SortedMap<String, Stack<Product>> inventory = new TreeMap<String, Stack<Product>>(); //String = slot identifier , Stack<product> = inventory place content
    private CoinBox vmCoinBox = new CoinBox();
    private Logger vmLogger;

    // Vending machine constructor, builds inventory
    public VendingMachine(String pathToInventoryFile) {

        File inputFile = new File(pathToInventoryFile);

        try (Scanner fileReader = new Scanner(inputFile)) { //file path >

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String [] newProDetail = line.split("\\|");
               //building the main inventory map
                Product newProduct = new Product(newProDetail[1],newProDetail[2],newProDetail[3]);
                Stack<Product> fiveOfNewProd = new Stack<Product>();
                for(int i = 0; i < 5; i++){
                    fiveOfNewProd.push(newProduct);
                }

                inventory.put(newProDetail[0],fiveOfNewProd);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//Initializes this vending machine's Logger
    {
        try {
            vmLogger = new Logger("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayItems(){
            for(SortedMap.Entry<String,Stack<Product>> entry : inventory.entrySet()){

                if(!entry.getValue().isEmpty()) {

                    Double price = Double.valueOf(entry.getValue().peek().getPrice())/100.00;

                    DecimalFormat df = new DecimalFormat("0.00");

                    int stackDisplaySize = entry.getValue().size(); //**** MAKES it so display shows 5
                    String itemName = entry.getValue().peek().getName();

                    System.out.println(entry.getKey() + " | " + itemName + " | $" + df.format(price) + " | " + stackDisplaySize);
                    //Use String format to look pretty
                }else{

                    System.out.println(entry.getKey() + " | item is out of stock. ");

                }

             }
        }


    public void feedMoney(int feedDollarsInPennies){ //adds fed amount to vm's coin moneyDeposited
            vmCoinBox.feed(feedDollarsInPennies);
            vmLogger.logTransaction("FEED MONEY:", feedDollarsInPennies, vmCoinBox.getMoneyDeposited());

        }

    public void selectProduct(String slotIdentifier) {

        if (!inventory.get(slotIdentifier).empty()) {  //If not empty then dispense item
            if (inventory.get(slotIdentifier).peek().getPrice() <= vmCoinBox.getMoneyDeposited()) {

                String nameOfProduct = inventory.get(slotIdentifier).peek().getName();//gets name of product

                int moneyBefore = vmCoinBox.getMoneyDeposited(); // money before subtracted by cost of product

                vmCoinBox.spend(inventory.get(slotIdentifier).peek().getPrice()); //=money deposited - price of product

                inventory.get(slotIdentifier).pop();  //if enough money, dispensed

                vmLogger.logTransaction(nameOfProduct, moneyBefore, vmCoinBox.getMoneyDeposited());

            } else {
                System.out.println("Not enough money");
            }
        } else {
            System.out.println("Product sold out or does not exist");
        }
    }


    public void finishTransaction(){

        int moneyBefore = vmCoinBox.getMoneyDeposited();

        vmCoinBox.dispenseChange();//get money in coinbox and dispense it

        vmLogger.logTransaction("GIVE CHANGE:", moneyBefore, vmCoinBox.getMoneyDeposited());


        }

    public void exitDialogue() {

        vmLogger.logTransaction("TRANSACTION ENDED:", 0,0);
        vmLogger.logSeparator();//Puts space in between log entries

        System.out.println("Thank you for using Vendomatic4000, have a nice day.");
    }

    }


