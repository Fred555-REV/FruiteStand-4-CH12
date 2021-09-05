package com.GroceryStore.console;

import com.GroceryStore.Products.Beverage;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TODO make the ui system loop until it exits

public class EnglishUI {
    private Store store;
    private static Scanner scanner = new Scanner(System.in);
    private final static List<String> MENU = List.of(
            "1. add product to inventory",
            "2. throw away a product",
            "3. list products available",
            "4. sell a product",
            "5. quit"
    );
    private final static List<String> PRODUCT_TYPES = List.of(
            "1. Beverage",
            "2. Fruit"
    );
    private final static String WELCOME = "Welcome to ";
    private final static String MENU_PROMPT = "What do you want to do?";
    private final static String SELECT_PROMPT = "Enter selection:";
    private final static String CANCEL_PROMPT = " press enter to cancel";
    private final static String PRODUCT_PROMPT = "What kind of product?";
    private final static List<String> ERROR_MSGS = List.of(
            "OK",
            "Invalid Number",
            "General Exception",
            "Must Enter Something",
            "Product Not Found");
    private final static List<String> PRODUCT_FIELDS = List.of(
            "Name:",
            "Price:",
            "Id:",
            "Description:"
    );
    private final static List<String> FRUIT_SPEC_FIELDS = List.of(
            "Hardness Level 1-10:",
            "Is Organic?:"
    );
    private final static List<String> BEVERAGE_SPEC_FIELDS = List.of(
            "Volume:",
            "Volume Unit Code:"
    );
    private final static String ENTER = "Enter ";

    public EnglishUI(Store store) {
        this.store = store;
    }

    public static void welcome(String name) {
        System.out.println(WELCOME + name + "!");
    }

    public static void displayOptions(String prompt, List<String> options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public boolean start() {
        welcome(store.getName());
        displayOptions(MENU_PROMPT, MENU);
        int choice = getInt(SELECT_PROMPT, 1, 5);
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
                System.out.println(ERROR_MSGS.get(1));
            } catch (Exception err) {
                System.out.println(ERROR_MSGS.get(2));
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
                System.out.println(ERROR_MSGS.get(3));
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
                System.out.println(ERROR_MSGS.get(1));
                break;
        }
        return true;
    }

    private void addProduct() {
        displayOptions(PRODUCT_PROMPT, PRODUCT_TYPES);
        int choice = getInt(SELECT_PROMPT, 1, PRODUCT_TYPES.size());
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
                System.out.println(ERROR_MSGS.get(1));
                newProduct = null;
                break;
        }
        store.addToInventory(newProduct);
    }

    private static Beverage getBeverageDetails() {
        return new Beverage(
                getString(ENTER + PRODUCT_FIELDS.get(0), true),
                getInt(ENTER + PRODUCT_FIELDS.get(1), 0, Integer.MAX_VALUE),
                getString(ENTER + PRODUCT_FIELDS.get(2), true),
                getString(ENTER + PRODUCT_FIELDS.get(3), false),
                getInt(ENTER + BEVERAGE_SPEC_FIELDS.get(0), 1, Integer.MAX_VALUE),
                getInt(ENTER + BEVERAGE_SPEC_FIELDS.get(1), 1, Beverage.UNITS.length - 1)
        );
    }

    private static Fruit getFruitDetails() {

        return new Fruit(
                getString(ENTER + PRODUCT_FIELDS.get(0), true),
                getInt(ENTER + PRODUCT_FIELDS.get(1), 0, Integer.MAX_VALUE),
                getString(ENTER + PRODUCT_FIELDS.get(2), true),
                getString(ENTER + PRODUCT_FIELDS.get(3), true),
                getInt(ENTER + FRUIT_SPEC_FIELDS.get(0), 1, 10)
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
        Product prod = selectProduct(SELECT_PROMPT + CANCEL_PROMPT);
        if (prod == null) {
            System.out.println(ERROR_MSGS.get(4));
            return;
        }
        store.throwAway(prod);
    }

    private void sellProduct() {
        Product prod = selectProduct(SELECT_PROMPT + CANCEL_PROMPT);
        if (prod == null) {
            System.out.println(ERROR_MSGS.get(4));
            return;
        }
        store.purchase(prod);
    }

}