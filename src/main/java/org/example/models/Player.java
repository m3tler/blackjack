package org.example.models;

import org.example.models.card.Card;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private Set<Card> hand = new HashSet<>();

    public Set<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void removeCardsFromHand() {
        hand.clear();
    }
}
