package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Snap extends CardGame{


    public static int cardIndex = 0;
    public static void main(String[] args) {

        System.out.println("Creating a new Game.");
        System.out.println("Getting a deck...");
        shuffleDeck();

        while(cardIndex < getDeck().size()) {
            System.out.println("Press enter to get to a new card");
            Scanner scanner = new Scanner(System.in);
            String enter = scanner.nextLine();

            if (enter.equals("")){
                System.out.println(dealCard(cardIndex));
              if(cardIndex > 0 && dealCard(cardIndex - 1).getSymbol().equals(dealCard(cardIndex).getSymbol())){
                    System.out.println("🎉 You Win!!! 🥳");
                    break;
                } else {
                    cardIndex++;
                }
            } else {
                System.out.println("❌ Please only press enter! 😣");
            }
        }

    }


    void winGame(){

    }
}
