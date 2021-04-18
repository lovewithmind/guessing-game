package com.example.java.game;

import java.util.*;

public class GameApplication {
    private static final int randomNumber = (new Random()).nextInt(100);

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players:");
        int numberOfPlayers = scanner.nextInt();
        List<Map<String, String>> listOfPlayers = new ArrayList<>();

        for (int playerIndex = 1; playerIndex <= numberOfPlayers; playerIndex++) {
            System.out.println("Add player " + playerIndex + " name and age:");
            Map<String, String> player = new HashMap<>();
            System.out.println("Name: ");
            player.put("name", scanner.next());
            System.out.println("Age: ");
            player.put("age", scanner.next());
            listOfPlayers.add(player);
        }

        int playerTurn = 0;
        while (true) {
            Map<String, String> player = listOfPlayers.get(playerTurn);
            System.out.println("Player " + player.get("name") + " turn:");
            System.out.println("Guess a number between 1 to 100");
            int guessedNumber = scanner.nextInt();
            if (guessedNumber == randomNumber) {
                System.out.println("Congratulation " + player.get("name") + " " + player.get("age") + " you won the game");
                break;
            } else if (guessedNumber < randomNumber) {
                System.out.println("Guessed number is less than the random number");
            } else {
                System.out.println("Guessed number is more than the random number");
            }

            playerTurn++;
            playerTurn %= numberOfPlayers;
        }
    }
}
