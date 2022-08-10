package ca.sheridancollege.project.interfaces.book;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.objects.card.Card;

import java.util.List;

/**
 * The interface Books actions.
 *
 * @author Patrick Hogg
 */
public interface BooksActions {

    /**
     * Create book from a list of cards.
     *
     * @param cardList  the card list
     * @param cardValue the card value
     */
    void createBook(List<Card> cardList, CardValue cardValue);

}
