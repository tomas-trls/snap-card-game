package org.example;

public class CardGame {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Card newCard = new Card("♥", "K");

        System.out.println(newCard.getValue());
    }
}