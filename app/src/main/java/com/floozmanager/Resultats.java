package com.floozmanager;

import android.util.Log;

public class Resultats {
    private Decimal benefice;
    private Decimal perte;
    private Decimal chiffreAffaire;

    public Resultats () {
        this.benefice = new Decimal(0,0);
        this.perte = new Decimal(0,0);
        this.chiffreAffaire = new Decimal(0,0);
    }

    public Resultats (Decimal ben, Decimal pert, Decimal ca) {
        this.benefice = ben;
        this.perte = pert;
        this.chiffreAffaire = ca;
    }

    public void calculerPerte (int newVal) {
        this.perte.addInt(newVal);
    }

    public void calculerChiffreAffaire (int newVal) {
        this.chiffreAffaire.addInt(newVal);
    }

    public void calculerBenefice () {
        this.benefice.reset();
        Decimal depense = this.perte.copy();
        Decimal gain = this.chiffreAffaire.copy();
        gain.sum(depense);
        this.benefice.sum(gain);
    }

    public Decimal[] getTableau2Elements() {
        Decimal[] decimals = {this.chiffreAffaire,this.perte};
        return decimals;
    }
    
    public float[] getRatio() {
        if (this.perte.isNull() == 0 && this.chiffreAffaire.isNull() == 0){
            float ratio = this.chiffreAffaire.diviser(this.perte);
            float[] poids = {1-(1/ratio),1/ratio};
            return poids;
        }
        if (this.perte.isNull() == 0) {
            float[] poids = {1,0};
            return poids;
        }
        float[] poids = {0,1};
        return poids;
    }

    public String toStringPerte() {
        return this.perte.toStringIntPart();
    }

    public String toStringBenefice() {
        return this.benefice.toStringIntPart();
    }

    public String toStringChiffreAffaire() {
        return this.chiffreAffaire.toStringIntPart();
    }
}
