package org.example.models.cards;

public class Card {
    private final CardValue value;
    private final CardSuit suit;
    private CardStatus status;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
        this.status = CardStatus.FACE_UP;
    }

    public CardValue getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return status == CardStatus.FACE_UP;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return value + " of " + suit + "s";
    }
}
