package com.floozmanager;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests unitaires pour vérifier la cohérence des données
 * Les tests sont effectués sur les méthodes calculerPerte,Bénéfice,ChiffreAffaire et sur lam éthode toString de Decimal.
 */
public class CalculUnitTest {

    Resultats resultats = new Resultats();
    EntryString[] entreesPositives = {new EntryString("10"),new EntryString("20"),new EntryString("1.5"),new EntryString("8.2"),new EntryString("5.3"),new EntryString("0.5")};
    EntryString[] entreesNegatives = {new EntryString("-10"),new EntryString("-20"),new EntryString("-1.5"), new EntryString("-8.2"),new EntryString("-5.3"),new EntryString("-0.5")};

    //Les chiffres à la suite des noms de méthodes correspond aux valeurs d'entréees utilisées avant un _ les valeurs sont positives après le _ les valeurs sont négatives.
    @Test
    public void calculPerte055() {
        resultats.calculerPerte(entreesNegatives[0]);
        resultats.calculerPerte(entreesNegatives[5]);
        resultats.calculerPerte(entreesNegatives[5]);
        Decimal test = new Decimal(-11, 0);
        assertEquals(test.toString(), resultats.toStringPerte());
    }

    @Test
    public void calculPerte01() {
        resultats.calculerPerte(entreesNegatives[0]);
        resultats.calculerPerte(entreesNegatives[1]);
        Decimal test = new Decimal(-30, 0);
        assertEquals(test.toString(), resultats.toStringPerte());
    }

    @Test
    public void calculPerte05() {
        resultats.calculerPerte(entreesNegatives[0]);
        resultats.calculerPerte(entreesNegatives[5]);
        Decimal test = new Decimal(-10, 50);
        assertEquals(test.toString(), resultats.toStringPerte());
    }

    @Test
    public void calculPerte55() {
        resultats.calculerPerte(entreesNegatives[5]);
        resultats.calculerPerte(entreesNegatives[5]);
        Decimal test = new Decimal(-1, 0);
        assertEquals(test.toString(), resultats.toStringPerte());
    }

    @Test
    public void calculPerte5() {
        resultats.calculerPerte(entreesNegatives[5]);
        Decimal test = new Decimal(0, -50);
        assertEquals(test.toString(), resultats.toStringPerte());
    }

    @Test
    public void calculPerte234() {
        resultats.calculerPerte(entreesNegatives[2]);
        resultats.calculerPerte(entreesNegatives[3]);
        resultats.calculerPerte(entreesNegatives[4]);
        Decimal test = new Decimal(-15, 0);
        assertEquals(test.toString(), resultats.toStringPerte());
    }

    @Test
    public void calculPerte555() {
        resultats.calculerPerte(entreesNegatives[5]);
        resultats.calculerPerte(entreesNegatives[5]);
        resultats.calculerPerte(entreesNegatives[5]);
        Decimal test = new Decimal(-1, 50);
        assertEquals(test.toString(), resultats.toStringPerte());
    }

    @Test
    public void calculChiffreAffaire012() {
        resultats.calculerChiffreAffaire(entreesPositives[0]);
        resultats.calculerChiffreAffaire(entreesPositives[1]);
        resultats.calculerChiffreAffaire(entreesPositives[2]);
        Decimal test = new Decimal(31, 50);
        assertEquals(test.toString(), resultats.toStringChiffreAffaire());
    }

    @Test
    public void calculChiffreAffaire022() {
        resultats.calculerChiffreAffaire(entreesPositives[0]);
        resultats.calculerChiffreAffaire(entreesPositives[2]);
        resultats.calculerChiffreAffaire(entreesPositives[2]);
        Decimal test = new Decimal(13, 0);
        assertEquals(test.toString(), resultats.toStringChiffreAffaire());
    }

    @Test
    public void calculChiffreAffaire22() { ;
        resultats.calculerChiffreAffaire(entreesPositives[2]);
        resultats.calculerChiffreAffaire(entreesPositives[2]);
        Decimal test = new Decimal(3, 0);
        assertEquals(test.toString(), resultats.toStringChiffreAffaire());
    }

