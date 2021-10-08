package com.techelevator;

public class CoinBox {

    private int moneyDeposited= 0;
    private int moneyBank = 0; // how much money is int the coin box


    public CoinBox(){
        this.moneyBank =0;
        this.moneyDeposited =0;
    }

    public CoinBox(int moneyDeposited, int moneyBank, int cost) {
        this.moneyDeposited = moneyDeposited;
        this.moneyBank = moneyBank;

    }

    public void feed(int amount) {
        this.moneyDeposited += amount;
    }

    public void spend(int amount) {
        this.moneyDeposited -= amount;
    }

    //****************
    public double makeChange(int amountDeposited, int amountSpent) {
        int change = amountDeposited - amountSpent;
        return change;
    }
    //****************

    public int getMoneyDeposited() {
        return moneyDeposited;
    }

    public int getMoneyBank() {
        return moneyBank;
    }

    public String dispenseChange() {

        Integer amount = this.moneyDeposited;

        moneyBank += amount;

        int dollars = ((amount - (amount%100)))/100; //amount in 2367 - 2300 (23 dollars out)
        amount = amount%100;

        int numQuarters = ((amount - (amount%25)))/25;
        amount = amount%25;

        int numDimes = ((amount - (amount%10)))/10;
        amount = amount%10;

        int numNickles = ((amount - (amount%5)))/5; //1466 - (1466%25)"16" = 1450
        amount = amount%5;

        int numPennies = amount;

        this.moneyDeposited = 0;

        String changeStatement = "Your change is $" +dollars + " Dollars, " + numQuarters + " Quarters, " + numDimes + " Dimes, " + numNickles + " Nickles, " + numPennies+ " Pennies";
        System.out.println(changeStatement);


        return changeStatement;

    }

}
