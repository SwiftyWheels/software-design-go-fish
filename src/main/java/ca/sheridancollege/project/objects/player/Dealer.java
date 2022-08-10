package ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.objects.card.DeckCards;

/**
 * A class that models the dealer in the game. Dealer is used to deal the cards
 * and set the start player
 *
 * @author Wenya Guo 28-Jul-2022
 * @author Patrick Hogg
 */
public class Dealer extends GoFishPlayer {

    /**
     * Instantiates a new Dealer.
     *
     * @param name the name
     */
    public Dealer(String name) {
        super(name);
    }

    /**
     * Deal cards to all players.
     *
     * @param deckCards the deck cards
     * @param players   the players
     */
    public void dealCards(DeckCards deckCards, Players players) {
        // Sets the amount to deal based on the amount of players in the game
        int amountToDeal = players.getPlayerList().size() < 4 ? 7 : 5;

        // Loop through all players and have them withdraw the amount of
        // cards previously set above in amountToDeal
        for (Player player : players.getPlayerList()) {
            player.getHandCards().setCards(
                    deckCards.withdrawCards(amountToDeal));
        }
    }
}
