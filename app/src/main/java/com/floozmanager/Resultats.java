package com.floozmanager;

import android.util.Log;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable

public class Resultats {

    @DatabaseField( generatedId = true )
    private int idResultats;
    @DatabaseField
    private Decimal benefice;
    @DatabaseField
    private Decimal perte;
    @DatabaseField
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
        Decimal cout = new Decimal(this.perte.getIntPart(), this.perte.getDecPart());
        Decimal profit = new Decimal(this.chiffreAffaire.getIntPart(), this.chiffreAffaire.getDecPart());
        profit.soustraire(cout);
        this.benefice.copie(profit);
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

    public String toStringPerte() {
        return this.perte.toString();
    }

    public String toStringBenefice() {
        return this.benefice.toString();
    }

    public String toStringChiffreAffaire() {
        return this.chiffreAffaire.toString();
    }

    @Override
    public String toString() {
        return "Chiffre d'Affaire : " + toStringChiffreAffaire() + " - Pertes : " + toStringPerte() + " - Bénéfices : " + toStringBenefice() + "\n";
    }
}
