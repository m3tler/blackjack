package org.example.models;

import org.example.models.card.Card;
import org.example.models.card.CardSuit;
import org.example.models.card.CardValue;

import java.util.Collections;
import java.util.Set;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cards = new Stack<>();

    public Deck() {
        createDeck();
    }

    private void createDeck() {
        for(CardSuit suit : CardSuit.values()) {
            for(CardValue value : CardValue.values()) {
                this.cards.add(new Card(value, suit));
            }
        }
    }

    public Card getCard() {
        return this.cards.pop();
    }

    public void addCards(Set<Card> cards) {
        this.cards.addAll(cards);
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    @Override
    public String toString() {
        return "Deck{" + "cards=" + this.cards + '}';
    }
}
