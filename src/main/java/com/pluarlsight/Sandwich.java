package com.pluarlsight;

import java.util.Objects;

public class Sandwich extends Order {
    private Bread bread;
    private Topping toppings;
    private double combinedPrice;
    private boolean isToasted;
    private String signatureName;
    private static StringBuilder sb = new StringBuilder();

    public Sandwich(Bread bread, Topping toppings, boolean isToasted) {
        super();
        this.bread = bread;
        this.toppings = toppings;
        this.isToasted = isToasted;
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

    public String getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
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


    public String print(String function, long count) {
        sb.setLength(0);

        if (function.equalsIgnoreCase("Receipt")) {
            if (signatureName != null || this instanceof SignatureSandwich) {
                if (isToasted) {
                    sb.append("Toasted ");
                }
                sb.append(signatureName).append(" ");
            } else {
                sb.append("Custom");
                if (isToasted) {
                    sb.append("Toasted");
                }
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
        if (signatureName != null) {
            if (isToasted) {
                sb.append("\033[33m").append("Toasted ");
            }
            sb.append(signatureName).append(" ").append("\033[0m");
        } else {
            sb.append("\033[33m").append("Custom ").append("\033[0m");
            if (isToasted) {
                sb.append("\033[93m").append("Toasted ").append("\033[0m");
            }
        }
        sb.append("\033[33m").append("Sandwich Details\n===============================\n").append("\033[0m");
        sb.append("\033[33m").append("Quantity: ").append(count).append("\033[0m");
        sb.append("\n\n");
        sb.append(bread.print(function))
                .append(toppings.print("Print"))
                .append("\n----------------------------------------------------------------------------------------\n")
                .append("\033[92m").append(String.format("Sandwich Cumulative Price: $%.2f%n%n", combinedPrice * count))
                .append("\033[0m");
        return sb.toString();
    }

}
