package ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardValue;

/**
 * @author Wenya Guo
 * @author Patrick Hogg
 */
public class HandCards extends GroupOfCards {


    /**
     * Can make book boolean. This will check if the current list of cards
     * contains 4 of the same card value.
     *
     * @param cardValue the card value to check
     * @return true if it's possible to make a Book object
     */
    public boolean canMakeBook(CardValue cardValue) {
        return countNumOfCards(cardValue) == 4;
    }
}
