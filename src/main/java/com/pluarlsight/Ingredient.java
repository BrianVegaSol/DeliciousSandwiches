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

    enum BreadType {
        WHITE(1, "White"), WHEAT(2, "Wheat"), RYE(3, "Rye"), WRAP(4, "Wrap");

        private final int menuNum;
        private String name;


        BreadType(int menuNum, String name) {
            this.menuNum = menuNum;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getMenuNum() {
            return menuNum;
        }
    }

     enum BreadSize {
        FOUR_INCH(1, "4\"", 5.50),
        EIGHT_INCH(2, "8\"", 7.00),
        TWELVE_INCH(3, "12\"", 8.50);


        private String itemType;
        private final int menuNum;
        private String sizeName;
        private final double menuPrice;

        BreadSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.menuPrice = menuPrice;
            this.sizeName = sizeName;
        }
         public double getMenuPrice() {
             return menuPrice;
         }

         public String getSizeName() {
             return sizeName;
         }

         public int getMenuNum() {
            return menuNum;
        }
    }

}
