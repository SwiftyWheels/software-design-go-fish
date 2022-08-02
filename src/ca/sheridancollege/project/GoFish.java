package ca.sheridancollege.project;

import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.Dealer;
import ca.sheridancollege.project.objects.player.GoFishPlayer;
import ca.sheridancollege.project.objects.player.Player;
import ca.sheridancollege.project.objects.player.Players;

import java.util.*;

/**
 * The main class of our GoFish game.
 *
 * @author Patrick Hogg
 */
public class GoFish {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // To be filled
        DeckCards deckCards = new DeckCards();
        Dealer patrick = new Dealer("Patrick");
        GoFishPlayer player = new GoFishPlayer("Player");
        GoFishPlayer player2 = new GoFishPlayer("Player2");
        GoFishPlayer player3 = new GoFishPlayer("Player3");
        GoFishPlayer player4 = new GoFishPlayer("Player4");

        Players players = new Players();
        players.addPlayer(patrick); // 2
        players.addPlayer(player); // 1
        players.addPlayer(player2); // 1
        players.addPlayer(player3); // 4
        players.addPlayer(player4); // 1

        patrick.dealCards(deckCards, players);
        simulateGame(deckCards, players);
        System.out.println("Winner: " + checkWinner(players));
        System.out.println("Winner Books: " + checkWinner(players).getBooks()
                                                                  .getBookList()
                                                                  .size());

        HashMap<String, Integer> playerRanks = getPlayerRank(players);

        for (Map.Entry<String, Integer> entry : playerRanks.entrySet()) {
            System.out.println(entry);
        }
    }

    /**
     * This simulates an entire game of Go Fish.
     * @param deckCards The deck of cards to play with
     * @param players The list of players to play with
     */
    private static void simulateGame(DeckCards deckCards, Players players) {
        Players currentlyPlayingPlayers = new Players();
        currentlyPlayingPlayers.getPlayerList().addAll(players.getPlayerList());

        List<GoFishPlayer> playerList = currentlyPlayingPlayers.getPlayerList();
        while (countAllBooks(playerList) < 13 && playerList.size() > 1) {
            for (GoFishPlayer player : playerList) {
                Player randomPlayer = getRandomPlayer(playerList);
                while (player.equals(randomPlayer) && playerList.size() > 1) {
                    randomPlayer = getRandomPlayer(playerList);
                }
                if (player.getHandCards().getCards().isEmpty()
                    && deckCards.getCards().isEmpty()) {
                    System.out.println("-------------------------------------");
                    System.out.println("Removing " + player + " from game.");
                    System.out.println(player.getBooks().getBookList().size());
                    playerList.remove(player);
                    System.out.println("-------------------------------------");
                    break;
                } else if (!player.getHandCards().getCards().isEmpty()) {
                    player.askPlayerForCardPriority(randomPlayer, deckCards, 0);
                } else {
                    player.goFish(deckCards);
                }
            }
        }
    }

    private static GoFishPlayer getRandomPlayer(List<GoFishPlayer> players) {
        int randomInt = new Random().nextInt(players.size());
        return players.get(randomInt);
    }

    private static GoFishPlayer checkWinner(Players players) {
/*
        todo: Fix it so that if there is a tie, a winner is chosen
        HashMap<String, Integer> playerRanks = getPlayerRank(players);
        NavigableMap<String, Integer> sortedRanks = getSortedListOfPlayers(
                playerRanks);

        for (Map.Entry<String, Integer> player : sortedRanks.entrySet()) {
            if (player.getValue().equals(
                    sortedRanks.higherEntry(player.getKey()).getValue())) {
                int coinToss = new Random().nextInt(2);
                if (coinToss == 1) {

                }
            }
        } */

        int mostBooks = 0;
        GoFishPlayer winningPlayer = null;

        for (GoFishPlayer player : players.getPlayerList()) {
            if (player.getBooks().getBookList().size() > mostBooks) {
                mostBooks = player.getBooks().getBookList().size();
                winningPlayer = player;
            }
        }
        return players.getPlayer(winningPlayer);
    }


    private static NavigableMap<String, Integer> getSortedListOfPlayers(
            HashMap<String, Integer> players) {
        NavigableMap<String, Integer> sortedList = new TreeMap<>();
        // Recursive Base Case
        // Runs the recursion until the cardAmounts list is empty.
        while (!players.isEmpty()) {
            // Get the CardValue with the most occurrences
            String maxName = Collections.max(players.entrySet(),
                                             Map.Entry.comparingByValue())
                                        .getKey();
            Integer maxValue = Collections.max(players.entrySet(),
                                               Map.Entry.comparingByValue())
                                          .getValue();
            // Add the max to the sortedList
            sortedList.put(maxName, maxValue);
            // Remove the max from the cardAmounts list
            players.remove(maxName, maxValue);
            // Recursive call
            getSortedListOfPlayers(players);
        }
        // Return the sortedList
        return sortedList;
    }

    private static int countAllBooks(List<GoFishPlayer> players) {
        int bookCount = 0;
        for (GoFishPlayer player : players) {
            bookCount += player.getBooks().getBookList().size();
        }
        return bookCount;
    }

    private static HashMap<String, Integer> getPlayerRank(Players players) {
        HashMap<String, Integer> playerRanks = new HashMap<>();

        for (Player player : players.getPlayerList()) {
            playerRanks.put(player.getName(),
                            player.getBooks().getBookList().size());
        }

        return playerRanks;
    }
}
