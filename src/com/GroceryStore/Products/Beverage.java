package com.GroceryStore.Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Beverage extends Product {
    //    private final static List<String> volumes = new ArrayList();
//    private int volume;
//    private String volumeUnit
    private String volume;  //Because volume will not be changed string can store volume

    public Beverage(String name, int price, String id, String description, String volume) {
        super(name, price, id, description);
        this.volume = volume;
    }

    public Beverage(String name, int price, String id, String description) {
        super(name, price, id, description);
    }

    public String toString() {
        return String.format("%s|volume: %s\t", super.toString(), volume);
    }

}
