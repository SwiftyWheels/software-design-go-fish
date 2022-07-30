package ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.interfaces.player.PlayerActions;
import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.HandCards;

/**
 * A class that models the go fish player in the game.
 *
 * @author Wenya Guo 28-Jul-2022
 */
public class GoFishPlayer extends Player implements PlayerActions{

    public GoFishPlayer(String name, Books books, HandCards handcards) {
        super(name, books, handcards);
    }
    
    @Override
    public void goFish(){
        
    }
    
    
    @Override
    public void handsCard(){
        
    }

}
