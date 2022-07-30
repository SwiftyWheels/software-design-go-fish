package ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.interfaces.player.PlayerActions;
import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.Card;
import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.card.HandCards;
import java.util.ArrayList;
import java.util.List;

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
    public boolean goFish(Player player, CardValue cardValue, DeckCards deckCards){
        GoFishPlayer goFishPlayer = (GoFishPlayer)player;
        List<Card> returnedToFisherCards = goFishPlayer.handsCard(cardValue);//cards which fisher get from other player
        //if no card return to fisher, fisher draw card from deck, 
        if (returnedToFisherCards.isEmpty()) {
            //TODO Need a method to get a new card from deckcards.
            Card newCard = null;
            handcards.getHandCards().add(newCard);//add the new card to handcards
            if (cardValue == newCard.getCardValue())
                //If the new card value matched with the fisher called.Player can continue to call GoFish
                return true;    
            else
                return false;//If not match, ends the turn
        }
        
   
        int count = countCard(cardValue);
        
        //check if a book has been built
        if (count + returnedToFisherCards.size() == 4) {
            // TODO Add this card value to books
            
            // Remove the book cards from handcards
            List<Card> newCards = new ArrayList<>();
            for (Card card : handcards.getHandCards())
                if (card.getCardValue() != cardValue)
                    newCards.add(card);
            handcards.setHandCards(newCards);
        } else {
            // Add all returned cards  to handcards
            handcards.getHandCards().addAll(returnedToFisherCards);
        }
        return true;
    }
    
    //count how many called card in hand
    private int countCard(CardValue cardValue) {
        int n = 0;
        for (Card card : handcards.getHandCards())
            if (card.getCardValue() == cardValue)
                n++;
        return n;
    }
    
    
    @Override
    //hands card to fisher if card value matched with gofish call
    public List<Card> handsCard(CardValue cardValue) {
        List<Card> cardList = handcards.getHandCards();//get hand cards
        List<Card> newHandCardList = new ArrayList<>();//for storing new hand card 
        List<Card> handedOutCardList = new ArrayList<>();//for storing cards which need to handed out to fisher
        
        //check if any hand card's value matched with the value which fisher called
        for (Card card : cardList) {
            if (card.getCardValue() == cardValue)
                handedOutCardList.add(card); 
            else
                newHandCardList.add(card);
        }
        this.handcards.setHandCards(newHandCardList);//refresh handcards
        return handedOutCardList;
    }

}
