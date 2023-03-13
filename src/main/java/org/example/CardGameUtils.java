package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGameUtils {

    private static String[] suitsArr = {"♥","♦","♠","♣"};

    private static String[] symbolArr = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public static ArrayList<Card> generateDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (int i = 0; i < suitsArr.length; i++) {
            for (int j = 0; j < symbolArr.length; j++) {
                deck.add(new Card(suitsArr[i], symbolArr[j]));
            }
        }
        return deck;
    }
}
