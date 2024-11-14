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
}
