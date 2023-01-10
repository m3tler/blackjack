package org.example.app.states;

import org.example.app.Game;
import org.example.models.cards.CardStatus;

public class FacingUpCroupierCardsState extends State {
    public FacingUpCroupierCardsState(Game game) {
        super(game);
    }

    @Override
    public void doAction() {
        game.croupier().getHand().forEach(card -> card.setStatus(CardStatus.FACE_UP));
        game.display().printTable(game.player(), game.croupier());
        game.display().acknowledge();
        game.changeState(new CroupierTurnState(game));
    }
}
