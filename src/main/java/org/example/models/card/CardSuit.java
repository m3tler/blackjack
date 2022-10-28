package org.example.models.card;

public enum CardSuit {
    SPADE("Spade", "♠"),
    HEARTH("Hearth", "♥"),
    CLUB("Club", "♣"),
    DIAMOND("Diamond", "♦");

    private final String description;
    private final String sign;

    CardSuit(String description, String sign) {
        this.description = description;
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return description;
    }
}
