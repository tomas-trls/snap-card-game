package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Snap extends CardGame {

    public static int cardIndex = 0;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a valid option:");
        System.out.println("1: Play | 2: Exit");
        String option = scanner.nextLine();
        if (option.equals("1")) {

            System.out.println("Please enter Player 1 username");
            String playerOneName = scanner.nextLine();
            Player playerOne = new Player(playerOneName);
            System.out.println("Player 1 Name");
            System.out.println(playerOne.getName());

            System.out.println("Please enter Player 2 username");
            String playerTwoName = scanner.nextLine();
            Player playerTwo = new Player(playerTwoName);
            System.out.println("Player 2 Name");
            System.out.println(playerTwo.getName());

            System.out.println("Creating a new Game.");
            System.out.println("Getting a deck...");
            playGame(playerOne, playerTwo);
        } else if (option.equals("2")) {
            quitGame();
        } else {
            menu();
        }
    }

    public static void playGame(Player playerOne, Player playerTwo) {
        shuffleDeck();
        while (cardIndex < getDeck().size()) {
            System.out.println("Press enter to get to a new card");

            if (cardIndex % 2 == 0) {
                snapRun(playerOne, playerOne, playerTwo);
            } else {
                snapRun(playerTwo, playerOne, playerTwo);
            }
        }
    }


    public static void snapRun(Player player, Player playerOne, Player playerTwo){
        Scanner scanner = new Scanner(System.in);
        String enter = scanner.nextLine();
        if (enter.equals("")) {
            System.out.println(player.getName());
            System.out.println(dealCard(cardIndex));

            if (cardIndex > 0 && dealCard(cardIndex - 1).getSymbol().equals(dealCard(cardIndex).getSymbol())) {
                System.out.printf("\n🎉 You Win %s !!! 🥳", player.getName());
                replay(playerOne, playerTwo);
            } else {
                cardIndex++;
                if (cardIndex == getDeck().size()) {
                    System.out.println("😫 Unlucky, no Snap occurred in this game! 😳");
                    replay(playerOne, playerTwo);
                }
            }
        } else {
            System.out.println("❌ Please only press enter! 😣");
        }
    }


    public static void quitGame() {
        System.out.println("👋 Quitting Game! 👋");
    }

    public static void replay(Player playerOne, Player playerTwo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to replay? \nY/n?");
        String replay = scanner.nextLine();

        if (replay.toLowerCase().contains("n") && replay.length() < 8) {
            menu();
        } else if (replay.toLowerCase().contains("y") && replay.length() < 8) {
            playGame(playerOne, playerTwo);
        } else {
            System.out.println("Please select a valid option!");
            replay(playerOne, playerTwo);
        }
    }

}
