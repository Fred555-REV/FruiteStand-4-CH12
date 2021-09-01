package com.GroceryStore.Products;

import java.text.NumberFormat;

@SuppressWarnings("ALL")
public abstract class Product extends Object {
    private String name;
    private int price;
    public final String id;
    private String description;

    public Product(String name, int price, String id, String description) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.description = description;
    }

    private String getDisplayPrice() {
        return NumberFormat.getCurrencyInstance().format(price / 100.0);
    }

    @Override
    public String toString() {
        String output = "| id: " + id + " | name: " + name + " | price: " + getDisplayPrice() + " | ";
        return output;
    }

    public int getPrice() {
        return price;
    }

    public int compareTo(Product compareProduct) {
        String comparage = compareProduct.id;
        return this.id.compareTo(comparage);
    }
}
