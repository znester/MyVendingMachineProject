package com.techelevator;

public class CoinBox {

    private int moneyDeposited= 0;
    private int moneyBank = 0; // how much money is int the coin box

    public CoinBox(){
        this.moneyBank =0;
        this.moneyDeposited =0;
    }

    public CoinBox(int moneyDeposited, int moneyBank) {
        this.moneyDeposited = moneyDeposited;
        this.moneyBank = moneyBank;
    }

    public void feed(int amount) {
        this.moneyDeposited += amount;
    }

    public void spend(int amount) {
        this.moneyDeposited -= amount;
    }

    public double makeChange(int amountDeposited, int amountSpent) {
        int change = amountDeposited - amountSpent;
        return change;
    }

    public int getMoneyDeposited() {
        return moneyDeposited;
    }

    public int getMoneyBank() {
        return moneyBank;
    }
}
