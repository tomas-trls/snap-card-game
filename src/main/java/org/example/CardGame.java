package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import static  org.example.CardGameUtils.*;

public class CardGame {
    public static void main(String[] args) {
    }

    private String name;
    private static final ArrayList<Card> deckOfCard = generateDeck();

    static ArrayList<Card> getDeck(){
        return deckOfCard;
    }

    static Card dealCard(){
        return deckOfCard.get(0);
    }


    static ArrayList<Card> sortDeckInNumberOrder() {
         return (ArrayList<Card>) deckOfCard.stream().sorted(Comparator.comparing(Card::getValue)).collect(Collectors.toList());
    }

    static ArrayList<Card> sortDeckIntoSuits() {
        return (ArrayList<Card>) deckOfCard.stream().sorted(Comparator.comparing((Card::getSuit))).collect(Collectors.toList());
    }

    static void shuffleDeck() {
        System.out.println("Shuffling....");
        Collections.shuffle(deckOfCard);
    }
}