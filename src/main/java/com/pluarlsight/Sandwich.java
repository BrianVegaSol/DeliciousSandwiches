package com.pluarlsight;

import java.util.Objects;

public class Sandwich extends Order {
    private Bread bread;
    private Topping toppings;
    private double combinedPrice;
    private boolean isToasted;
    private static StringBuilder sb = new StringBuilder();
    //TASK Try to have Bread and Topping become interfaces and have Sandwich implement both
    // OR have Bread and Toppings extend Sandwich (y tho???)

    //TASK Both Bread and Toppings need to keep track of their own prices
    // So they can be tallied when Confirming the Sandwich order at the end of the dynamicMenu()

    //FIXME Make sure that when asking for toasted or not, to add that to the String where Sandwich
    // is being displayed, otherwise will need to make a Sandwich enum with String "Toasted"
    public Sandwich(Bread bread, Topping toppings, boolean isToasted) {
        super();
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;
        //TASK this is only for one Sandwich, to get the Total for the whole order, will need to tally
        // EITHER everytime that a new Sandwich & OtherProduct is made, static total++ (reset when clearing all orders)
        // OR Have the Hashmap get all the entries and all their totals that way?
        this.combinedPrice = bread.getBreadMenuPrice() + toppings.getPremToppingsTotalPrice();
    }

    public Sandwich() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Sandwich sandwich = (Sandwich) obj;
        return bread == bread.getBread() && toppings == getToppings();
    }

    @Override
    public int hashCode() {
        return Objects.hash(bread, toppings);
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

   /* @Override
    public String toString() {*/
    //@Override
    /*public String print (String function, long count) {
        sb.setLength(0);
        sb.append("\033[33m").append("Custom ").append("\033[0m");

        if (isToasted) {
            sb.append("\033[93m").append("Toasted ").append("\033[0m");
        }

        sb.append("\033[33m").append("Sandwich Details\n===============================\n\n").append("\033[0m");
        if (function.equalsIgnoreCase("Checkout")) {
            sb.append("\033[33m").append("Quantity: ").append(count).append("\033[0m");
        }
                sb.append(bread.print())
                .append(toppings.print());
                //.append("\033[92m").append(String.format("Subtotal: $%.2f%n", combinedPrice)).append("\033[0m");
        //System.out.print(sb.toString());
        //sb.setLength(0);
        return sb.toString();
        //TASK if toasted, then add "Toasted", no need for else if false
         *//*"Custom" + isToasted + "Sandwich Details\n" + bread.toString() +
                "\n\n" +
                toppings.toString();*//*
    }*/
    public String print(String function, long count) {
        sb.setLength(0);
        if (function.equalsIgnoreCase("Receipt")) {
            if ( this instanceof SignatureSandwich) {
                sb.append(signatureName);
            }
            sb.append("Custom");
            if (isToasted) {
                sb.append("Toasted");
            }
            sb.append("Sandwich Details\n===============================\n")
                    .append("Quantity: ").append(count)
                    .append("\n\n")
                    .append(bread.print(function))
                    .append(toppings.print(function))
                    .append("\n----------------------------------------------------------------------------------------\n")
                    .append(String.format("Sandwich Cumulative Price: $%.2f%n%n", combinedPrice * count));
            return sb.toString();
        }

        //EXPLAIN For most cases
        sb.append("\033[33m").append("Custom ").append("\033[0m");
        if (isToasted) {
            sb.append("\033[93m").append("Toasted ").append("\033[0m");
        }
        sb.append("\033[33m").append("Sandwich Details\n===============================\n").append("\033[0m");
        sb.append("\033[33m").append("Quantity: ").append(count).append("\033[0m");
        sb.append("\n\n");
        //FIXME May cause issues
        sb.append(bread.print(function))
                .append(toppings.print("Print"))
                .append("\n----------------------------------------------------------------------------------------\n")
                .append("\033[92m").append(String.format("Sandwich Cumulative Price: $%.2f%n%n", combinedPrice * count))
                .append("\033[0m");
        //System.out.print(sb.toString());
        //sb.setLength(0);
        return sb.toString();
        //TASK if toasted, then add "Toasted", no need for else if false
         /*"Custom" + isToasted + "Sandwich Details\n" + bread.toString() +
                "\n\n" +
                toppings.toString();*/
    }

}
