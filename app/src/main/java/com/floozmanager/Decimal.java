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
        if (otherDecimal.decPart < 0) {
            otherDecimal.inverserValDecimal();
            this.decPart -= otherDecimal.decPart;
            while (this.decPart >= 100) {
                this.intPart += 1;
                this.decPart -= 100;
            }
            while (this.decPart < 0) {
                this.intPart -= 1;
                this.decPart += 100;
            }
        } else {
            if (!otherDecimal.isNegative()) {
                this.intPart -= otherDecimal.intPart;
            } else {
                this.intPart += otherDecimal.intPart;
            }
            this.decPart -= otherDecimal.decPart;
            while (this.decPart < 0) {
                this.intPart -= 1;
                this.decPart += 100;
            }
        }
    }

    public void inverserValDecimal() {
        if (this.decPart < 0) {
            int tmp = this.decPart;
            this.decPart = tmp - 2*tmp;
        }
    }

    public void ajouter(Decimal otherDecimal) {
        if (otherDecimal.decPart < 0) {
            //Donc si decPart est négative elle devient positive
            this.inverserValDecimal();
            //Si elle était négative c'est qu'on calcul forcément une perte donc on enlève la nouvelle valeur à l'ancienne
            this.decPart -= otherDecimal.decPart;
            while (this.decPart < 0) {
                this.intPart += 1;
                this.decPart += 100;
            }
            while (this.decPart >= 100) {
                this.intPart -= 1;
                this.decPart -= 100;
            }
        } else {
            this.intPart += otherDecimal.intPart;
            if (otherDecimal.isNegative()) {
                this.decPart += otherDecimal.decPart;
                while (this.decPart >= 100) {
                    this.intPart -= 1;
                    this.decPart -= 100;
                }
            } else {
                this.decPart += otherDecimal.decPart;
                while (this.decPart >= 100) {
                    this.intPart += 1;
                    this.decPart -= 100;
                }
            }
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
        if (this.intPart == 0 && this.decPart == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void stringToDecimal(StringTokenizer separateur) {
        String intString = separateur.nextToken();
        if (intString.contains("-0")) {
            int intDecPart = Integer.parseInt(separateur.nextToken());
            this.decPart =  intDecPart - 2*intDecPart;
        } else {
            this.decPart = Integer.parseInt(separateur.nextToken());
        }
        this.intPart = Integer.parseInt(intString);
    }

    public boolean isNegative() {
        if (this.intPart < 0 || this.decPart < 0) {
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
