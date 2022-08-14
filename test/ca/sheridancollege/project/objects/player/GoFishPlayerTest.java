package ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.enums.CardSuit;
import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.Card;
import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.card.HandCards;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GoFishPlayerTest {

    GoFishPlayer player = new GoFishPlayer("Patrick");
    DeckCards deckCards = new DeckCards();

    @Before
    public void setUp() throws Exception {
        player.setName("Patrick");
        player.getHandCards().getCards().clear();
        player.getBooks().getBookList().clear();

        getDeckCards().getCards().clear();
        getDeckCards().setCards(getDeckCards().generateCards());
    }

    public GoFishPlayer getPlayer() {
        return player;
    }

    public void setPlayer(GoFishPlayer player) {
        this.player = player;
    }

    public DeckCards getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(DeckCards deckCards) {
        this.deckCards = deckCards;
    }

    @Test
    public void getName() {
        assertEquals("Patrick", getPlayer().getName());
    }

    @Test
    public void setName() {
        String name = "Test";
        getPlayer().setName(name);
        assertEquals(getPlayer().getName(), name);
    }

    @Test
    public void getBooks() {
        Books books = getPlayer().getBooks();
        assertEquals(books, getPlayer().getBooks());
    }

    @Test
    public void setBooks() {
        Books books = new Books();
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(CardSuit.HEARTS, CardValue.TWO));
        cardList.add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
        cardList.add(new Card(CardSuit.SPADES, CardValue.TWO));
        cardList.add(new Card(CardSuit.CLUBS, CardValue.TWO));
        books.createBook(cardList, CardValue.TWO);

        getPlayer().setBooks(books);

        assertEquals(books, getPlayer().getBooks());
    }

    @Test
    public void getHandCards() {
        HandCards handCards = getPlayer().getHandCards();
        assertEquals(handCards, getPlayer().getHandCards());
    }

    @Test
    public void setHandCards() {
        HandCards handCards = new HandCards();
        handCards.addCard(new Card(CardSuit.HEARTS, CardValue.ACE));
        getPlayer().setHandCards(handCards);
        assertEquals(handCards, getPlayer().getHandCards());
    }

    @Test
    public void goFish() {
        getPlayer().goFish(getDeckCards());
        HandCards handCardsBeforeGoFish = new HandCards();
        handCardsBeforeGoFish.setCards(getPlayer().getHandCards().getCards());

        Books booksBeforeGoFish = new Books();
        booksBeforeGoFish.setBookList(getPlayer().getBooks().getBookList());

        assertTrue(handCardsBeforeGoFish != getPlayer().getHandCards()
                   || booksBeforeGoFish != getPlayer().getBooks());
    }

    @Test
    public void handCardToPlayer() {
        GoFishPlayer newPlayer = new GoFishPlayer("Test");
        getPlayer().getHandCards().addCard(
                new Card(CardSuit.HEARTS, CardValue.TWO));
        Card playersCard = getPlayer().getHandCards().getTopCard();
        getPlayer().handCardToPlayer(newPlayer, playersCard);

        assertFalse(
                getPlayer().getHandCards().getCards().contains(playersCard));
        assertTrue(newPlayer.getHandCards().getCards().contains(playersCard));
    }

    @Test
    public void askPlayerForCard() {
        GoFishPlayer newPlayer = new GoFishPlayer("Test");
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.HEARTS, CardValue.TWO));
        cards.add(new Card(CardSuit.HEARTS, CardValue.THREE));
        cards.add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
        cards.forEach(card -> newPlayer.getHandCards().addCard(card));

        getPlayer().askPlayerForCard(newPlayer, CardValue.TWO, getDeckCards(),
                                     0);

        assertTrue(getPlayer().getHandCards().getCards().contains(
                new Card(CardSuit.HEARTS, CardValue.TWO)));
        assertTrue(getPlayer().getHandCards().getCards().contains(
                new Card(CardSuit.DIAMONDS, CardValue.TWO)));
    }

    @Test
    public void askPlayerForCardPriority() {
        GoFishPlayer newPlayer = new GoFishPlayer("Test");
        List<Card> newPlayerCards = new ArrayList<>();
        List<Card> playerCards = new ArrayList<>();

        newPlayerCards.add(new Card(CardSuit.HEARTS, CardValue.TWO));
        newPlayerCards.add(new Card(CardSuit.HEARTS, CardValue.THREE));
        newPlayerCards.add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
        newPlayerCards.forEach(card -> newPlayer.getHandCards().addCard(card));

        playerCards.add(new Card(CardSuit.CLUBS, CardValue.ACE));
        playerCards.add(new Card(CardSuit.CLUBS, CardValue.TWO));
        playerCards.add(new Card(CardSuit.SPADES, CardValue.TWO));

        playerCards.forEach(card -> getPlayer().getHandCards().addCard(card));

        int numOfPlayerBooks = getPlayer().getBooks().getBookList().size();

        getPlayer().askPlayerForCardPriority(newPlayer, getDeckCards(), 0);

        assertTrue((getPlayer().getHandCards().getCards().contains(
                new Card(CardSuit.HEARTS, CardValue.TWO))
                    || numOfPlayerBooks != getPlayer().getBooks().getBookList()
                                                      .size()));

        assertTrue((getPlayer().getHandCards().getCards().contains(
                new Card(CardSuit.DIAMONDS, CardValue.TWO))
                    || numOfPlayerBooks != getPlayer().getBooks().getBookList()
                                                      .size()));

    }
}