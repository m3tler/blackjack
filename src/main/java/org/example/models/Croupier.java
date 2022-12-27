package org.example.models;

import org.example.models.card.Card;

public class Croupier extends Player {
    private final Deck deck;
    private Player player;

    public Croupier() {
        this.deck = new Deck();
    }

    public void registerPlayer(Player player) {
        this.player = player;
    }

    public void shuffleCards() {
        deck.shuffle();
    }

    public void dealCards() {
        dealCardTo(player);
        dealCardTo(this);
        dealCardTo(player);
        dealCardTo(this);
    }

    private void dealCardTo(Player player) {
        Card card = deck.getCard();
        player.addCardToHand(card);
    }

    public void collectCards() {
        collectCardsFrom(player);
        collectCardsFrom(this);
    }

    private void collectCardsFrom(Player player) {
        deck.addCards(player.getHand());
        player.removeCardsFromHand();
    }
}
