package ca.sheridancollege.project.objects.card;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        //Generate a sample deck that should have the correct number of cards.
        List<Card> sampleDeck = instance.generateCards();
        int expResult = 52;
        int result = sampleDeck.size();
        //Pass test if the sample deck has exactly 52 cards.
        assertEquals(expResult, result);
    }
}
