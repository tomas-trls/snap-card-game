package org.example;

public class Card {
    private String suit;
    private String symbol;
    private final int value;

    public Card(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = setValue(this.symbol);
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public int setValue(String symbol) {
        switch (symbol) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(symbol);
        }
    }


    @Override
    public String toString() {
        return symbol+" of "+ suit;
    }
}
