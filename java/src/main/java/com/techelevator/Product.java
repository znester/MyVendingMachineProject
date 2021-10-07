package com.techelevator;

public class Product {

    private String name;
    private int price;
    private String productType;

    public Product(String name, String price, String productType){
        this.name = name;
        this.productType = productType;
        Double priceDbl = Double.valueOf(price);
        this.price = (int)(priceDbl*100);

    }

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
}
