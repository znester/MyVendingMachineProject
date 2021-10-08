package com.techelevator.view;

import com.techelevator.CoinBox;
import org.junit.Assert;
import org.junit.Test;

public class CoinBoxTests {
    CoinBox testBox = new CoinBox();

    @Test
    public void _01_Feeds_1000_Deposited_Equals_1000(){

        testBox.feed(1000);

        int actualAmount = testBox.getMoneyDeposited();

        Assert.assertEquals(1000,actualAmount);

    }

}
