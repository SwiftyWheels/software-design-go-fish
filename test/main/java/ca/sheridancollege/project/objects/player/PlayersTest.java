/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.objects.player.GoFishPlayer;
import ca.sheridancollege.project.objects.player.Players;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is the testing methods in Players class
 * @author Wenya Guo
 */
public class PlayersTest {
    
    public PlayersTest() {
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
     * Test of getPlayerList method, of class Players.
     */
    @Test
    public void testGetAndSetPlayerList() {
        System.out.println("Testing getPlayerList and setPlayerList for players: ");
        Players players = new Players();
        
        //create a player list for testing
        List<GoFishPlayer> playerList = new ArrayList<GoFishPlayer>();
        playerList.add(new GoFishPlayer("Peter"));
        playerList.add(new GoFishPlayer("Patrick"));
        playerList.add(new GoFishPlayer("Wenya"));
        
        //call setPlayerList method
        players.setPlayerList(playerList);
        
        
        List<GoFishPlayer> expResult = playerList;
        List<GoFishPlayer> result = players.getPlayerList();
        assertEquals(expResult, result);
    }


    /**
     * Test of getPlayer method, of class Players.
     */
    @Test
    public void testGetPlayerGood() {
        System.out.println("Testing getPlayerGood: ");
        
        //find Peter successfully in the players list
        GoFishPlayer player = new GoFishPlayer("Peter");
        
        Players players = new Players();
        List<GoFishPlayer> playerList = new ArrayList<GoFishPlayer>();
        playerList.add(new GoFishPlayer("Peter"));
        playerList.add(new GoFishPlayer("Patrick"));
        playerList.add(new GoFishPlayer("Wenya"));
        players.setPlayerList(playerList);

        GoFishPlayer expResult = player;
        GoFishPlayer result = players.getPlayer(player);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGetPlayerBad() {
        System.out.println("Testing getPlayerBad: ");
        
        //There is no Peter in the players list
        GoFishPlayer player = new GoFishPlayer("Peter");
        
        Players players = new Players();
        List<GoFishPlayer> playerList = new ArrayList<GoFishPlayer>();
        playerList.add(new GoFishPlayer("Allie"));
        playerList.add(new GoFishPlayer("Patrick"));
        playerList.add(new GoFishPlayer("Wenya"));
        players.setPlayerList(playerList);
        
        
        GoFishPlayer expResult = player;
        GoFishPlayer result = players.getPlayer(player);
        assertNotEquals(expResult, result);

    }

    /**
     * Test of addPlayer method, of class Players.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("Testing addPlayer: ");
        
        //create new player Ellen and add it into players
        GoFishPlayer player1 = new GoFishPlayer("Ellen");
        Players players = new Players();
        players.addPlayer(player1);
        
        boolean expResult = true;
        //check if the player has been added into playerList
        boolean result = players.getPlayerList().contains(player1);
    
        assertEquals(expResult, result);

    }

    /**
     * Test of removePlayer method, of class Players.
     */
    @Test
    public void testRemovePlayer() {
        System.out.println("Testing removePlayer: ");
        
        Players players = new Players();
        
        //create a players object
        List<GoFishPlayer> playerList = new ArrayList<GoFishPlayer>();
        GoFishPlayer p1 = new GoFishPlayer("Allie");
        GoFishPlayer p2 = new GoFishPlayer("Patrick");
        GoFishPlayer p3 = new GoFishPlayer("Peter");
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        players.setPlayerList(playerList);
        
        //remove one player
        players.removePlayer(p3);
        
        
        boolean expResult = true;
        //check if the removed player not in the playerList
        boolean result = !(players.getPlayerList().contains(p3));
        System.out.println(result);
        
        assertEquals(expResult, result);

    }
    

    
}
