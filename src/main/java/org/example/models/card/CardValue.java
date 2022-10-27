package org.example.models.card;

public enum CardValue {
    ACE("Ace", "A"),
    TWO("Two", "2"),
    THREE("Three", "3"),
    FOUR("Four", "4"),
    FIVE("Five", "5"),
    SIX("Six", "6"),
    SEVEN("Seven", "7"),
    EIGHT("Eight", "8"),
    NINE("Nine", "9"),
    TEN("Ten", "10"),
    JACK("Jack", "J"),
    QUEEN("Queen", "Q"),
    KING("King", "K");

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
