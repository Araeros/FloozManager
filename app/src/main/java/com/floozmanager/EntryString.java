package com.floozmanager;

import java.util.StringTokenizer;

public class EntryString {
    private String chaineEntree;
    private static final String SEPARATEUR = ".";

    public EntryString(String entree) {
        this.chaineEntree = entree;
        this.testString();
    }

    private void testString() {
        if (!this.chaineEntree.contains(SEPARATEUR)) {
            this.chaineEntree+=".00";
        }
        StringTokenizer separation = new StringTokenizer(chaineEntree, SEPARATEUR);
        String entier = separation.nextToken();
        String decimal = separation.nextToken();
        if (decimal.length() < 2) {
            this.chaineEntree+="0";
        }
        if (decimal.length() > 2){
            this.chaineEntree = this.chaineEntree.substring(0, entier.length()+3);
        }
    }

    public boolean testDecimal() {
        Decimal test = this.toDecimal();
        return test.isNegative();
    }

    public Decimal toDecimal() {
        Decimal decimalEntree = new Decimal();
        StringTokenizer separation = new StringTokenizer(chaineEntree, SEPARATEUR);
        decimalEntree.stringToDecimal(separation);
        return decimalEntree;
    }

    @Override
    public String toString() {
        return this.chaineEntree;
    }

}
