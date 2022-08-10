package ca.sheridancollege.project;

import ca.sheridancollege.project.game.GoFishGame;
import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.Dealer;
import ca.sheridancollege.project.objects.player.GoFishPlayer;
import ca.sheridancollege.project.objects.player.Players;

/**
 * The main class of our GoFish game.
 *
 * @author Patrick Hogg
 */
public class GoFish {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // To be filled
        DeckCards deckCards = new DeckCards();
        Dealer patrick = new Dealer("Patrick");
        GoFishPlayer wenya = new GoFishPlayer("Wenya");
        GoFishPlayer peter = new GoFishPlayer("Peter");

        Players players = new Players();
        players.addPlayer(wenya);
        players.addPlayer(peter);
        players.addPlayer(patrick);
        GoFishGame game = new GoFishGame(players);

        // Plays the game
        game.play(deckCards);
    }
}
