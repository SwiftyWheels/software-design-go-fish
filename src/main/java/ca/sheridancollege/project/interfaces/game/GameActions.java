package ca.sheridancollege.project.interfaces.game;

import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.GoFishPlayer;
import ca.sheridancollege.project.objects.player.Players;

import java.util.HashMap;

/**
 * The interface Game actions.
 *
 * @author Patrick Hogg
 */
public interface GameActions {

    /**
     * Simulate game.
     *
     * @param deckCards the deck cards
     * @param players   the players
     */
    void simulateGame(DeckCards deckCards, Players players);

    /**
     * Check winner go fish player.
     *
     * @return the go fish player
     */
    GoFishPlayer checkWinner();

    /**
     * Gets random player.
     *
     * @return the random player
     */
    GoFishPlayer getRandomPlayer();

    /**
     * Gets player leaderboard.
     *
     * @return the player leaderboard
     */
    HashMap<String, Integer> getPlayerLeaderboard();

    /**
     * Gets all books in game.
     *
     * @return the all books in game
     */
    int getAllBooksInGame();
}
