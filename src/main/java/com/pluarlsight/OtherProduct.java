package com.pluarlsight;

import java.security.PublicKey;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OtherProduct {
    private DeliCola deliCola;
    private DelishChips delishChips;

    OtherProduct (DeliCola deliCola) {
        this.deliCola = deliCola;
    }

    OtherProduct (DelishChips delishChips) {
        this.delishChips = delishChips;
    }


    private enum DeliCola {
        SMALL(1, "Small", 2.00),
        MEDIUM(2, "Medium", 2.50),
        LARGE(3, "Large", 3.00);

        private int menuNum;
        private String menuName;
        private double menuPrice;

        DeliCola(int menuNum, String menuName, double menuPrice) {
            this.menuNum = menuNum;
            this.menuName = menuName;
            this.menuPrice = menuPrice;
        }
    }

    private enum DelishChips {
        DELISH_CHIPS(1, "Delish Chips", 1.50);

        private int menuNum;
        private String menuName;
        private double menuPrice;

        DelishChips(int menuNum, String menuName, double menuPrice) {
            this.menuNum = menuNum;
            this.menuName = menuName;
            this.menuPrice = menuPrice;
        }
    }

    //FIXME Account for if numDrinks < 1
    // toString to display and test
    // NO MENU FOR SIIIIIZEEEEE
    public static void addDrink(byte numOfDrinks) {
        //TODO Make Val a meThod that takes 2 prompts
        DeliCola size;
        Scanner scan = new Scanner(System.in);
        int drinkInput = -1;
        while(true) {
        System.out.println("What size do you want?");
        //TODO Make this try catch a method
        try {
            drinkInput = scan.nextInt();
            break;
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e ) {
            System.err.println("Sorry, we don't offer that size here!");
            scan.nextLine();
        }
        }

        size = OtherProduct.DeliCola.values()[drinkInput - 1];
        //TODO Add DateTime and Object to HashMap
        OtherProduct drink = new OtherProduct(size);
    }

   /* public static validation () {
        return;
    }*/
    public String toString() {
        return "";
    }
}
