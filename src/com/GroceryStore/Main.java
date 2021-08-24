package com.GroceryStore;

import com.GroceryStore.Products.Beverage;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;

public class Main {
    public static void main(String[] args) {
        Product prod = new Product("Apple", 89, "p-001", "Red Apple");
        Product prod2 = new Fruit("Orange", 550, "p-002", "Bag of Green Orange", 5);
        Product prod3 = new Product("Milk", 4_00, "b-001", "Gallon of Milk");
        Product prod4 = new Beverage("Orange Juice", 4_99, "b-002", "Pulp", "2 qts");
//        System.out.println(prod);
//        System.out.println(prod2);
//        System.out.println(prod3);
//        System.out.println(prod4);

        Store store = new Store("Fruite Stande");
        store.addBeverageToInventory(new Beverage("Orange Juice", 4_99, "d-002", "Pulp", "2 qts"));
        store.addFruitToInventory(new Fruit("Orange", 550, "p-002", "Bag of Green Orange", 5));
        store.addToInventory(new Product("Apple", 89, "p-001", "Red Apple"));
        store.addToInventory("Orange Juice", 4_99, "b-001", "Pulp");
        store.addToInventory("Milk", 4_99, "b-002", "Whole Milk", "1 gl");
        store.addToInventory("Apple", 89, "p-001", "Red Apple", 4);
        store.displayInventory();

    }
}
