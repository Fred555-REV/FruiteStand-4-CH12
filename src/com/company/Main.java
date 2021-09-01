package com.company;

import com.GroceryStore.Store;
import com.GroceryStore.console.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        Store store = new Store("Fruite Stand");
        while (ui.start(store));

    }
}
