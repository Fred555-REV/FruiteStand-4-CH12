package com.GroceryStore;

import com.GroceryStore.Products.*;
import com.GroceryStore.konsole.English;
import com.GroceryStore.konsole.Spanish;
import com.GroceryStore.konsole.UI;
import com.GroceryStore.konsole.UserInterface;
import com.Util.Formatter;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Store {
    private List<Product> inventory = new ArrayList();
    private int balance = 500_00;
    private String name;
    public UserInterface ui;

    public Store(String name) {
        this.name = name;
        setLang();
        ui.start();
    }

    public void setLang() {
        int choice = UserInterface.getInt("(1) English\n(2) Español", 1, 2, "Invalid Number / Número invalido");
        switch (choice){
            case 1:
                ui = new English(this);
                break;
            case 2:
                ui = new Spanish(this);
                break;
        }
    }

    public void addToInventory(Product product) {
        inventory.add(product);
        inventory.sort(Product::compareTo);
    }

    //TODO: Beverage Version
    public void addBeverageToInventory(Beverage beverage) {
        addToInventory(beverage);
    }

    public void addToInventory(String name, int price, String id, String description, int volume, String volumeUnit) {
        Beverage beverage = new Beverage(name, price, id, description, volume, volumeUnit);
        addToInventory(beverage);
    }

    public void addToInventory(String name, int price, String id, String description, int volume, int volumeUnit) {
        Beverage beverage = new Beverage(name, price, id, description, volume, volumeUnit);
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


    public void throwAway(Product product) {
        inventory.remove(product);
    }

    public void purchase(Product product) {
        balance += product.getPrice();
        throwAway(product);
    }

    public String getInventory() {
        String output = "";
        for (Product prod : inventory) {
            output += prod + "\n";
        }
        return output;
    }

    public String getBalance() {
        return Formatter.getDisplayPrice(balance);
    }

    public String getName() {
        return name;
    }

    public Product getProduct(String id) {
        for (Product product : inventory) {
            if (product.id.equals(id)) {
                return product;
            }
        }
        return null;
    }
}
