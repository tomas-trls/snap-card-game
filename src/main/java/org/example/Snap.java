package org.example;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    private final Scanner scanner = new Scanner(System.in);
    public int cardIndex = 0;


    public void menu() {
        System.out.println("Please select a valid option:");
        System.out.println("1: Play | 2: Exit");
        String option = scanner.nextLine();
        if (option.equals("1")) {

            System.out.println("Please enter Player 1 username:");
            String playerOneName = scanner.nextLine();
            Player playerOne = new Player(playerOneName);
            System.out.println("Player 1: " + playerOne.getName());

            System.out.println("Please enter Player 2 username:");
            String playerTwoName = scanner.nextLine();
            Player playerTwo = new Player(playerTwoName);
            System.out.println("Player 2: " + playerTwo.getName());

            System.out.println("Creating a new Game.");
            System.out.println("Getting a deck...");
            playGame(playerOne, playerTwo);
        } else if (option.equals("2")) {
            quitGame();
        } else {
            menu();
        }
    }

    public void playGame(Player playerOne, Player playerTwo) {
        shuffleDeck();
        cardIndex = 0;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if (cardIndex < getDeck().size()) {
                    if (cardIndex % 2 == 0) {
                        snapRun(timer, playerOne, playerOne, playerTwo);
                    } else {
                        snapRun(timer, playerTwo, playerOne, playerTwo);
                    }
                    cardIndex++;
                    if (cardIndex == getDeck().size()) {
                        System.out.println("😫 Unlucky, no Snap occurred in this game! 😳");
                        timer.cancel();
                        replay(playerOne, playerTwo);
                    }
                } else {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 2000);
    }

    public void snapRun(Timer GameTimer, Player currPlayer, Player playerOne, Player playerTwo) {
        System.out.println("\n" + currPlayer.getName());
        System.out.println(dealCard(cardIndex));

        if (cardIndex > 0 && dealCard(cardIndex - 1).getSymbol().equals(dealCard(cardIndex).getSymbol())) {

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    String input = "";
                    try {
                        if (scanner.hasNextLine()) {
                            input = scanner.nextLine();
                        } else {
                            input = "";
                        }
                        if (input.equalsIgnoreCase("snap")) {
                            System.out.printf("\n🎉 You Win %s !!! 🥳", currPlayer.getName());
                            System.out.println("\nHit 'Enter' to continue..");
                            String enter = scanner.nextLine();
                            if(enter.equals("")){
                                timer.cancel();
                                GameTimer.cancel();
                                replay(playerOne, playerTwo);
                            } else {
                                System.out.println("\nPlease hit 'ENTER' to continue..");
                            }
                        } else {
                            System.out.printf("You loose %s", currPlayer.getName());
                            System.out.println("\nHit 'Enter' to continue..");
                            String enter = scanner.nextLine();
                            if(enter.equals("")){
                                timer.cancel();
                                GameTimer.cancel();
                                replay(playerOne, playerTwo);
                            } else {
                                System.out.println("\nPlease hit 'ENTER' to continue..");
                            }
                        }
                    } catch (Exception e) {
                        // handle the exception
                        System.out.println("Time's up! \n Hit 'ENTER' to continue..");
                        String enter = scanner.nextLine();
                        if(enter.equals("")){
                            timer.cancel();
                            replay(playerOne, playerTwo);
                        } else {
                            System.out.println("\nPlease hit 'ENTER' to continue..");
                        }
                    }
                }
            };
            timer.scheduleAtFixedRate(task,0,2000);

        }

    }

    public void quitGame() {
        cardIndex = 52;
        System.out.println("👋 Quitting Game! 👋");
    }

    public void replay(Player playerOne, Player playerTwo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWould you like to replay? \nY/n?");
        String replay = scanner.nextLine();

        if (replay.equalsIgnoreCase("n")) {
            menu();
        } else if (replay.equalsIgnoreCase("y")) {
            playGame(playerOne, playerTwo);
        } else {
            System.out.println("Please select a valid option!");
            replay(playerOne, playerTwo);
        }
    }
}
