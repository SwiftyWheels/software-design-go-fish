package ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardSuit;
import ca.sheridancollege.project.enums.CardValue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class GroupOfCardsTest {
    GroupOfCards groupOfCards = new DeckCards();

    @Before
    public void setUp() throws Exception {
        groupOfCards.getCards().clear();
        groupOfCards.addCard(new Card(CardSuit.HEARTS, CardValue.FIVE));
        groupOfCards.addCard(new Card(CardSuit.HEARTS, CardValue.SIX));
        groupOfCards.addCard(new Card(CardSuit.HEARTS, CardValue.SEVEN));
        groupOfCards.addCard(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        groupOfCards.addCard(new Card(CardSuit.CLUBS, CardValue.KING));
        groupOfCards.addCard(new Card(CardSuit.DIAMONDS, CardValue.ACE));
    }

    @Test
    public void getCards() {
        List<Card> cards = groupOfCards.getCards();
        assertEquals(cards, groupOfCards.getCards());
    }

    @Test
    public void setCards() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(CardSuit.CLUBS, CardValue.FIVE));
        cardList.add(new Card(CardSuit.CLUBS, CardValue.SEVEN));
        cardList.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        groupOfCards.setCards(cardList);

        assertEquals(cardList, groupOfCards.getCards());
    }

    @Test
    public void addCard() {
        Card card = new Card(CardSuit.SPADES, CardValue.KING);
        int sizeOfCards = groupOfCards.getCards().size();
        groupOfCards.addCard(card);
        int newSizeOfCards = groupOfCards.getCards().size();

        assertNotEquals(sizeOfCards, newSizeOfCards);
        assertTrue(groupOfCards.getCards().contains(card));
    }

    @Test
    public void removeCard() {
        Card card = new Card(CardSuit.SPADES, CardValue.KING);

        groupOfCards.addCard(card);
        assertTrue(groupOfCards.getCards().contains(card));
        groupOfCards.removeCard(card);
        assertFalse(groupOfCards.getCards().contains(card));
    }

    @Test
    public void getTopCard() {
        Card topCard = groupOfCards.getTopCard();

        assertEquals(topCard, groupOfCards.getCards().get(0));
    }

    @Test
    public void shuffle() {
        List<Card> cardList = new ArrayList<>(groupOfCards.getCards());

        groupOfCards.shuffle();
        assertNotEquals(cardList, groupOfCards.getCards());
    }

    @Test
    public void withdrawCards() {
        int sizeOfGroupOfCards = groupOfCards.getCards().size();
        List<Card> cardsToWithdraw = groupOfCards.withdrawCards(3);

        assertNotEquals(sizeOfGroupOfCards, groupOfCards.getCards().size());

        for (Card card : cardsToWithdraw) {
            assertFalse(groupOfCards.getCards().contains(card));
        }

    }

    @Test
    public void countNumOfCards() {
        int cardCount = groupOfCards.countNumOfCards(CardValue.FIVE);
        assertEquals(1, cardCount);
    }

    @Test
    public void getAllCardsOfValue() {
        List<Card> cardsToCompare = new ArrayList<>();
        cardsToCompare.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        cardsToCompare.add(new Card(CardSuit.HEARTS, CardValue.EIGHT));

        groupOfCards.addCard(new Card(CardSuit.HEARTS, CardValue.EIGHT));
        assertEquals(cardsToCompare,
                     groupOfCards.getAllCardsOfValue(CardValue.EIGHT));
    }

    @Test
    public void getCardOfValue() {
        Card cardToCompare = new Card(CardSuit.HEARTS, CardValue.FIVE);
        assertNotEquals(cardToCompare,
                        groupOfCards.getCardOfValue(CardValue.FIVE));
    }

    @Test
    public void getOccurrencesOfCardValue() {
        HashMap<CardValue, Integer> cardOccurrences = new HashMap<>();
        cardOccurrences.put(CardValue.THREE, 0);
        cardOccurrences.put(CardValue.SIX, 1);
        cardOccurrences.put(CardValue.EIGHT, 1);
        cardOccurrences.put(CardValue.FIVE, 1);
        cardOccurrences.put(CardValue.FOUR, 0);
        cardOccurrences.put(CardValue.NINE, 0);
        cardOccurrences.put(CardValue.KING, 1);
        cardOccurrences.put(CardValue.TEN, 0);
        cardOccurrences.put(CardValue.TWO, 0);
        cardOccurrences.put(CardValue.JACK, 0);
        cardOccurrences.put(CardValue.ACE, 1);
        cardOccurrences.put(CardValue.QUEEN, 0);
        cardOccurrences.put(CardValue.SEVEN, 1);

        assertEquals(cardOccurrences, groupOfCards.getOccurrencesOfCardValue());
    }

    @Test
    public void getCardValuePriority() {
        groupOfCards.addCard(new Card(CardSuit.HEARTS, CardValue.KING));

        HashMap<CardValue, Integer> cardValuesToSort
                = groupOfCards.getOccurrencesOfCardValue();
        List<CardValue> sortedPriorityList = new ArrayList<>();
        sortedPriorityList = groupOfCards.getCardValuePriority(cardValuesToSort,
                                                               sortedPriorityList);

        assertEquals(CardValue.KING, sortedPriorityList.get(0));
    }
}