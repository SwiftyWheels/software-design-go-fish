package main.java.ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.objects.card.HandCards;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter Dropulic
 */
public class HandCardsTest {
    
    public HandCardsTest() {
    }

    /**
     * Bad Test of canMakeBook method, of class HandCards.
     */
    @Test
    public void testCanMakeBookBad() {
        System.out.println("canMakeBookBad");
        CardValue cardValue = CardValue.FIVE;
        HandCards instance = new HandCards();
        boolean expResult = true;
        boolean result = instance.canMakeBook(cardValue);
        assertNotEquals(expResult, result);
    } 
    
    /**
     * Good Test of canMakeBook method, of class HandCards.
     */
    @Test
    public void testCanMakeBookGood() {
        System.out.println("canMakeBookGood");
        CardValue cardValue = CardValue.FIVE;
        HandCards instance = new HandCards();
        boolean expResult = false;
        boolean result = instance.canMakeBook(cardValue);
        assertEquals(expResult, result);
    } 
    
}
