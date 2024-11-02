package com.pluarlsight;

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
}


