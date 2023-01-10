package org.example.app.states;

import org.example.app.Game;

public class CroupierTurnState extends State {
    public CroupierTurnState(Game game) {
        super(game);
    }

    @Override
    public void doAction() {
        if (game.croupier().getScore() < 17) {
            game.changeState(new DealingCardState(game));
        } else {
            game.changeState(new PrintResultState(game));
        }
    }
}
