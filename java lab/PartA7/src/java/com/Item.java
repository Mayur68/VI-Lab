package com;

public class Item {

    private String name;
    private int qty;
    private double price;

    public Item(String name, int qty, double price) {//constructor method.
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {//getter setter method.
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
