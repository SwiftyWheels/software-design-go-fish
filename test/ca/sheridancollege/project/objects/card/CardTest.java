package ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardSuit;
import ca.sheridancollege.project.enums.CardValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Objects;

/**
 * @author Peter Dropulic
 */

public class CardTest {
    
    public CardTest() {
    }

    /**
     * Test of getCardSuitBad method, of class Card.
     * Checks for the incorrect card suit.
     */
    
    @Test
    public void testGetCardSuitBad() {
        System.out.println("getCardSuitBad");
        Card instance = new Card(CardSuit.CLUBS, CardValue.TWO);
        CardSuit expResult = CardSuit.HEARTS;
        CardSuit result = instance.getCardSuit();
        assertNotEquals(expResult, result);
    }
    
     /**
     * Good Test of getCardSuit method, of class Card.
     * Checks for the correct card suit.
     */
    @Test
    public void testGetCardSuitGood() {
        System.out.println("getCardSuitGood");
        Card instance = new Card(CardSuit.CLUBS, CardValue.TWO);
        CardSuit expResult = CardSuit.CLUBS;
        CardSuit result = instance.getCardSuit();
        assertEquals(expResult, result);
    }
    
    /**
     * Bad Test of getCardValue method, of class Card.
     * Checks for the incorrect card value.
     */
    @Test
    public void testGetCardValueBad() {
        System.out.println("getCardValueBad");
        Card instance = new Card(CardSuit.HEARTS, CardValue.ACE);
        CardValue expResult = CardValue.EIGHT;
        CardValue result = instance.getCardValue();
        assertNotEquals(expResult, result);
    }
    
    /**
     * Test of getCardValueBad method, of class Card.
     * Checks for the correct card value.
     */
    
    @Test
    public void testGetCardValueGood() {
        System.out.println("getCardValueGood");
        Card instance = new Card(CardSuit.HEARTS, CardValue.ACE);
        CardValue expResult = CardValue.ACE;
        CardValue result = instance.getCardValue();
        assertEquals(expResult, result);
    }

    /**
     * Bad Test of equals method, of class Card.
     * Checks if the equal method works correctly and can tell that two
     * different card objects are not equal/same.
     */
    
    @Test
    public void testEqualsBad() {
        System.out.println("equalsBad");
        Object o = new Card(CardSuit.HEARTS, CardValue.ACE);
        Card instance = new Card(CardSuit.SPADES, CardValue.ACE);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertNotEquals(expResult, result);
    }
    
    /**
     * Good Test of equals method, of class Card.
     *Checks if the equal method works correctly and can tell that two card
     * objects are the equal/same.
     */
    
    @Test
    public void testEqualsGood() {
        System.out.println("equalsGood");
        Object o = new Card(CardSuit.SPADES, CardValue.ACE);
        Card instance = new Card(CardSuit.SPADES, CardValue.ACE);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
     /**
     * Bad Test of hashCode method, of class Card.
     * Checks if the hashCode of a card is incorrect.
     */
    
    @Test
    public void testHashCodeBad() {
        System.out.println("hashCodeBad");
        Card instance = new Card(CardSuit.DIAMONDS, CardValue.QUEEN);
        int expResult = Objects.hash(CardSuit.HEARTS, CardValue.KING);
        int result = instance.hashCode();
        assertNotEquals(expResult, result);
    }
  
    /**
     * Good Test of hashCode method, of class Card.
     * Checks if the hashCode of a card is correct.
     */
    
    @Test
    public void testHashCodeGood() {
        System.out.println("hashCodeGood");
        Card instance = new Card(CardSuit.HEARTS, CardValue.KING);
        int expResult = Objects.hash(CardSuit.HEARTS, CardValue.KING);
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Bad Test of toString method, of class Card.
     *Checks if the toString created from the card returns the incorrect card 
     * in String form.
     */
    
    @Test
    public void testToStringBad() {
        System.out.println("toStringBad");
        Card instance = new Card(CardSuit.CLUBS, CardValue.SIX);
        String expResult = "Card{" + "FIVE" + " of " + "CLUBS" + "}";
        String result = instance.toString();
        assertNotEquals(expResult, result);
    }
    
    /**
     * Good Test of toString method, of class Card.
     * Checks if the toString created from the card returns the correct card 
     * in String form.
     */
    
    @Test
    public void testToStringGood() {
        System.out.println("toStringGood");
        Card instance = new Card(CardSuit.CLUBS, CardValue.FIVE);
        String expResult = "Card{" + "FIVE" + " of " + "CLUBS" + "}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
