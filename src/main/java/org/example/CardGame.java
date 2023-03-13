package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import static  org.example.CardGameUtils.*;

public class CardGame {
    private String name;
    private static final ArrayList<Card> deckOfCard = generateDeck();

    public static ArrayList<Card> getDeck(){
        return deckOfCard;
    }

    public static Card dealCard(int card){
        return deckOfCard.get(card);
    }

    public static ArrayList<Card> sortDeckInNumberOrder() {
         return (ArrayList<Card>) deckOfCard.stream().sorted(Comparator.comparing(Card::getValue)).collect(Collectors.toList());
    }

    public static ArrayList<Card> sortDeckIntoSuits() {
        return (ArrayList<Card>) deckOfCard.stream().sorted(Comparator.comparing((Card::getSuit))).collect(Collectors.toList());
    }

    public static void shuffleDeck() {
        System.out.println("Shuffling....");
        Collections.shuffle(deckOfCard);
    }
}