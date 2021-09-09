package com.GroceryStore.konsole;

import com.GroceryStore.Products.Beverage;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Store;

import java.util.List;

public class English extends UI {

    public English(Store store) {
        super(store,
                List.of(
                        "1. add product to inventory",
                        "2. throw away a product",
                        "3. list products available",
                        "4. sell a product",
                        "5. quit",
                        "6. change language"
                ),
                List.of(
                        "1. Beverage",
                        "2. Fruit"
                ),
                "Welcome to ",
                "What do you want to do?",
                "Enter selection:",
                "What kind of product?",
                " press enter to cancel",
                List.of(
                        "OK",
                        "Invalid Number",
                        "General Exception",
                        "Must Enter Something",
                        "Product Not Found")
                ,
                List.of(
                        "Name:",
                        "Price:",
                        "Id:",
                        "Description:"
                ),
                List.of(
                        "Hardness Level 1-10:",
                        "Is Organic?:"
                ),
                List.of(
                        "Volume:",
                        "Volume Unit Code:"
                ),
                "Enter");
    }

}
