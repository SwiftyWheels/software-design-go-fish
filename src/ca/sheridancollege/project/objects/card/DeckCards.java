package ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardSuit;
import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.interfaces.card.CardGeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * The deck of cards that will be used in the Go Fish game.
 *
 * @author Patrick Hogg
 */
public class DeckCards extends GroupOfCards implements CardGeneration {

    /**
     * Instantiates a new Deck cards.
     */
    public DeckCards() {
        // Generate a new deck of 52 cards
        setCards(generateCards());
        // Shuffle the deck
        shuffle();
    }

    @Override
    public List<Card> generateCards() {
        // Create new empty list of Cards
        List<Card> generatedCards = new ArrayList<>();
        // Loop through all the values in the CardValue enum
        for (CardValue value : CardValue.values()) {
            // Loop through all the values in the CardSuit enum
            for (CardSuit cardSuit : CardSuit.values()) {
                // Add a newly generated Card using the CardValue and
                // CardSuit values
                generatedCards.add(new Card(cardSuit, value));
            }
        }
        // Return generated list of cards
        return generatedCards;
    }
}
