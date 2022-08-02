/**
 * SYST 17796 Project Base code. Students can modify and extend to implement
 * their game. Add your name as an author and the date!
 */
package ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardSuit;
import ca.sheridancollege.project.enums.CardValue;

import java.util.Objects;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Patrick Hogg
 */
public class Card {
    private final CardSuit cardSuit;
    private final CardValue cardValue;

    /**
     * Instantiates a new Card.
     *
     * @param cardSuit  the card suit
     * @param cardValue the card value
     */
    public Card(CardSuit cardSuit, CardValue cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    /**
     * Gets card suit.
     *
     * @return the card suit
     */
    public CardSuit getCardSuit() {
        return cardSuit;
    }

    /**
     * Gets card value.
     *
     * @return the card value
     */
    public CardValue getCardValue() {
        return cardValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card card)) {
            return false;
        }
        return cardSuit == card.cardSuit && cardValue == card.cardValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardSuit, cardValue);
    }

    /**
     * Students should implement this method for their specific children
     * classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    @Override
    public String toString() {
        return "Card{" +
                "cardSuit=" + cardSuit +
                ", cardValue=" + cardValue +
                '}';
    }
}
