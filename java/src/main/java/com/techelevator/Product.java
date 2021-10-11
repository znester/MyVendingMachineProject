package com.techelevator;

public class Product {

    //Instance variables
    private String name;
    private int price;
    private String productType;

    //Getters
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getProductType() {
        return productType;
    }

    //Default constructor
    public Product(){}

    //Overload constructor
    public Product(String name, String price, String productType){
        this.name = name;
        this.productType = productType;
        double priceDbl = Double.parseDouble(price);
        this.price = (int)(priceDbl*100);
    }
}
