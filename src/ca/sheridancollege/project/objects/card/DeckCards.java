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

    public DeckCards() {
        setCards(generateCards());
    }

    @Override
    public List<Card> generateCards() {
        List<Card> generatedCards = new ArrayList<>();
        for (CardValue value : CardValue.values()) {
            for (CardSuit cardSuit : CardSuit.values()) {
                generatedCards.add(new Card(cardSuit, value));
            }
        }
        return generatedCards;
    }
}
