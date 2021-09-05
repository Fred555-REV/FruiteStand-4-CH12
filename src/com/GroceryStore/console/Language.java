package com.GroceryStore.console;

import java.util.List;

public interface Language {
    List<String> MENU();
    List<String> PRODUCT_TYPES();
    String WELCOME();
    String MENU_PROMPT();
    String SELECT_PROMPT();
    String CANCEL_PROMPT();
    String PRODUCT_PROMPT();
    List<String> ERROR_MSGS();
    List<String> PRODUCT_FIELDS();
    List<String> FRUIT_SPEC_FIELDS();
    List<String> BEVERAGE_SPEC_FIELDS();
    String ENTER();
}
