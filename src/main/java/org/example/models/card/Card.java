package org.example.models.card;

public record Card(CardValue cardValue, CardSuit cardSuit) {
    @Override
    public String toString() {
        return cardValue + " of " + cardSuit + "s";
    }
}
