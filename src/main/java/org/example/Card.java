package org.example;

public class Card {
    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
        setValue(this.symbol);
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

    public void setValue(String symbol) {
        if(symbol == "J"){
            this.value = 11;
        } else if (symbol == "Q"){
            this.value = 12;
        } else if (symbol == "K"){
            this.value = 13;
        } else if (symbol == "A"){
            this.value = 14;
        } else {
            this.value = Integer.parseInt(symbol);
        }
    }



    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }
}
