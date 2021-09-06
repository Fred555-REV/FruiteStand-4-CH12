package com.GroceryStore.console;

import java.util.List;

public class English implements Language {
    @Override
    public List<String> MENU() {

        return List.of(
                "1. add product to inventory",
                "2. throw away a product",
                "3. list products available",
                "4. sell a product",
                "5. quit"
        );
    }

    @Override
    public List<String> PRODUCT_TYPES() {
        return List.of(
                "1. Beverage",
                "2. Fruit"
        );
    }

    @Override
    public String WELCOME() {
        return "Welcome to ";
    }

    @Override
    public String MENU_PROMPT() {
        return "What do you want to do?";
    }

    @Override
    public String SELECT_PROMPT() {
        return "Enter selection:";
    }

    @Override
    public String CANCEL_PROMPT() {
        return " press enter to cancel";
    }

    @Override
    public String PRODUCT_PROMPT() {
        return "What kind of product?";
    }

    @Override
    public List<String> ERROR_MSGS() {
        return List.of(
                "OK",
                "Invalid Number",
                "General Exception",
                "Must Enter Something",
                "Product Not Found");
    }

    @Override
    public List<String> PRODUCT_FIELDS() {
        return List.of(
                "Name:",
                "Price:",
                "Id:",
                "Description:"
        );
    }

    @Override
    public List<String> FRUIT_SPEC_FIELDS() {
        return List.of(
                "Hardness Level 1-10:",
                "Is Organic?:"
        );
    }

    @Override
    public List<String> BEVERAGE_SPEC_FIELDS() {
        return List.of(
                "Volume:",
                "Volume Unit Code:"
        );
    }

    @Override
    public String ENTER() {
        return "Enter";
    }
}
