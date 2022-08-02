/**
 * SYST 17796 Project Base code. Students can modify and extend to implement
 * their game. Add your name as an author and the date!
 */
package ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardSuit;
import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.interfaces.card.CardActions;

import java.util.*;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Patrick Hogg
 */
public abstract class GroupOfCards implements CardActions {

    //The group of cards, stored in an ArrayList
    private List<Card> cards = new ArrayList<>();

    /**
     * Instantiates a new Group of cards.
     */
    protected GroupOfCards() {
    }

    /**
     * Instantiates a new Group of cards.
     *
     * @param cards the cards
     */
    protected GroupOfCards(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Sets cards.
     *
     * @param cards the cards
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Add card.
     *
     * @param card the card
     */
    public void addCard(Card card) {
        getCards().add(card);
    }

    /**
     * Remove card.
     *
     * @param card the card
     */
    public void removeCard(Card card) {
        getCards().remove(card);
    }

    /**
     * Gets top card.
     *
     * @return the top card
     */
    public Card getTopCard() {
        if(!getCards().isEmpty()){
            return getCards().get(0);
        }else{
            return null;
        }
    }

    /**
     * Shuffle.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public List<Card> withdrawCards(int amount) {
        // Create a new empty ArrayList of card objects
        List<Card> withdrawnCards = new ArrayList<>();
        // Loop until the amount has been reached
        for (int i = 0; i < amount; i++) {
            // Make a new Card object from the topCard of the deck
            Card topCard = getTopCard();
            // Add the new card to the withdrawnCards list
            withdrawnCards.add(topCard);
            // Remove the withdrawn card from the deck cards list
            removeCard(topCard);
        }
        // Return the list of withdrawn cards
        return withdrawnCards;
    }

    @Override
    public int countNumOfCards(CardValue cardValue) {
        // Returns the amount of cards of the provided card value
        return getAllCardsOfValue(cardValue).size();
    }

    @Override
    public List<Card> getAllCardsOfValue(CardValue cardValue) {
        // Create a new empty ArrayList of Card objects
        List<Card> foundCards = new ArrayList<>();
        // Loop through all the cards in the list of cards
        for (Card card : getCards()) {
            // If the current card element matches the provided card value
            if (card.getCardValue().equals(cardValue)) {
                // Add the card to the found cards ArrayList
                foundCards.add(card);
            }
        }
        // Return all the found cards
        return foundCards;
    }

    public Card getCardOfValue(CardValue cardValue) {
        Card missingCard = null;
        // Loop through all the card suit values in the enum
        for (CardSuit cardSuit : CardSuit.values()) {
            // Create a new card object with the current card suit, and the
            // card value of the highest priority card
            missingCard = new Card(cardSuit, cardValue);
            // If the players hand doesn't contain the card
            // Then this card must be a card that the player needs
            if (!getCards().contains(missingCard)) {
                break;
            }
        }
        return missingCard;
    }

    @Override
    public HashMap<CardValue, Integer> getOccurrencesOfCardValue() {
        // Create a new empty HashMap of CardValue and Integer objects
        HashMap<CardValue, Integer> cardAmounts = new HashMap();
        // Loop through all the card value types
        for (CardValue cardValue : CardValue.values()) {
            // Count each occurrence of each card type and place the results
            // in the HashMap
            cardAmounts.put(cardValue, countNumOfCards(cardValue));
        }
        // Return the HashMap
        return cardAmounts;
    }

    /**
     * This method is recursive.
     *
     * This is to be used for determining the order of cards that are of
     * priority in the players hand. The first element is the highest
     * priority, and the player should ask for those cards first.
     *
     * Takes in a Map with CardValue as the Key, and Integer as the Value.
     * Returns a List of CardValues, where the first element had the highest
     * value in the map. The List is sorted from the highest priority, to
     * lowest.
     * @param cardAmounts A map containing the CardValue and number of times
     *                    it occurred in the players hand.
     * @param sortedList The list that will contain the sorted list.
     * @return a List of CardValue type that should be sorted.
     */
    @Override
    public List<CardValue> getCardValuePriority(Map<CardValue,
            Integer> cardAmounts, List<CardValue> sortedList){
        // Recursive Base Case
        // Runs the recursion until the cardAmounts list is empty.
        while (!cardAmounts.isEmpty()) {
            // Get the CardValue with the most occurrences
            CardValue max = Collections.max(cardAmounts.entrySet(),
                                            Map.Entry.comparingByValue()).getKey();
            // Add the max to the sortedList
            sortedList.add(max);
            // Remove the max from the cardAmounts list
            cardAmounts.remove(max);
            // Recursive call
            getCardValuePriority(cardAmounts, sortedList);
        }
        // Return the sortedList
        return sortedList;
    }

    @Override
    public void printCards() {
        // Prints each card as a new line
        getCards().forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GroupOfCards that)) {
            return false;
        }
        return Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    @Override
    public String toString() {
        return "GroupOfCards{" + "cards=" + cards + '}';
    }
}//end class
