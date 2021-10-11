package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;

public class VendingMachineTests {

    VendingMachine testVend = new VendingMachine();

    @Test

    public void _01_chip_chippies_2dollars_dialog(){


        String actual = testVend.dispenseDialog("Chippies",2,"Chip");

        Double price = Double.valueOf(2)/100.00;
        DecimalFormat df = new DecimalFormat("0.00");

        String expected = "Dispensing " + "Chippies" + ", it cost $" + df.format(price) + ".";

        Assert.assertEquals(expected,actual);


    }





}
