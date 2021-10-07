package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class VendingMachine {

    private SortedMap<String, Stack<Product>> inventory = new TreeMap<>(); //String = slot identifier , Stack<product> = inventory place content
    private CoinBox vmCoinBox = new CoinBox();


    public VendingMachine(String pathToInventoryFile) {

        File inputFile = new File(pathToInventoryFile);

        try (Scanner fileReader = new Scanner(inputFile)) { //file path >

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String [] newProDetail = line.split("\\|");
               //building the main inventory map
                Product newProduct = new Product(newProDetail[1],newProDetail[2],newProDetail[3]);
                Stack<Product> fiveOfNewProd = new Stack<>();
                for(int i = 0; i < 5; i++){
                    fiveOfNewProd.push(newProduct);
                }

                inventory.put(newProDetail[0],fiveOfNewProd);

            }

        } catch (Exception e) {
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


    public void feedMoney(){

        }

    public void selectProduct(){

        }

        

    public void finishTransaction(){

        }

    }


