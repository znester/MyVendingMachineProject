package com.techelevator.view;

import com.techelevator.CoinBox;
import org.junit.Assert;
import org.junit.Test;

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


}
