package com.techelevator;

public class Product {

    //Instance variables
    private String name;
    private int price;
    private String productType;

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getProductType() {
        return productType;
    }

    //Overload constructor
    public Product(String name, String price, String productType){
        this.name = name;
        this.productType = productType;
        double priceDbl = Double.parseDouble(price);
        this.price = (int)(priceDbl*100);
    }
    //Default constructor
    public Product(){}
}
