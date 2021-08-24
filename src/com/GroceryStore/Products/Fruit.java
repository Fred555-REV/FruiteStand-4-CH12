package com.GroceryStore.Products;

public class Fruit extends Product {
    private boolean isOrganic;
    private int hardness;

    public Fruit(String name, int price, String id, String description, int hardness) {
        super(name, price, id, description);
        this.isOrganic = false;
        this.hardness = hardness;
    }

    public Fruit(String name, int price, String id, String description, boolean isOrganic, int hardness) {
        super(name, price, id, description);
        this.isOrganic = isOrganic;
        this.hardness = hardness;
    }

    public int getHardness() {
        return hardness;
    }

    public String toString() {
        return String.format("%s|isOrganic: %s \t|hardness: %s\t", super.toString(), isOrganic, hardness);
    }
}
