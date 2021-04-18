package com.example.java.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameApplication {
    private static final int randomNumber = (new Random()).nextInt(100);

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players:");
        int numberOfPlayers = scanner.nextInt();
        List<String> listOfPlayers = new ArrayList<>();

        for (int playerIndex = 1; playerIndex <= numberOfPlayers; playerIndex++) {
            System.out.println("Add player " + playerIndex + " name:");
            listOfPlayers.add(scanner.next());
        }

        int playerTurn = 0;
        while (true) {
            String playerName = listOfPlayers.get(playerTurn);
            System.out.println("Player " + playerName + " turn:");
            System.out.println("Guess a number between 1 to 100");
            int guessedNumber = scanner.nextInt();
            if (guessedNumber == randomNumber) {
                System.out.println("Congratulation " + playerName + " you won the game");
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
