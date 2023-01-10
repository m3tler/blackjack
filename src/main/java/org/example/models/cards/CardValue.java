package org.example.models.cards;

public enum CardValue {
    ACE("Ace", "A", 11),
    KING("King", "K", 10),
    QUEEN("Queen", "Q", 10),
    JACK("Jack", "J", 10),
    TEN("Ten", "10", 10),
    NINE("Nine", "9", 9),
    EIGHT("Eight", "8", 8),
    SEVEN("Seven", "7", 7),
    SIX("Six", "6", 6),
    FIVE("Five", "5", 5),
    FOUR("Four", "4", 4),
    THREE("Three", "3", 3),
    TWO("Two", "2", 2);

    private final String description;
    private final String sign;
    private final int value;

    CardValue(String description, String sign, int value) {
        this.description = description;
        this.sign = sign;
        this.value = value;
    }

    public String getSign() {
        return sign;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return description;
    }
}
