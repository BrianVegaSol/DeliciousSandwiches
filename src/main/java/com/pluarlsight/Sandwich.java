package com.pluarlsight;

public class Sandwich{
    private Bread bread;
    private Topping toppings;
    private double combinedPrice;
    private boolean isToasted;
    //TASK Try to have Bread and Topping become interfaces and have Sandwich implement both
    // OR have Bread and Toppings extend Sandwich (y tho???)

    //TASK Both Bread and Toppings need to keep track of their own prices
    // So they can be tallied when Confirming the Sandwich order at the end of the dynamicMenu()


    public Sandwich(Bread bread, Topping toppings, boolean isToasted, double combinedPrice) {
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;
        this.combinedPrice = combinedPrice;
    }

    public Sandwich() {

    }

    public double getCombinedPrice() {
        return bread.getBreadMenuPrice() + toppings.getRegularToppingsMenuPrice() +
                toppings.getExtraToppingsMenuPrice();
    }

    public Bread getBread() {
        return bread;
    }

    public Topping getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return bread.toString() +
                "\n\n" +
                toppings.toString();
    }
}
