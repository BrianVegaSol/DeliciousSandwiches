package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bread {
    //TODO Strongly considering adding the Drink and Chips here to save space
    // might need to make the enums not private
    private int numOfSandwiches;
    private BreadType breadType;
    private BreadSize breadSize;

    public Bread (BreadType breadType, BreadSize breadSize, int numOfSandwiches) {
        this.breadType = breadType;
        this.breadSize = breadSize;
        this.numOfSandwiches = numOfSandwiches;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public int getNumOfSandwiches() {
        return numOfSandwiches;
    }

    public void setNumOfSandwiches(int numOfSandwiches) {
        this.numOfSandwiches = numOfSandwiches;
    }

    private enum BreadSize {
        FOUR_INCH(1,5.50), EIGHT_INCH(2,7.00),
        TWELVE_INCH(3,8.50);

        private final int menuNum;

        BreadSize(int menuNum, double itemPrice) {
            this.menuNum = menuNum;
        }
    }

    private enum BreadType {
        WHITE(1), WHEAT(2), RYE(3), WRAP(4);

        private final int menuNum;

        BreadType(int menuNum) {
            this.menuNum = menuNum;
        }
    }


    public static void sandwichMenu(byte numOfSandwiches) {
        if (numOfSandwiches < 1) {
            System.out.println("No sandwiches? Alright");
            return;
        }
        byte sandwichesMade = 1;
        Scanner scanBread = new Scanner(System.in);
        //FIXME +1 may break this
        while (sandwichesMade < (numOfSandwiches + 1)) {
            //byte sandwichInput;
            System.out.println("""
                    What type of bread would you like?
                    ==================================
                    1) White
                    2) Wheat
                    3) Rye
                    4) Wrap
                    """);
            try {
                int breadTypeInput = scanBread.nextInt();
                BreadType type = BreadType.values()[breadTypeInput - 1];
            /*switch (sandwichInput) {
                case 1:
                    BreadType white = BreadType.WHITE;
                    break;
                case 2:*/
                System.out.println("""
                        What size of bread would you like?
                        ==================================
                        1) 4"
                        2) 8"
                        3) 12"
                        """);
                int breadSizeInput = scanBread.nextInt();
                BreadSize size = BreadSize.values()[breadSizeInput - 1];
                Bread bread = new Bread(type, size, numOfSandwiches);
                //Need to add to orderArrList
                System.out.println(bread.toString());
                //}
                sandwichesMade++;
                //FIXME may also need ArrayIndexOOB
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e ) {
                System.err.println("Sorry! We don't have that in stock right now!");
            }
        }
        //TODO return Bread Object???;
    }
}


