package com.pluarlsight;

public class Sandwich{
    private Bread bread;
    private Topping toppings;
    private double combinedPrice;
    private boolean isToasted;
    static StringBuilder sb = new StringBuilder();
    //TASK Try to have Bread and Topping become interfaces and have Sandwich implement both
    // OR have Bread and Toppings extend Sandwich (y tho???)

    //TASK Both Bread and Toppings need to keep track of their own prices
    // So they can be tallied when Confirming the Sandwich order at the end of the dynamicMenu()

    //FIXME Make sure that when asking for toasted or not, to add that to the String where Sandwich
    // is being displayed, otherwise will need to make a Sandwich enum with String "Toasted"
    public Sandwich (Bread bread, Topping toppings, boolean isToasted) {
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;
        //TASK this is only for one Sandwich, to get the Total for the whole order, will need to tally
        // EITHER everytime that a new Sandwich & OtherProduct is made, static total++ (reset when clearing all orders)
        // OR Have the Hashmap get all the entries and all their totals that way?
        this.combinedPrice = bread.getBreadMenuPrice() + toppings.premToppingsTotalPrice;
    }

    public Sandwich() {

    }

    public double getCombinedPrice() {
        return combinedPrice;
    }

    public Bread getBread() {
        return bread;
    }

    public Topping getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        sb.append("\033[34m").append("Custom ").append("\033[0m");

        if (isToasted) {
            sb.append("\033[34m").append("Toasted ").append("\033[0m");
        }

        sb.append("\033[34m").append("Sandwich Details\n===============================\n").append("\033[0m")
                .append(bread)
                .append(toppings);
        System.out.println(sb.toString());
        sb.setLength(0);
        return "";
        //TASK if toasted, then add "Toasted", no need for else if false
         /*"Custom" + isToasted + "Sandwich Details\n" + bread.toString() +
                "\n\n" +
                toppings.toString();*/
    }
}
