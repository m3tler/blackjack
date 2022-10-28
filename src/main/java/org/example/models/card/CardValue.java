package org.example.models.card;

public enum CardValue {
    ACE("Ace", "A"),
    KING("King", "K"),
    QUEEN("Queen", "Q"),
    JACK("Jack", "J"),
    TEN("Ten", "10"),
    NINE("Nine", "9"),
    EIGHT("Eight", "8"),
    SEVEN("Seven", "7"),
    SIX("Six", "6"),
    FIVE("Five", "5"),
    FOUR("Four", "4"),
    THREE("Three", "3"),
    TWO("Two", "2");

    private final String description;
    private final String sign;

    CardValue(String description, String sign) {
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
