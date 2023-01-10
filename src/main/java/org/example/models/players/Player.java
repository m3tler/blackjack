package org.example.models.players;

import org.example.models.cards.Card;
import org.example.models.cards.CardValue;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private final Set<Card> hand = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void removeCardsFromHand() {
        hand.clear();
    }

    public int getScore() {
        Set<Card> faceUpCards = hand.stream().filter(Card::isFaceUp).collect(Collectors.toSet());
        int aceNumber = (int) faceUpCards.stream().filter(card -> card.getValue() == CardValue.ACE).count();
        int score = faceUpCards.stream().mapToInt(card -> card.getValue().getValue()).sum();
        for (int i = 1; i <= aceNumber; i++) {
            if (score <= 21) break;
            else score -= 10 * i;
        }
        return score;
    }
}
