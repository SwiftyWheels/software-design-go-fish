package ca.sheridancollege.project.interfaces.card;

import ca.sheridancollege.project.objects.card.Card;

import java.util.List;

/**
 * The interface that some GroupOfCards may implement.
 *
 * @author Patrick Hogg
 */
public interface CardGeneration {
    /**
     * Generate cards list.
     *
     * @return the list
     */
    List<Card> generateCards();
}
