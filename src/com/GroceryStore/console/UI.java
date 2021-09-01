package com.GroceryStore.console;

import com.GroceryStore.Products.Beverage;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Store;

import java.util.Scanner;

//TODO make the ui system loop until it exits

public class UI {
    private Store store;
    private static Scanner scanner = new Scanner(System.in);
    private final static String[] MENU = new String[]{
            "1. add product to inventory",
            "2. throw away a product",
            "3. list products available",
            "4. sell a product",
            "5. quit"
    };
    private final static String[] PRODUCT_TYPES = new String[]{
            "1. Beverage",
            "2. Fruit",
    };

    public UI(Store store){
        this.store = store;
    }

    public static void welcome(String name) {
        System.out.println("Welcome to " + name + "!");
    }

    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public boolean start() {
        welcome(store.getName());
        displayOptions("What do you want to do?", MENU);
        int choice = getInt("Enter selection between 1 and 5:", 1, 5);
        return handleMenuSelection(choice);
    }

    public static int getInt(String prompt, int min, int max) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println("Invalid number");
            } catch (Exception err) {
                System.out.println("general exception");
            }
//            finally {
//                System.out.println("HI there");
//            }
            //code here
        } while (option < min || option > max);
        return option;
    }

    public static String getString(String prompt, boolean isRequired) {
        String input;

        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (isRequired && input.length() == 0) {
                System.out.println("Must enter something");
                continue;
            }
            break;
        } while (true);

        return input;
    }

    public boolean handleMenuSelection(int choice) {
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                throwAwayProduct();
                break;
            case 3:
                displayProducts();
                break;
            case 4:
                sellProduct();
                break;
            case 5:
                return false;
            default:
                System.out.println("invalid number received");
                break;
        }
        return true;
    }

    private void addProduct() {
        displayOptions("What kind of product?", PRODUCT_TYPES);
        int choice = getInt("enter a number", 1, PRODUCT_TYPES.length);
        Product newProduct;
        switch (choice) {
            case 1:
                newProduct = getBeverageDetails();
                // TODO: implement the following method use getBeverageDetails as reference
                break;
            case 2:
                newProduct = getFruitDetails();
                break;
            default:
                System.out.println("error bad type");
                newProduct = null;
                break;
        }
        store.addToInventory(newProduct);
    }

    private static Beverage getBeverageDetails() {
        return new Beverage(
                getString("Enter Beverage Name", true),
                getInt("Enter Price?", 0, Integer.MAX_VALUE),
                getString("Enter Id: ", true),
                getString("Enter Description: ", false),
                getInt("Enter Volume", 1, Integer.MAX_VALUE),
                getInt("Enter Volume Unit", 1, Beverage.UNITS.length - 1)
        );
    }

    private static Fruit getFruitDetails() {

        return new Fruit(
                getString("Enter Fruit name", true),
                getInt("Enter price", 0, Integer.MAX_VALUE),
                getString("Enter ID", true),
                getString("Enter Description", true),
                getInt("Enter hardness 1-10", 1, 10)
        );

    }

    private void displayProducts() {
        System.out.println(store.getInventory());
    }

    private Product selectProduct(String prompt) {
        displayProducts();
        String choice = getString(prompt, false);
        return store.getProduct(choice);
    }


    private void throwAwayProduct() {
        Product prod = selectProduct("Which product id to throw away? press enter to cancel");
        if (prod == null) {
            System.out.println("404 - Product not Found");
            return;
        }
        store.throwAway(prod);
    }

    private void sellProduct() {
        Product prod = selectProduct("Which product id to purchase? press enter to cancel");
        if (prod == null) {
            System.out.println("404 - Product not Found");
            return;
        }
        store.purchase(prod);
    }

}