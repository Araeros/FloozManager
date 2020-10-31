package com.floozmanager;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test unitaires pour vérifier la cohérence des données
 */
public class CalculUnitTest {

    Resultats resultats = new Resultats();
    EntryString[] entreesPositives = {new EntryString("10"),new EntryString("20"),new EntryString("1.5"),new EntryString("8.2"),new EntryString("5.3"),new EntryString("0.5")};
    EntryString[] entreesNegatives = {new EntryString("-10"),new EntryString("-20"),new EntryString("-1.5"), new EntryString("-8.2"),new EntryString("-5.3"),new EntryString("-0.5")};

    //Les chiffres à la suite des noms de méthodes correspond aux valeurs d'entréees utilisées
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


}