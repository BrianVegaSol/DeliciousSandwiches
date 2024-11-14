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

    //EXPLAIN Bread Enums
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
    //END Bread Enums
    //EXPLAIN Meat Enums
     enum MeatType {
        STEAK(1, "Steak", false),
        HAM(2, "Ham", false),
        SALAMI(3, "Salami", false),
        ROAST_BEEF(4, "Roast Beef", false),
        CHICKEN(5, "Chicken", false),
        BACON(6, "Bacon", false);

        private int menuNum;
        private String menuName;
        private boolean wantsExtraMeat;

        MeatType(int menuNum, String menuName, boolean wantsExtraMeat) {
            this.menuNum = menuNum;
            this.menuName = menuName;
        }

        public String getMenuName() {
            return menuName;
        }

        public int getMenuNum() {
            return menuNum;
        }
    }

     enum MeatSize {
        FOUR_INCH(1, "4\"", 1.00),
        EIGHT_INCH(2, "8\"", 2.00),
        TWELVE_INCH(3, "12\"", 3.00);

        private int menuNum;
        private String sizeName;
        private double menuPrice;
        private boolean wantsExtra;

        MeatSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
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
    //END Meat Enums
    //EXPLAIN Cheese Enums ->
     enum CheeseType {
        AMERICAN(1, "American"),
        PROVOLONE(2, "Provolone"),
        CHEDDAR(3, "Cheddar"),
        SWISS(4, "Swiss");

        private int menuNum;
        private String menuName;

        CheeseType(int menuNum, String menuName) {
            this.menuNum = menuNum;
            this.menuName = menuName;
        }

        public String getMenuName() {
            return menuName;
        }

        public int getMenuNum() {
            return menuNum;
        }
    }

     enum CheeseSize {
        FOUR_INCH(1, "4\"", 0.75),
        EIGHT_INCH(2, "8\"", 1.50),
        TWELVE_INCH(3, "12\"", 2.25);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        CheeseSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }

        public int getMenuNum() {
            return menuNum;
        }

        public double getMenuPrice() {
            return menuPrice;
        }

        public String getSizeName() {
            return sizeName;
        }
    }

     enum ExtraCheeseSize {
        FOUR_INCH(1, "4\"", 0.30),
        EIGHT_INCH(2, "8\"", 0.60),
        TWELVE_INCH(3, "12\"", 0.90);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        ExtraCheeseSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }

         public String getSizeName() {
             return sizeName;
         }

         public double getMenuPrice() {
             return menuPrice;
         }

         public int getMenuNum() {
             return menuNum;
         }
     }
    //END <-
}
