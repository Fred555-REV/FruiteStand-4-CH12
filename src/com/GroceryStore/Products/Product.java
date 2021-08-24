package com.GroceryStore.Products;

import java.text.NumberFormat;

@SuppressWarnings("ALL")
public class Product extends Object {
    private String type;
    private String supplier;
    private String name;
    private int price;
    private String id;
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
        return String.format("|id: %s\t|name: %s\t|price: %s\t|description: %s\t", id, name, getDisplayPrice(), description);
    }

    public int compareTo(Product compareProduct) {
        String comparage = compareProduct.id;
        return this.id.compareTo(comparage);
    }
}
