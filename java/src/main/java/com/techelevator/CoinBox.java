package com.techelevator;

public class CoinBox {

    //Instance variables
    private int moneyDeposited;
    private int moneyBank; // how much money is int the coin box ***never used***

    //Getters
    public int getMoneyDeposited() {
        return moneyDeposited;
    }

    //public int getMoneyBank() { return moneyBank; }***also never used***

    //Default constructor
    public CoinBox(){
        this.moneyBank =0;
        this.moneyDeposited =0;
    }
//    //Overload constructor ***might not need this***
////    public CoinBox(int moneyDeposited, int moneyBank, int cost) {
////        this.moneyDeposited = moneyDeposited;
////        this.moneyBank = moneyBank;
//    }

    //Feed method
    public void feed(int amount) {
        this.moneyDeposited += amount;
    }

    //Spend method
    public void spend(int amount) {
        this.moneyDeposited -= amount;
    }

    //Make Change method ***We should delete this, not needed***
//    public double makeChange(int amountDeposited, int amountSpent) {
//        int change = amountDeposited - amountSpent;
//        return change;
//    }

    //Method figures out how many dollars, quarters, dimes, nickels, and pennies to give back
    public String dispenseChange() {
        //Here the cost has already been subtracted from money deposited, then set to amount
        int amount = this.moneyDeposited;
        //I'm not really sure what this does, need to rename or something
        moneyBank += amount;
        //Logic for determining amount of each
        int dollars = ((amount - (amount%100)))/100; //amount in 2367 - 2300 (23 dollars out)
        amount = amount%100;
        int numQuarters = ((amount - (amount%25)))/25;
        amount = amount%25;
        int numDimes = ((amount - (amount%10)))/10;
        amount = amount%10;
        int numNickles = ((amount - (amount%5)))/5; //1466 - (1466%25)"16" = 1450
        amount = amount%5;
        int numPennies = amount;
        //Sets money deposited back to 0
        this.moneyDeposited = 0;

        //Formats change statement
        String changeStatement = "Your change is $" +dollars + ", " + numQuarters + " Quarter(s), " + numDimes + " Dime(s), "
                + numNickles + " Nickle(s), " + numPennies+ " Pennie(s)";
        System.out.println(changeStatement);
        return changeStatement;
    }
}
