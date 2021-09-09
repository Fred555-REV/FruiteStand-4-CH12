package com.GroceryStore.konsole;

import com.GroceryStore.Products.Beverage;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Store;

import java.util.List;
import java.util.Scanner;

public abstract class UI implements UserInterface {
    protected final List<String> MENU;
    protected final List<String> PRODUCT_TYPES;
    protected final String WELCOME;
    protected final String MENU_PROMPT;
    protected final String SELECT_PROMPT;
    protected final String PRODUCT_PROMPT;
    protected final String CANCEL_PROMPT;
    protected final List<String> ERROR_MSGS;
    protected final List<String> PRODUCT_FIELDS;
    protected final List<String> FRUIT_SPEC_FIELDS;
    protected final List<String> BEVERAGE_SPEC_FIELDS;
    protected final String ENTER;
    protected final Store store;
    protected static Scanner scanner = new Scanner(System.in);

    public UI(Store store, List<String> MENU,
              List<String> PRODUCT_TYPES,
              String WELCOME,
              String MENU_PROMPT,
              String SELECT_PROMPT,
              String PRODUCT_PROMPT,
              String CANCEL_PROMPT,
              List<String> ERROR_MSGS,
              List<String> PRODUCT_FIELDS,
              List<String> FRUIT_SPEC_FIELDS,
              List<String> BEVERAGE_SPEC_FIELDS,
              String ENTER) {
        this.store = store;
        this.MENU = MENU;
        this.PRODUCT_TYPES = PRODUCT_TYPES;
        this.WELCOME = WELCOME;
        this.MENU_PROMPT = MENU_PROMPT;
        this.SELECT_PROMPT = SELECT_PROMPT;
        this.PRODUCT_PROMPT = PRODUCT_PROMPT;
        this.CANCEL_PROMPT = CANCEL_PROMPT;
        this.ERROR_MSGS = ERROR_MSGS;
        this.PRODUCT_FIELDS = PRODUCT_FIELDS;
        this.FRUIT_SPEC_FIELDS = FRUIT_SPEC_FIELDS;
        this.BEVERAGE_SPEC_FIELDS = BEVERAGE_SPEC_FIELDS;
        this.ENTER = ENTER;

    }

    public void welcome(String name) {
        System.out.println(WELCOME + name + "!");
    }

    public static void displayOptions(String prompt, List<String> options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void start() {
        welcome(store.getName());
        while (true) {
            displayOptions(MENU_PROMPT, MENU);
            int choice = getInt(SELECT_PROMPT, 1, 6, ERROR_MSGS.get(1));
            handleMenuSelection(choice);
        }
    }

    public static int getInt(String prompt, int min, int max, String errorMsg) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println(errorMsg);
            }
        } while (option < min || option > max);
        return option;
    }

    public String getString(String prompt, boolean isRequired) {
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
            case 6:
                store.setLang();
            default:
                System.out.println(ERROR_MSGS.get(1));
                break;
        }
        return true;
    }

    protected void addProduct() {
        displayOptions(PRODUCT_PROMPT, PRODUCT_TYPES);
        int choice = getInt(SELECT_PROMPT, 1, PRODUCT_TYPES.size(), ERROR_MSGS.get(1));
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

    protected Beverage getBeverageDetails() {
        return new Beverage(
                getString(ENTER + PRODUCT_FIELDS.get(0), true),
                getInt(ENTER + PRODUCT_FIELDS.get(1), 0, Integer.MAX_VALUE, ERROR_MSGS.get(1)),
                getString(ENTER + PRODUCT_FIELDS.get(2), true),
                getString(ENTER + PRODUCT_FIELDS.get(3), false),
                getInt(ENTER + BEVERAGE_SPEC_FIELDS.get(0), 1, Integer.MAX_VALUE, ERROR_MSGS.get(1)),
                getInt(ENTER + BEVERAGE_SPEC_FIELDS.get(1), 1, Beverage.UNITS.length - 1, ERROR_MSGS.get(1))
        );
    }

    protected Fruit getFruitDetails() {

        return new Fruit(
                getString(ENTER + PRODUCT_FIELDS.get(0), true),
                getInt(ENTER + PRODUCT_FIELDS.get(1), 0, Integer.MAX_VALUE, ERROR_MSGS.get(1)),
                getString(ENTER + PRODUCT_FIELDS.get(2), true),
                getString(ENTER + PRODUCT_FIELDS.get(3), true),
                getInt(ENTER + FRUIT_SPEC_FIELDS.get(0), 1, 10, ERROR_MSGS.get(1))
        );

    }

    protected void displayProducts() {
        System.out.println(store.getInventory());
    }

    protected Product selectProduct(String prompt) {
        displayProducts();
        String choice = getString(prompt, false);
        return store.getProduct(choice);
    }


    protected void throwAwayProduct() {
        Product prod = selectProduct(SELECT_PROMPT);
        if (prod == null) {
            System.out.println(ERROR_MSGS.get(4));
            return;
        }
        store.throwAway(prod);
    }

    protected void sellProduct() {
        Product prod = selectProduct(SELECT_PROMPT);
        if (prod == null) {
            System.out.println(ERROR_MSGS.get(4));
            return;
        }
        store.purchase(prod);
    }


}
