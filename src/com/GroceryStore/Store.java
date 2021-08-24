package com.GroceryStore;

import com.GroceryStore.Products.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Store {
    private List<Product> inventory = new ArrayList();
    private int balance = 500_00;
    private String name;

    public Store(String name) {
        this.name = name;
    }

    private void addToInventory(Product product) {
        inventory.add(product);
        inventory.sort(Product::compareTo);
    }

    //TODO: Beverage Version
    public void addBeverageToInventory(Beverage beverage) {
        addToInventory(beverage);
    }

    public void addToInventory(String name, int price, String id, String description) {
        Beverage beverage = new Beverage(name, price, id, description);
        addToInventory(beverage);
    }

    public void addToInventory(String name, int price, String id, String description, String volume) {
        Beverage beverage = new Beverage(name, price, id, description, volume);
        addToInventory(beverage);
    }

    //TODO Fruit version
    public void addFruitToInventory(Fruit fruit) {
        addToInventory(fruit);
    }

    public void addToInventory(String name, int price, String id, String description, boolean isOrganic, int hardness) {
        Fruit fruit = new Fruit(name, price, id, description, isOrganic, hardness);
        addToInventory(fruit);
    }

    public void addToInventory(String name, int price, String id, String description, int hardness) {
        Fruit fruit = new Fruit(name, price, id, description, hardness);
        addToInventory(fruit);
    }

    public void displayInventory() {
        System.out.println("Inventory of " + name);
        System.out.println("Fruits");
        for (Product product : inventory) {
            if (product instanceof Fruit) {
                System.out.println(product.toString());
            }
        }
        System.out.println("Beverages");
        for (Product product : inventory) {
            if (product instanceof Beverage) {
                System.out.println(product.toString());
            }
        }
    }


}
