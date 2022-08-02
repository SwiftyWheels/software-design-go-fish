package ca.sheridancollege.project.interfaces.card;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.objects.card.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The interface Card actions.
 *
 * @author Wenya Guo
 * @author Patrick Hogg
 */
public interface CardActions {
    /**
     * Withdraw cards list.
     *
     * @param amount the amount
     * @return the list
     */
    List<Card> withdrawCards(int amount);

    /**
     * Count num of cards int.
     *
     * @param cardValue the card value
     * @return the int
     */
    int countNumOfCards(CardValue cardValue);

    /**
     * Gets all cards of the specified value.
     *
     * @param cardValue the card value
     * @return the all cards of value
     */
    List<Card> getAllCardsOfValue(CardValue cardValue);


    /**
     * Gets card of value.
     *
     * @param cardValue the card value
     * @return the card of value
     */
    Card getCardOfValue(CardValue cardValue);

    /**
     * Gets number of occurrences of all cards of each card value.
     *
     * @return the occurrences of card value
     */
    HashMap<CardValue, Integer> getOccurrencesOfCardValue();

    /**
     * This is to be used for determining the order of cards that are of
     * priority in the players hand. The first element is the highest priority,
     * and the player should ask for those cards first.
     *
     * @param cardAmounts A map containing the CardValue and number of times it
     *                    occurred in the players hand.
     * @param sortedList  The list that will contain the sorted list.
     * @return a List of CardValue type that should be sorted.
     */
    List<CardValue> getCardValuePriority(Map<CardValue,
            Integer> cardAmounts, List<CardValue> sortedList);

    /**
     * Print cards.
     */
    void printCards();
}
