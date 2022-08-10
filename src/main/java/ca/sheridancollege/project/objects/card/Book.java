package ca.sheridancollege.project.objects.card;

import java.util.List;

/**
 * The type Book.
 *
 * @author Patrick Hogg
 */
public class Book extends GroupOfCards {

    /**
     * Instantiates a new Book.
     */
    public Book() {
        super();
    }

    /**
     * Instantiates a new Book using a list of cards.
     *
     * @param cards the cards to set
     */
    public Book(List<Card> cards) {
        super(cards);
    }
}
