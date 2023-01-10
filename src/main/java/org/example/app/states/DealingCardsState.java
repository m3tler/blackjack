package org.example.app.states;

import org.example.app.Game;

public class DealingCardsState extends State {
    public DealingCardsState(Game game) {
        super(game);
    }

    @Override
    public void doAction() {
        game.croupier().shuffleCards();
        game.croupier().dealCards();
        game.display().printTable(game.player(), game.croupier());

        if (game.player().getScore() < 21) {
            game.changeState(new PlayerTurnState(game));
        } else if (game.player().getScore() == 21) {
            game.changeState(new FacingUpCroupierCardsState(game));
        } else {
            game.changeState(new PrintResultState(game));
        }
    }
}
