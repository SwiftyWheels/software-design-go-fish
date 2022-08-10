/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardSuit;
import ca.sheridancollege.project.enums.CardValue;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Peter Dropulic
 */
public class DeckCardsTest {
    
    public DeckCardsTest() {
    }
    
    /**
     * Good Test of generateCards method, of class DeckCards.
     * Checks if the number of cards generated in the deck is 52.
     */
    @Test
    public void testGenerateCardsGood() {
        System.out.println("generateCardsGood");
        DeckCards instance = new DeckCards();
        //Genereate a sample deck that should have the correct number of cards.
        List<Card> sampleDeck = instance.generateCards();
        int expResult = 52;
        int result = sampleDeck.size();
        //Pass test if the sample deck has exactly 52 cards.
        assertEquals(expResult, result);
    }
}
