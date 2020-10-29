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

    public void soustraire(Decimal otherDecimal) {
        if (!otherDecimal.isNegative()) {
            this.intPart -= otherDecimal.intPart;
        } else {
            this.intPart += otherDecimal.intPart;
        }
        this.decPart -= otherDecimal.decPart;
        if (this.decPart < 0) {
            this.intPart -= 1;
            this.decPart += 100;
        }
    }

    public void ajouter(Decimal otherDecimal) {
        this.intPart += otherDecimal.intPart;
        this.decPart += otherDecimal.decPart;
        if (this.decPart > 100) {
            this.intPart += 1;
            this.decPart -= 100;
        }
    }

    public void reset(){
        this.intPart = 0;
        this.decPart = 0;
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

    public String toStringIntPart() {
        return Integer.toString(intPart);
    }

    public String toStringDecPart() {
        return Integer.toString(decPart);
    }

    public int getIntPart() {
        return intPart;
    }

    public int getDecPart() {
        return decPart;
    }

    public void copie(Decimal cible){
        this.intPart = cible.intPart;
        this.decPart = cible.decPart;
    }

    @Override
    public String toString() {
        return this.toStringIntPart() + "." + toStringDecPart();
    }
}
