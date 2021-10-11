package com.techelevator;

public class CoinBox {

    //Instance variables
    private int moneyDeposited;

    //Getters
    public int getMoneyDeposited() {
        return moneyDeposited;
    }

    //Default constructor
    public CoinBox(){
        this.moneyDeposited =0;
    }

    //Feed method
    public void feed(int amount) {
        this.moneyDeposited += amount;
    }

    //Spend method
    public void spend(int amount) {
        this.moneyDeposited -= amount;
    }

    //Method figures out how many dollars, quarters, dimes, nickels, and pennies to give back
    public String dispenseChange() {
        //Here the cost has already been subtracted from money deposited, then set to amount
        int amount = this.moneyDeposited;
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
