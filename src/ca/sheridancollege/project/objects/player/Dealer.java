package ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.interfaces.card.CardActions;
import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.HandCards;

/**
 * A class that models the dealer in the game.
 * Dealer is used to deal the cards and set the start player
 *
 * @author Wenya Guo 28-Jul-2022
 */
public class Dealer extends Player{

    public Dealer(String name, Books books, HandCards handcards) {
        super(name, books, handcards);
    }
    
    public void dealCards(CardActions cardActions, Players players) {
        for (Player player : players.getPlayers()) {
            HandCards handCards = new HandCards(cardActions.withdrawCards());
            player.setHandcards(handCards);
        }
    }

}
