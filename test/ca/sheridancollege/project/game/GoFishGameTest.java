package ca.sheridancollege.project.game;

import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.GoFishPlayer;
import ca.sheridancollege.project.objects.player.Player;
import ca.sheridancollege.project.objects.player.Players;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GoFishGameTest {

    private static Players players = new Players();
    private static GoFishGame goFishGame = new GoFishGame(players);

    @Before
    public void setUp() throws Exception {
        getGoFishGame().getPlayers().getPlayerList().clear();
        getGoFishGame().getPlayers().addPlayer(new GoFishPlayer("Patrick"));
        getGoFishGame().getPlayers().addPlayer(new GoFishPlayer("Wenya"));
        getGoFishGame().getPlayers().addPlayer(new GoFishPlayer("Peter"));
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public static GoFishGame getGoFishGame() {
        return goFishGame;
    }

    public static void setGoFishGame(GoFishGame goFishGame) {
        GoFishGameTest.goFishGame = goFishGame;
    }

    @Test
    public void getPlayers() {
        Players playersToCheck = goFishGame.getPlayers();

        assertEquals(playersToCheck, getGoFishGame().getPlayers());
    }

    @Test
    public void setPlayers() {
        Players playersToSet = new Players();
        playersToSet.addPlayer(new GoFishPlayer("player1"));
        playersToSet.addPlayer(new GoFishPlayer("player2"));
        playersToSet.addPlayer(new GoFishPlayer("player3"));

        getGoFishGame().setPlayers(playersToSet);

        assertEquals(playersToSet, getGoFishGame().getPlayers());
    }

    @Test
    public void checkWinner() {
        getGoFishGame().simulateGame(new DeckCards(),
                                     getGoFishGame().getPlayers());

        int mostBooks = 0;
        GoFishPlayer winningPlayer = null;

        for (GoFishPlayer player : getGoFishGame().getPlayers()
                                                  .getPlayerList()) {
            if (player.getBooks().getBookList().size() > mostBooks) {
                mostBooks = player.getBooks().getBookList().size();
                winningPlayer = player;
            }
        }
        assertEquals(winningPlayer, getGoFishGame().checkWinner());
    }

    @Test
    public void getRandomPlayer() {
        GoFishPlayer randomPlayer = goFishGame.getRandomPlayer();

        assertNotEquals(randomPlayer, getGoFishGame().getRandomPlayer());
    }

    @Test
    public void getPlayerLeaderboard() {
        HashMap<String, Integer> playerRanks = new HashMap<>();
        GoFishPlayer patrick = getGoFishGame().getPlayers().getPlayerList().get(
                0);
        GoFishPlayer wenya = getGoFishGame().getPlayers().getPlayerList().get(
                1);
        GoFishPlayer peter = getGoFishGame().getPlayers().getPlayerList().get(
                2);
        playerRanks.put(patrick.getName(),
                        patrick.getHandCards().getCards().size());
        playerRanks.put(wenya.getName(),
                        wenya.getHandCards().getCards().size());
        playerRanks.put(peter.getName(),
                        peter.getHandCards().getCards().size());

        assertEquals(playerRanks, getGoFishGame().getPlayerLeaderboard());
    }

    @Test
    public void getAllBooksInGame() {
        int bookCount = 0;
        for (Player player : getGoFishGame().getPlayers().getPlayerList()) {
            bookCount += player.getBooks().getBookList().size();
        }

        assertEquals(bookCount, getGoFishGame().getAllBooksInGame());
    }
}