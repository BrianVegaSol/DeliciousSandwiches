package com.pluarlsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Ingredient {
    static ArrayList<String> ingredients () {
        String[] allIngredients = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños",
                "Cucumbers", "Pickles", "Guacamole", "Mushrooms", "Mayo",
                "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette",
                "au jus", "Sauce"};
        return new ArrayList<>(Arrays.asList(allIngredients));
    }

    enum ExtraMeatSize {
        FOUR_INCH(1, "4\"", 0.50),
        EIGHT_INCH(2, "8\"", 1.00),
        TWELVE_INCH(3, "12\"", 1.50);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        ExtraMeatSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }


        public int getMenuNum() {
            return menuNum;
        }

        public String getSizeName() {
            return sizeName;
        }

        public double getMenuPrice() {
            return menuPrice;
        }

    }

}
