package com.techelevator;

import com.techelevator.CoinBox;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CoinBoxTests {
    CoinBox testBox = new CoinBox();

    @Test
    public void _01_feed_1000_Deposited_Equals_1000(){
        testBox.feed(1000);
        int actualAmount = testBox.getMoneyDeposited();
        Assert.assertEquals(1000,actualAmount);
    }

    @Test
    public void _02_spend_1000_deposited_removes_1000() {
        testBox.feed(1100);
        testBox.spend(1000);
        int actualAmount = testBox.getMoneyDeposited();
        Assert.assertEquals(100, actualAmount);
    }

    @Test
    public void _03_dispense_1441_returns_changeStatement_14d_1q_1d_1n_1p() {
        testBox.feed(1441);
        String actualReturn = "Your change is $14, 1 Quarter(s), 1 Dime(s), 1 Nickle(s), 1 Pennie(s)";
        Assert.assertEquals(actualReturn, testBox.dispenseChange());
    }
}
