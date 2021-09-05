package com.GroceryStore.console;

import java.util.List;

public class English implements Language{
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
        return null;
    }

    @Override
    public String MENU_PROMPT() {
        return null;
    }

    @Override
    public String SELECT_PROMPT() {
        return null;
    }

    @Override
    public String CANCEL_PROMPT() {
        return null;
    }

    @Override
    public String PRODUCT_PROMPT() {
        return null;
    }

    @Override
    public List<String> ERROR_MSGS() {
        return null;
    }

    @Override
    public List<String> PRODUCT_FIELDS() {
        return null;
    }

    @Override
    public List<String> FRUIT_SPEC_FIELDS() {
        return null;
    }

    @Override
    public List<String> BEVERAGE_SPEC_FIELDS() {
        return null;
    }

    @Override
    public String ENTER() {
        return null;
    }
}
