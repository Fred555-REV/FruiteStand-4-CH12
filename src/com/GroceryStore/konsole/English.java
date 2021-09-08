package com.GroceryStore.konsole;

import com.GroceryStore.Products.Beverage;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Store;

import java.util.List;

public class English extends UI {

    public English(Store store) {
        super(store);
        MENU = List.of(
                "1. add product to inventory",
                "2. throw away a product",
                "3. list products available",
                "4. sell a product",
                "5. quit",
                "6. change language"
        );
        PRODUCT_TYPES = List.of(
                "1. Beverage",
                "2. Fruit"
        );
        ENTER = "Welcome to ";
        WELCOME = "What do you want to do?";
        MENU_PROMPT = "Enter selection:";
        SELECT_PROMPT = " press enter to cancel";
        PRODUCT_PROMPT = "What kind of product?";
        ERROR_MSGS = List.of(
                "OK",
                "Invalid Number",
                "General Exception",
                "Must Enter Something",
                "Product Not Found");
        ;
        PRODUCT_FIELDS = List.of(
                "Name:",
                "Price:",
                "Id:",
                "Description:"
        );
        FRUIT_SPEC_FIELDS = List.of(
                "Hardness Level 1-10:",
                "Is Organic?:"
        );
        BEVERAGE_SPEC_FIELDS = List.of(
                "Volume:",
                "Volume Unit Code:"
        );
    }

}
