/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.enums.CardSuit;
import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.objects.card.Book;
import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.Card;
import ca.sheridancollege.project.objects.card.HandCards;
import ca.sheridancollege.project.objects.player.GoFishPlayer;
import ca.sheridancollege.project.objects.player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is the testing methods in Player class
 * @author Wenya Guo
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        //this will run before all tests
        System.out.println("Beginning unit test");
    }
    
    @AfterClass
    public static void tearDownClass() {
        
          //this will run after all tests
        System.out.println("\n Unit Tests Completed");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        System.out.println("----------------------------");
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("Testing getName method: ");
        Player player1 = new GoFishPlayer("Player1");
        String expResult = "Player1";
        String result = player1.getName();
        System.out.println(result);
        assertEquals(expResult, result);
    }
    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName() {
        System.out.println("Testing setName method: ");
        String name = "Player2";
        Player player2 = new GoFishPlayer(name);
        player2.setName(name);
        
        String expResult = "Player2";
        String result = player2.getName();
        
        assertEquals(expResult, result);
        
    }
    

    /**
     * Test of getBooks method, of class Player.
     */
    @Test
    public void testGetAndSetBooks() {
       
        System.out.println("Testing getBooks and setBooks method in player class: ");

        Player player1 = new GoFishPlayer("Player1");
        player1.setBooks(createBooks());
        
        Books expResult = createBooks();
        Books result = player1.getBooks();
        assertEquals(expResult, result);
      
    }


    /**
     * Test of getHandCards method, of class Player.
     */
    @Test
    public void testGetAndSetHandCards() {
        System.out.println("Testing getHandCards and setHandCards method in player class: ");
        
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(CardSuit.HEARTS, CardValue.THREE));
        cards.add(new Card(CardSuit.DIAMONDS, CardValue.EIGHT));
        cards.add(new Card(CardSuit.CLUBS, CardValue.SEVEN));
        cards.add(new Card(CardSuit.SPADES, CardValue.QUEEN));
        cards.add(new Card(CardSuit.SPADES, CardValue.FIVE));
        
        HandCards handCards = new HandCards();
        handCards.setCards(cards);

        Player player = new GoFishPlayer("Ellen");
        player.setHandCards(handCards);
        HandCards expResult = handCards;
        HandCards result = player.getHandCards();
        assertEquals(expResult, result);

    }


    /**
     * Test of equals method, of class Player.
     */
    @Test
    public void testEqualsGood() {
        System.out.println("Testing equalsGood: ");
        
        //if o is an instance of player, return true
        Object o = new GoFishPlayer("Ellen");
        Player player1 = new GoFishPlayer("Ellen");
        
        boolean expResult = true;
        boolean result = player1.equals(o);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testEqualsBad() {
        System.out.println("Testing equalsBad: ");
        
        //if o is not an instance of player, return false
        Object o = new Books();
        Player player1 = new GoFishPlayer("Ellen");
        
        boolean expResult = false;
        boolean result = player1.equals(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Player.
     */
    @Test
    public void testHashCodeGood() {
        System.out.println("Testing hashCodeGood: ");
        
        Player instance = new GoFishPlayer("Ellen",new Books(), new HandCards());

        int expResult = Objects.hash("Ellen",new Books(), new HandCards());
        int result = instance.hashCode();
        assertEquals(expResult, result);
     
    }
    
    @Test
    public void testHashCodeBad() {
        System.out.println("Testing hashCodeBad: ");
        
        Player instance = new GoFishPlayer("Ellen",new Books(), new HandCards());

        int expResult = Objects.hash("Amy",new Books(), new HandCards());
        int result = instance.hashCode();
        assertNotEquals(expResult, result);
     
    }

    //this method is for testing getBooks and setBooks method
    private Books createBooks() {
        List<Card> cardsList1 = new ArrayList<Card>();
        cardsList1.add(new Card(CardSuit.HEARTS, CardValue.ACE));
        cardsList1.add(new Card(CardSuit.DIAMONDS, CardValue.ACE));
        cardsList1.add(new Card(CardSuit.CLUBS, CardValue.ACE));
        cardsList1.add(new Card(CardSuit.SPADES, CardValue.ACE));

        List<Card> cardsList2 = new ArrayList<Card>();
        cardsList2.add(new Card(CardSuit.HEARTS, CardValue.KING));
        cardsList2.add(new Card(CardSuit.DIAMONDS, CardValue.KING));
        cardsList2.add(new Card(CardSuit.CLUBS, CardValue.KING));
        cardsList2.add(new Card(CardSuit.SPADES, CardValue.KING));

        Book book1 = new Book(cardsList1);
        Book book2 = new Book(cardsList2);

        List<Book> booklist = new ArrayList<Book>();
        booklist.add(book1);
        booklist.add(book2);

       Books books = new Books(booklist);
       return books;
}
    
}
