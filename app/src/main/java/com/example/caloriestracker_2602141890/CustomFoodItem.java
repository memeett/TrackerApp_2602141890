package com.example.caloriestracker_2602141890;


public class CustomFoodItem implements Information {
    private String itemName;
    private double itemCalories;

    public CustomFoodItem(String itemName, double itemCalories) {
        this.itemName = itemName;
        this.itemCalories = itemCalories;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemCalories() {
        return itemCalories;
    }

    public void setItemCalories(double itemCalories) {
        this.itemCalories = itemCalories;
    }

    @Override
    public String getDetails() {
        return "Item name: " + getItemName() + "\nCalories: " + getItemCalories();
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
