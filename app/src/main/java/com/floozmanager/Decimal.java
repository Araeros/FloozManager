package com.floozmanager;

import android.util.Log;

import java.util.StringTokenizer;

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

    public void ajouter(Decimal otherDecimal) {
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

    public boolean isNull() {
        if (this.intPart == 0) {
            if (this.decPart == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void stringToDecimal(StringTokenizer separateur){
        this.intPart = Integer.parseInt(separateur.nextToken());
        this.decPart = Integer.parseInt(separateur.nextToken());
    }

    public boolean isNegative() {
        if (this.intPart < 0) {
            return true;
        }
        return false;
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
