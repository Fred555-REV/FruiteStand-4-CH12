package com.GroceryStore.konsole;

import java.util.Scanner;

public interface UserInterface {
    Scanner scanner = new Scanner(System.in);

//TODO FINISH START

//    void start();

    static int getInt(String prompt, int min, int max, String errorMsg) {
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
}
