package com.pluarlsight;

public class Sandwich{
    private Bread bread;
    private Toppings toppings;
    private double combinedPrice;
    private boolean isToasted;
    //TASK Try to have Bread and Topping become interfaces and have Sandwich implement both
    // OR have Bread and Toppings extend Sandwich (y tho???)

    //TASK Both Bread and Toppings need to keep track of their own prices
    // So they can be tallied when Confirming the Sandwich order at the end of the dynamicMenu()


    public Sandwich(Bread bread, Toppings toppings, double combinedPrice) {
        this.bread = bread;
        this.toppings = toppings;
        this.combinedPrice = combinedPrice;
    }
}
