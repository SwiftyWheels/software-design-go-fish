/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.Dealer;
import ca.sheridancollege.project.objects.player.GoFishPlayer;
import ca.sheridancollege.project.objects.player.Players;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  This class is the testing class for dealer deal the cards
 * @author Wenya Guo
 */
public class DealerTest {
    
    public DealerTest() {
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
     * Test of dealCards method, of class Dealer.
     */
    @Test
    public void testDealCardsNumOfPlayersLessThan4() {
        System.out.println("Testing dealCards() when number of players is less than 4");
        DeckCards deckCards = new DeckCards();
        
        //create players list which has 3 players
        Players players = new Players();
        players.addPlayer(new GoFishPlayer ("player1"));
        players.addPlayer(new GoFishPlayer ("player2"));
        players.addPlayer(new GoFishPlayer ("player3"));
        int numOfPlayers = players.getPlayerList().size();
        System.out.println("Testing for " + numOfPlayers + " players:");
        
        
        Dealer instance = new Dealer("dealer");
        instance.dealCards(deckCards, players);
        
        //check every player's handcards after dealing
        int expHandCardAmt = 7;
        System.out.println("Expected handcard in every player is: " + expHandCardAmt);
        int resultHandCardAmt = players.getPlayerList().get(0).getHandCards().getCards().size();
        System.out.println("Actual handcard in every player is: " + resultHandCardAmt);
        assertEquals(expHandCardAmt, resultHandCardAmt);
        
        //check the left number of deck cards after dealing
        int expDeckCardsLeftAmt = 52 - expHandCardAmt * numOfPlayers;
        System.out.println("Expected " + expDeckCardsLeftAmt + " left in deck");
        int resultDeckCardsLeftAmt = (deckCards.generateCards().size()) - (resultHandCardAmt * numOfPlayers);
        System.out.println("Actual " + resultDeckCardsLeftAmt + " left in deck");
        assertEquals(expDeckCardsLeftAmt, resultDeckCardsLeftAmt);
        
        
 
    }
    
    @Test
    public void testDealCardsNumOfPlayersGreaterThan4() {
        System.out.println("Testing dealCards() when number of players is greater than or equals to 4");
        DeckCards deckCards = new DeckCards();
        
        //create players list which has 5 players
        Players players = new Players();
        players.addPlayer(new GoFishPlayer ("player1"));
        players.addPlayer(new GoFishPlayer ("player2"));
        players.addPlayer(new GoFishPlayer ("player3"));
        players.addPlayer(new GoFishPlayer ("player4"));
        players.addPlayer(new GoFishPlayer ("player5"));
        int numOfPlayers = players.getPlayerList().size();
        System.out.println("Testing for " + numOfPlayers + " players:");
        
        
        Dealer instance = new Dealer("dealer");
        instance.dealCards(deckCards, players);
        
        //check every player's handcards after dealing
        int expHandCardAmt = 5;
        int resultHandCardAmt = players.getPlayerList().get(0).getHandCards().getCards().size();
        System.out.println("result is: " + resultHandCardAmt);
        assertEquals(expHandCardAmt, resultHandCardAmt);
        
        //check the left number of deck cards after dealing
        int expDeckCardsLeftAmt = 52 - expHandCardAmt * numOfPlayers;
        System.out.println("Expected " + expDeckCardsLeftAmt + " left in deck");
        int resultDeckCardsLeftAmt = (deckCards.generateCards().size()) - (resultHandCardAmt * numOfPlayers);
        System.out.println("Actual " + resultDeckCardsLeftAmt + " left in deck");
        assertEquals(expDeckCardsLeftAmt, resultDeckCardsLeftAmt);
        
 
    }
    


    
}
