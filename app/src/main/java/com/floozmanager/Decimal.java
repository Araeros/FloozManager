package com.floozmanager;

import android.util.Log;

public class Decimal {
    private int intPart;
    private int decPart;

    public Decimal () {
        intPart = 0;
        decPart = 0;
    }

    public Decimal (int ip, int dp) {
        intPart = ip;
        decPart = dp;
    }

    public void sum(Decimal otherDecimal) {
        this.addInt(otherDecimal.intPart);
        this.addDec(otherDecimal.decPart);
        if (this.decPart >= 100){
            this.addInt(1);
            this.addDec(-100);
        }
    }

    public void reset(){
        this.intPart = 0;
        this.decPart = 0;
    }

    public Decimal copy() {
        Decimal copy = new Decimal(this.intPart,this.decPart);
        return copy;
    }

    public void addInt(int newInt) {
        this.intPart += newInt;
    }

    public void addDec(int newDec) {
        this.intPart += newDec;
    }

    public int toInt() {
        return this.intPart;
    }

    public float toFloat() {
        float decimal = this.intPart;
        decimal += (this.decPart/100);
        return decimal;
    }

    public int isNull() {
        if (this.intPart == 0) {
            if (this.decPart == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public float diviser(Decimal diviseur) {
        return this.toFloat()/diviseur.toFloat();
    }

    public String toStringIntPart() {
        return Integer.toString(intPart);
    }

    public String toStringDecPart() {
        return Integer.toString(decPart);
    }
}
