package ca.sheridancollege.project.interfaces.player;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.objects.card.Card;
import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.Player;

/**
 * An interface contains methods to be implemented by GoFishPlayer
 *
 * @author Wenya Guo 28-Jul-2022
 * @author Patrick Hogg
 */
public interface PlayerActions {

    /**
     * Go fish. Player will withdraw the top card from the deck.
     *
     * @param deckCards the deck cards
     */
    void goFish(DeckCards deckCards);

    /**
     * Ask player for card. Player will receive the card if the asked player has
     * the card. Otherwise, asking player will go fish.
     *
     * @param player    the player
     * @param cardValue the cardValue
     * @param deckCards the deck cards
     */
    void askPlayerForCard(Player player, CardValue cardValue,
                          DeckCards deckCards, int priorityNum);


    /**
     * Ask player for card priority. This will ask a player for a card with the
     * value that the asking player has the most of.
     *
     * @param player    the player
     * @param deckCards the deck cards
     */
    void askPlayerForCardPriority(Player player, DeckCards deckCards,
                                  int priorityNum);

    /**
     * Hand card to player.
     *
     * @param player the player
     * @param card   the card
     */
    void handCardToPlayer(Player player, Card card);

}
