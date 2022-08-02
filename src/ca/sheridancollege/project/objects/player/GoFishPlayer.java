package ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.interfaces.player.PlayerActions;
import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.Card;
import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.card.HandCards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class that models the go fish player in the game.
 *
 * @author Wenya Guo 28-Jul-2022
 * @author Patrick Hogg
 */
public class GoFishPlayer extends Player implements PlayerActions {

    /**
     * Instantiates a new Go fish player.
     *
     * @param name the name
     */
    public GoFishPlayer(String name) {
        super(name);
    }

    /**
     * Instantiates a new Go fish player.
     *
     * @param name      the name
     * @param books     the books
     * @param handCards the handCards
     */
    public GoFishPlayer(String name, Books books, HandCards handCards) {
        super(name, books, handCards);
    }

    @Override
    public void goFish(DeckCards deckCards) {
        if (!deckCards.getCards().isEmpty()) {
            // Grab the top card from the deck
            Card topCard = deckCards.getTopCard();
            System.out.println("Drew card: " + topCard);
            if (topCard != null) {
                // Add the top card to your hand cards
                getHandCards().addCard(topCard);
                // Remove the top card from the deck list of cards
                deckCards.removeCard(topCard);
                // Try to make a book with the newly received card
                tryToMakeBook(topCard);
            }
        }else{
            System.out.println("Deck is empty.");
        }
    }

    @Override
    public void handCardToPlayer(Player player, Card card) {
        // If the player hand contains the card that was asked
        if (getHandCards().getCards().contains(card)) {
            System.out.println("Giving card to " + player);
            // Add the card to the asking players hand
            player.getHandCards().addCard(card);
            // Remove the card from the asked players hand
            getHandCards().removeCard(card);
        }
    }

    @Override
    public void askPlayerForCard(Player player, CardValue cardValue,
                                 DeckCards deckCards, int priorityNum) {
        System.out.println(this.getName() + "'s turn.");
        System.out.println("Asking for: " + cardValue + " from: " + player.getName());

        List<Card> allCardsOfValue = player.getHandCards().getAllCardsOfValue(
                cardValue);
        // if the asked player hand contains the card requested
        if (!allCardsOfValue.isEmpty()) {
            for (Card card : allCardsOfValue) {
                System.out.println(
                        "Got " + card + " from " + player.getName() + "!");
                // The asked player will hand the card over to this player
                player.handCardToPlayer(this, card);

                // Try to make a book with the newly received card
                tryToMakeBook(card);
            }

            System.out.println("Asking again");
            priorityNum++;
            askPlayerForCardPriority(player, deckCards, priorityNum);
        } else {
            System.out.println("Go Fish");
            goFish(deckCards);
        }
    }

    @Override
    public void askPlayerForCardPriority(Player player, DeckCards deckCards,
                                         int priorityNum) {
        // Gets a HashMap that contains the occurrences of each card value
        HashMap<CardValue, Integer> cardAmounts
                = getHandCards().getOccurrencesOfCardValue();

        // Creates an empty ArrayList of Card objects to use as a priority list
        List<CardValue> priorityList = new ArrayList<>();
        // Populate the priority list with the card priorities
        priorityList = getHandCards().getCardValuePriority(cardAmounts,
                                                           priorityList);

        if (priorityNum < priorityList.size()) {
            askPlayerForCard(player, priorityList.get(priorityNum), deckCards
                    , priorityNum);
        }else{
            System.out.println("Entered invalid priority num");
            askPlayerForCard(player, priorityList.get(0), deckCards, priorityNum);
        }

    }


    private void tryToMakeBook(Card card) {
        // Check if this player can make a book
        if (card != null && getHandCards().canMakeBook(card.getCardValue())) {
            // Create a list of cards of the same value from players hand cards
            List<Card> bookCards = getHandCards().getAllCardsOfValue(
                    card.getCardValue());
            // Get the players Books, and create a new book using the cards
            // above
            getBooks().createBook(bookCards, card.getCardValue());

            // Remove all the cards from the players hands that were used to
            // make a book
            getHandCards().getCards().removeAll(bookCards);
        }
    }

}
