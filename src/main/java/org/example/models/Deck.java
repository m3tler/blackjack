package org.example.models;

import org.example.models.card.Card;
import org.example.models.card.CardSuit;
import org.example.models.card.CardValue;

import java.util.Collections;
import java.util.Optional;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cards = new Stack<>();

    public Deck() {
        createDeck();
    }

    public Deck(int numberOfDecks) {
        for(int i = 1; i <= numberOfDecks; i++) {
            createDeck();
        }
    }

    private void createDeck() {
        for(CardSuit suit : CardSuit.values()) {
            for(CardValue value : CardValue.values()) {
                this.cards.add(new Card(value, suit));
            }
        }
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public Optional<Card> getCard() {
        if(cards.empty()) return Optional.empty();
        return Optional.of(cards.pop());
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
