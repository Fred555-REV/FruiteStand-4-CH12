package com.GroceryStore.console;

import com.GroceryStore.Products.Beverage;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Store;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TODO make the ui system loop until it exits

public class UI {
    private Store store;
    private static Scanner scanner = new Scanner(System.in);
    private Language lang;

    public UI(Store store) {
        this.store = store;
        setLang();
    }

    private void setLang() {
        int choice = getInt("(1)English\n(2)Español", 1, 2);
        switch (choice) {
            case 1:
                lang = new English();
                break;
            case 2:
                lang = new Spanish();
                break;
        }
    }

    public void welcome(String name) {
        System.out.println(lang.WELCOME() + name + "!");
    }

    public static void displayOptions(String prompt, List<String> options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public boolean start() {
        welcome(store.getName());
        displayOptions(lang.MENU_PROMPT(), lang.MENU());
        int choice = getInt(lang.SELECT_PROMPT(), 1, 5);
        return handleMenuSelection(choice);
    }

    public int getInt(String prompt, int min, int max) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println(lang.ERROR_MSGS().get(1));
            } catch (Exception err) {
                System.out.println(lang.ERROR_MSGS().get(2));
            }
//            finally {
//                System.out.println("HI there");
//            }
            //code here
        } while (option < min || option > max);
        return option;
    }

    public String getString(String prompt, boolean isRequired) {
        String input;

        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (isRequired && input.length() == 0) {
                System.out.println(lang.ERROR_MSGS().get(3));
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
                System.out.println(lang.ERROR_MSGS().get(1));
                break;
        }
        return true;
    }

    private void addProduct() {
        displayOptions(lang.PRODUCT_PROMPT(), lang.PRODUCT_TYPES());
        int choice = getInt(lang.SELECT_PROMPT(), 1, lang.PRODUCT_TYPES().size());
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
                System.out.println(lang.ERROR_MSGS().get(1));
                newProduct = null;
                break;
        }
        store.addToInventory(newProduct);
    }

    private Beverage getBeverageDetails() {
        return new Beverage(
                getString(lang.ENTER() + lang.PRODUCT_FIELDS().get(0), true),
                getInt(lang.ENTER() + lang.PRODUCT_FIELDS().get(1), 0, Integer.MAX_VALUE),
                getString(lang.ENTER() + lang.PRODUCT_FIELDS().get(2), true),
                getString(lang.ENTER() + lang.PRODUCT_FIELDS().get(3), false),
                getInt(lang.ENTER() + lang.BEVERAGE_SPEC_FIELDS().get(0), 1, Integer.MAX_VALUE),
                getInt(lang.ENTER() + lang.BEVERAGE_SPEC_FIELDS().get(1), 1, Beverage.UNITS.length - 1)
        );
    }

    private Fruit getFruitDetails() {

        return new Fruit(
                getString(lang.ENTER() + lang.PRODUCT_FIELDS().get(0), true),
                getInt(lang.ENTER() + lang.PRODUCT_FIELDS().get(1), 0, Integer.MAX_VALUE),
                getString(lang.ENTER() + lang.PRODUCT_FIELDS().get(2), true),
                getString(lang.ENTER() + lang.PRODUCT_FIELDS().get(3), true),
                getInt(lang.ENTER() + lang.FRUIT_SPEC_FIELDS().get(0), 1, 10)
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
        Product prod = selectProduct(lang.SELECT_PROMPT()+lang.CANCEL_PROMPT());
        if (prod == null) {
            System.out.println(lang.ERROR_MSGS().get(4));
            return;
        }
        store.throwAway(prod);
    }

    private void sellProduct() {
        Product prod = selectProduct(lang.SELECT_PROMPT()+lang.CANCEL_PROMPT());
        if (prod == null) {
            System.out.println(lang.ERROR_MSGS().get(4));
            return;
        }
        store.purchase(prod);
    }

}