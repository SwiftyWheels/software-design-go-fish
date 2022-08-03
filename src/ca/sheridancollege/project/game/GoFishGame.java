package ca.sheridancollege.project.game;

import ca.sheridancollege.project.interfaces.game.GameActions;
import ca.sheridancollege.project.objects.card.DeckCards;
import ca.sheridancollege.project.objects.player.Dealer;
import ca.sheridancollege.project.objects.player.GoFishPlayer;
import ca.sheridancollege.project.objects.player.Player;
import ca.sheridancollege.project.objects.player.Players;

import java.util.*;

/**
 * This class represents the game object for the game of Go Fish. This class
 * contains all the initialization and game logic for playing a game of Go Fish.
 * Currently, the game is automated and will run through one round of a game of
 * Go Fish from start to finish.
 *
 * @author Patrick Hogg
 */
public class GoFishGame extends Game implements GameActions {

    /**
     * Random to be used for anything random.
     */
    private final Random random = new Random();

    /**
     * Instantiates a new Game.
     */
    public GoFishGame(Players players) {
        super(players);
    }

    @Override
    public void play(DeckCards deckCards) {
        displayIntro();
        simulateGame(deckCards, getPlayers());
        declareWinner();
        displayGameOver();

    }

    /**
     * Displays an intro for the Go Fish game.
     */
    private void displayIntro() {
        System.out.println("----------------------------------");
        System.out.println("""
                             _____         ______ _     _    \s
                            / ____|       |  ____(_)   | |   \s
                           | |  __  ___   | |__   _ ___| |__ \s
                           | | |_ |/ _ \\  |  __| | / __| '_ \\\s
                           | |__| | (_) | | |    | \\__ \\ | | |
                            \\_____|\\___/  |_|    |_|___/_| |_|
                            """);
        System.out.println("Developers: ");
        System.out.println("Patrick Hogg");
        System.out.println("Wenya Guo");
        System.out.println("Peter Dropulic");
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    public void declareWinner() {
        // Print the leaderboard of the game
        printLeaderboard();
    }

    /**
     * This simulates an entire game of Go Fish.
     *
     * @param deckCards The deck of cards to play with
     * @param players   The list of players to play with
     */
    @Override
    public void simulateGame(DeckCards deckCards, Players players) {
        //
        Players currentlyPlayingPlayers = initPlayers(players);
        List<GoFishPlayer> playerList = currentlyPlayingPlayers.getPlayerList();

        dealCards(deckCards, players);

        while (winConditionsNotMet(playerList)) {
            for (GoFishPlayer player : playerList) {
                Player randomPlayer = getPlayer(playerList, player);
                if (playConditionsNotMet(deckCards, player)) {
                    System.out.println("-------------------------------------");
                    System.out.println("Removing " + player.getName() + " from "
                                       + "game.");
                    System.out.println("-------------------------------------");
                    playerList.remove(player);
                    break;
                } else if (!player.getHandCards().getCards().isEmpty()) {
                    player.askPlayerForCardPriority(randomPlayer, deckCards, 0);
                } else {
                    player.goFish(deckCards);
                }
            }
        }
    }

    @Override
    public GoFishPlayer checkWinner() {
        int mostBooks = 0;
        GoFishPlayer winningPlayer = null;

        for (GoFishPlayer player : getPlayers().getPlayerList()) {
            if (player.getBooks().getBookList().size() > mostBooks) {
                mostBooks = player.getBooks().getBookList().size();
                winningPlayer = player;
            }
        }
        return getPlayers().getPlayer(winningPlayer);
    }

    @Override
    public GoFishPlayer getRandomPlayer() {
        int randomInt = this.random.nextInt(
                getPlayers().getPlayerList().size());
        return getPlayers().getPlayerList().get(randomInt);
    }

    @Override
    public HashMap<String, Integer> getPlayerLeaderboard() {
        HashMap<String, Integer> playerRanks = new HashMap<>();

        for (Player player : getPlayers().getPlayerList()) {
            playerRanks.put(player.getName(),
                            player.getBooks().getBookList().size());
        }

        return playerRanks;
    }

    @Override
    public int getAllBooksInGame() {
        int bookCount = 0;
        for (Player player : getPlayers().getPlayerList()) {
            bookCount += player.getBooks().getBookList().size();
        }
        return bookCount;
    }

    /**
     * Initialize the players of the game.
     *
     * @param players the players to set as the players for the game.
     * @return the Players object that will contain all the players for the
     * game.
     */
    private Players initPlayers(Players players) {
        Players currentlyPlayingPlayers = new Players();
        currentlyPlayingPlayers.getPlayerList().addAll(players.getPlayerList());
        return currentlyPlayingPlayers;
    }

    /**
     * This will simulate the dealer dealing the cards to the players in the
     * game.
     *
     * @param deckCards the deck of cards to deal from.
     * @param players   the players to deal to.
     */
    private void dealCards(DeckCards deckCards, Players players) {
        System.out.println("Dealing Cards...");
        for (Player player : players.getPlayerList()) {
            if (player instanceof Dealer dealer) {
                dealer.dealCards(deckCards, players);
            }
        }
    }


    /**
     * Prints the leaderboard for the game.
     */
    private void printLeaderboard() {
        // Gets a sorted leaderboard from the highest books to lowest
        HashMap<String, Integer> playerRanks = getSortedLeaderboard();

        System.out.println("""
                             _                    _           _                         _\s
                            | |                  | |         | |                       | |
                            | |     ___  __ _  __| | ___ _ __| |__   ___   __ _ _ __ __| |
                            | |    / _ \\/ _` |/ _` |/ _ \\ '__| '_ \\ / _ \\ / _` | '__/ _` |
                            | |___|  __/ (_| | (_| |  __/ |  | |_) | (_) | (_| | | | (_| |
                            |______\\___|\\__,_|\\__,_|\\___|_|  |_.__/ \\___/ \\__,_|_|  \\__,_|
                           """);
        System.out.println("Winner: " + getWinner());
        System.out.println();
        // Loop through the hashmap and display the player and value of books
        for (Map.Entry<String, Integer> entry : playerRanks.entrySet()) {
            System.out.println(
                    entry.getKey() + " - books: " + entry.getValue());
        }
    }

    /**
     * Gets a random player from a list of players that isn't the current player
     * passed in the argument.
     *
     * @param playerList the list of players to choose from
     * @param player     the player to avoid picking
     * @return the random player chosen
     */
    private Player getPlayer(List<GoFishPlayer> playerList,
                             GoFishPlayer player) {
        Player randomPlayer = getRandomPlayer();
        while (player.equals(randomPlayer) && playerList.size() > 1) {
            randomPlayer = getRandomPlayer();
        }
        return randomPlayer;
    }

    /**
     * The conditions to check to see if the game has been won.
     *
     * @param playerList the list of players to check the size from
     * @return true if all conditions are met
     */
    private boolean winConditionsNotMet(List<GoFishPlayer> playerList) {
        return getAllBooksInGame() < 13 && playerList.size() > 1;
    }

    /**
     * The conditions to check if a player is still able to play in the Go Fish
     * game.
     *
     * @param deckCards The deck of cards to check if empty.
     * @param player    The player to check if their hand is empty.
     * @return True if deck cards and hand cards are empty.
     */
    private boolean playConditionsNotMet(DeckCards deckCards,
                                         GoFishPlayer player) {
        return player.getHandCards().getCards().isEmpty()
               && deckCards.getCards().isEmpty();
    }

    /**
     * Displays a game over screen.
     */
    private void displayGameOver() {
        System.out.println("""
                            ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______\s
                           |______|______|______|______|______|______|______|______|______|______|______|______|______|______|
                                                   / ____|                       / __ \\                                      \s
                                                  | |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ \s
                                                  | | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__| \s
                                                  | |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |                         \s
                                                   \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|                         \s
                            ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______ ______\s
                           |______|______|______|______|______|______|______|______|______|______|______|______|______|______|
                           """);
    }

    /**
     * Gets the winner of the Go Fish game. It will also do a coin toss if there
     * is a tie between two players.
     *
     * @return the winning player.
     */
    private String getWinner() {
        // Create a linked hashmap containing the players name and score
        LinkedHashMap<String, Integer> sortedLeaderboard
                = getSortedLeaderboard();

        // Loop through the hashmap
        for (Map.Entry<String, Integer> player : sortedLeaderboard.entrySet()) {
            // Get the next player in the hashmap
            String nextPlayerName = getNextPlayerInLeaderboard(
                    sortedLeaderboard, player);

            // If the leading players score is equal to the next player in
            // the leaderboard then it must be a tie
            if (player.getValue().equals(
                    sortedLeaderboard.get(nextPlayerName))) {
                System.out.println("TIE BREAKER");
                System.out.println(
                        player.getKey() + " tied with " + nextPlayerName);

                // Generate a random int between 0 and 1
                int coinToss = this.random.nextInt(2);
                // returns the top player if it's 0
                if (coinToss == 0) {
                    return player.getKey();
                } else {
                    // Returns the second player on the leaderboard if 1
                    return nextPlayerName;
                }
            } else {
                // If it's not a tie, just return the top player
                return player.getKey();
            }
        }
        // if all else fails, return null
        return null;
    }

    /**
     * Gets the leaderboard but in a sorted LinkedHashMap. This will contain the
     * players and their scores sorted from the greatest amount of books to
     * least.
     *
     * @return a sorted LinkedHashMap containing the players and scores
     */
    private LinkedHashMap<String, Integer> getSortedLeaderboard() {
        // Create a new HashMap with the values of the players in the game
        HashMap<String, Integer> leaderboard = getPlayerLeaderboard();

        // Create a new LinkedHashMap to store the sorted values in
        LinkedHashMap<String, Integer> sortedLeaderboard
                = new LinkedHashMap<>();

        // Set the values of the sortedLeaderboard to the players and their
        // scores sorted from the greatest amount of books the least.
        sortedLeaderboard = getSortedListOfPlayers(leaderboard,
                                                   sortedLeaderboard);
        // Return the sorted leaderboard
        return sortedLeaderboard;
    }

    /**
     * Gets the next player name in the LinkedHashMap provided.
     *
     * @param sortedLeaderboard the LinkedHashMap to search through
     * @param player            the first player in the LinkedHashMap
     * @return the player of the next entry in the LinkedHashMap
     */
    private String getNextPlayerInLeaderboard(
            LinkedHashMap<String, Integer> sortedLeaderboard,
            Map.Entry<String, Integer> player) {
        // Set the name of the nextPlayer to null
        String nextPlayer = null;
        // Loop through the hashmap entries
        for (Map.Entry<String, Integer> entry : sortedLeaderboard.entrySet()) {
            // If the entry isn't the first entry in the leaderboard hashmap
            if (!entry.getKey().equals(player.getKey())) {
                // Then set the nextPlayer to the key (name) of the current
                // entry
                nextPlayer = entry.getKey();
                // Break from the loop so that we get only the 2nd entry in
                // the HashMap
                break;
            }
        }
        // Return the name of the next player
        return nextPlayer;
    }


    /**
     * This is a recursive function.
     * <p>
     * Returns a sorted LinkedHashMap from the greatest to the least amount of
     * books and the players names associated with the scores.
     *
     * @param players    The unsorted HashMap of players to sort
     * @param sortedList The sorted list to return
     * @return The sorted LinkedHashMap of players and scores
     */
    private static LinkedHashMap<String, Integer> getSortedListOfPlayers(
            HashMap<String, Integer> players,
            LinkedHashMap<String, Integer> sortedList) {
        // Recursive Base Case
        // Runs the recursion until the cardAmounts list is empty.
        while (!players.isEmpty()) {
            // Get the CardValue with the most occurrences
            String maxName = getHighestScoreName(players);
            Integer maxValue = getHighestScoreValue(players);
            // Add the max to the sortedList
            sortedList.put(maxName, maxValue);
            // Remove the max from the cardAmounts list
            players.remove(maxName, maxValue);
            // Recursive call
            getSortedListOfPlayers(players, sortedList);
        }
        // Return the sortedList
        return sortedList;
    }

    /**
     * Returns the highest score value from a HashMap containing names and
     * scores.
     *
     * @param players the HashMap containing names and scores to get the highest
     *                value of.
     * @return The highest score value in the HashMap.
     */
    private static Integer getHighestScoreValue(
            HashMap<String, Integer> players) {
        return Collections.max(players.entrySet(), Map.Entry.comparingByValue())
                          .getValue();
    }

    /**
     * Returns the name of the player with the highest score.
     *
     * @param players the HashMap containing names and scores to get the highest
     *                value of.
     * @return the name of the player with the highest score
     */
    private static String getHighestScoreName(
            HashMap<String, Integer> players) {
        return Collections.max(players.entrySet(), Map.Entry.comparingByValue())
                          .getKey();
    }
}
