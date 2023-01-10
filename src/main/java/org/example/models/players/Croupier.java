package org.example.models.players;

import org.example.models.cards.Card;
import org.example.models.cards.CardStatus;
import org.example.models.cards.Deck;

public class Croupier extends Player {
    private static final String NAME = "Croupier";
    private final Deck deck;
    private Player player;

    public Croupier() {
        this.deck = new Deck();
    }

    @Override
    public String getName() {
        return NAME;
    }

    public void registerPlayer(Player player) {
        this.player = player;
    }

    public void shuffleCards() {
        deck.shuffle();
    }

    public void dealCards() {
        dealCardTo(player, CardStatus.FACE_UP);
        dealCardTo(this, CardStatus.FACE_UP);
        dealCardTo(player, CardStatus.FACE_UP);
        dealCardTo(this, CardStatus.FACE_DOWN);
    }

    public void dealCardTo(Player player, CardStatus status) {
        Card card = deck.getCard();
        card.setStatus(status);
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
