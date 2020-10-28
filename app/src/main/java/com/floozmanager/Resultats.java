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

    public void calculerBenefice () {
        this.benefice.reset();
        Decimal depense = this.perte.copy();
        Decimal gain = this.chiffreAffaire.copy();
        gain.ajouter(depense);
        this.benefice.ajouter(gain);
    }

    public void calculerPerte (EntryString entree){
        if (this.perteIsNull()){
            this.perte = entree.toDecimal();
        } else {
            this.perte.ajouter(entree.toDecimal());
        }

    }

    public void calculerChiffreAffaire (EntryString entree){
        if (this.chiffreAffaireIsNull()){
            this.chiffreAffaire=entree.toDecimal();
        } else {
            this.chiffreAffaire.ajouter(entree.toDecimal());
        }

    }

    public boolean perteIsNull() {
        return this.perte.isNull();
    }

    public boolean chiffreAffaireIsNull() {
        return this.chiffreAffaire.isNull();
    }

    public Decimal[] getTableau2Elements() {
        Decimal[] decimals = {this.chiffreAffaire,this.perte};
        return decimals;
    }
    
    public float[] getRatio() {
        if (!this.perte.isNull() && !this.chiffreAffaire.isNull()){
            float ratio = this.chiffreAffaire.diviser(this.perte);
            float[] poids = {1-(1/ratio),1/ratio};
            return poids;
        }
        if (!this.perte.isNull()) {
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
