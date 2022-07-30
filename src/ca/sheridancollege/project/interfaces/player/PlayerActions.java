package ca.sheridancollege.project.interfaces.player;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.objects.card.Card;
import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.Player;
import java.util.List;

/**
 * An interface contains methods to be implemented by GoFishPlayer
 * 
 * @author Wenya Guo 28-Jul-2022
 */
public interface PlayerActions {
    
    boolean goFish(Player player, CardValue cardValue, DeckCards deckCards);
    
    List<Card> handsCard(CardValue cardValue);

}