    @Test
    public void calculChiffreAffaire555() {
        resultats.calculerChiffreAffaire(entreesPositives[5]);
        resultats.calculerChiffreAffaire(entreesPositives[5]);
        resultats.calculerChiffreAffaire(entreesPositives[5]);
        Decimal test = new Decimal(1, 50);
        assertEquals(test.toString(), resultats.toStringChiffreAffaire());
    }

    @Test
    public void calculChiffreAffaire025() {
        resultats.calculerChiffreAffaire(entreesPositives[0]);
        resultats.calculerChiffreAffaire(entreesPositives[2]);
        resultats.calculerChiffreAffaire(entreesPositives[5]);
        Decimal test = new Decimal(12, 0);
        assertEquals(test.toString(), resultats.toStringChiffreAffaire());
    }

    @Test
    public void calculChiffreAffaire234() {
        resultats.calculerChiffreAffaire(entreesPositives[2]);
        resultats.calculerChiffreAffaire(entreesPositives[3]);
        resultats.calculerChiffreAffaire(entreesPositives[4]);
        Decimal test = new Decimal(15, 0);
        assertEquals(test.toString(), resultats.toStringChiffreAffaire());
    }

    @Test
    public void calculChiffreAffaire5() {
        resultats.calculerChiffreAffaire(entreesPositives[5]);
        Decimal test = new Decimal(0, 50);
        assertEquals(test.toString(), resultats.toStringChiffreAffaire());
    }

    @Test
    public void calculBenefice01_1() {
        resultats.calculerChiffreAffaire(entreesPositives[0]);
        resultats.calculerChiffreAffaire(entreesPositives[1]);
        resultats.calculerPerte(entreesNegatives[0]);
        resultats.calculerBenefice();
        Decimal test = new Decimal(20,0);
        assertEquals(test.toString(), resultats.toStringBenefice());
    }

    @Test
    public void calculBenefice01_55() {
        resultats.calculerChiffreAffaire(entreesPositives[0]);
        resultats.calculerChiffreAffaire(entreesPositives[1]);
        resultats.calculerPerte(entreesNegatives[5]);
        resultats.calculerPerte(entreesNegatives[5]);
        resultats.calculerBenefice();
        Decimal test = new Decimal(29,0);
        assertEquals(test.toString(), resultats.toStringBenefice());
    }

    @Test
    public void calculBenefice01_5() {
        resultats.calculerChiffreAffaire(entreesPositives[0]);
        resultats.calculerChiffreAffaire(entreesPositives[1]);
        resultats.calculerPerte(entreesNegatives[5]);
        resultats.calculerBenefice();
        Decimal test = new Decimal(29,50);
        assertEquals(test.toString(), resultats.toStringBenefice());
    }

    @Test
    public void calculBenefice_5() {
        resultats.calculerPerte(entreesNegatives[5]);
        resultats.calculerBenefice();
        Decimal test = new Decimal(0,-50);
        assertEquals(test.toString(), resultats.toStringBenefice());
    }

    @Test
    public void calculBenefice_2() {
        resultats.calculerPerte(entreesNegatives[2]);
        resultats.calculerBenefice();
        Decimal test = new Decimal(-1,50);
        assertEquals(test.toString(), resultats.toStringBenefice());
    }

    @Test
    public void calculBenefice234_234() {
        resultats.calculerChiffreAffaire(entreesPositives[2]);
        resultats.calculerChiffreAffaire(entreesPositives[3]);
        resultats.calculerChiffreAffaire(entreesPositives[4]);
        resultats.calculerPerte(entreesNegatives[2]);
        resultats.calculerPerte(entreesNegatives[3]);
        resultats.calculerPerte(entreesNegatives[4]);
        resultats.calculerBenefice();
        Decimal test = new Decimal(0,0);
        assertEquals(test.toString(), resultats.toStringBenefice());
    }


}