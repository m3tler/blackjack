package org.example.models.card;

public class Card {
    private final CardValue cardValue;
    private final CardSuit cardSuit;

    public Card(CardValue cardValue, CardSuit cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    @Override
    public String toString() {
        return cardValue + " of " + cardSuit + "s";
    }
}
