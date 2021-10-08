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

                    System.out.println(entry.getKey() + " | " + entry.getValue().peek().getName() + " | $" + df.format(price) + " | " + entry.getValue().size());
                    //Use String format to look pretty
                }else{

                    System.out.println(entry.getKey() + "  is empty. ");

                }

             }
        }


    public void feedMoney(int feedDollarsInPennies){ //adds fed amount to vm's coin moneyDeposited
            vmCoinBox.feed(feedDollarsInPennies);
            vmLogger.logTransaction(" FEED MONEY:", feedDollarsInPennies, vmCoinBox.getMoneyDeposited());

        }

    public void selectProduct(){
            this.displayItems();
        }

    public void finishTransaction(){

        }

    public void exitDialogue() {
        System.out.println("Thank you for using Vendomatic4000, have a nice day.");
    }

    }


