/**
 * SYST 17796 Project Base code. Students can modify and extend to implement
 * their game. Add your name as an author and the date!
 */
package ca.sheridancollege.project.game;

import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.Players;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Peter Dropulic
 */
public abstract class Game {

    private Players players;

    /**
     * Instantiates a new Game.
     */
    protected Game(Players players) {
        this.players = players;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    public abstract void play(DeckCards deckCards);

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();

}//end class
