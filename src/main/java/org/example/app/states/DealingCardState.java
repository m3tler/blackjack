package org.example.app.states;

import org.example.app.Game;
import org.example.models.cards.CardStatus;

public class DealingCardState extends State {
    public DealingCardState(Game game) {
        super(game);
    }

    @Override
    public void doAction() {
        if (game.getPreviousState() instanceof PlayerTurnState) {
            game.croupier().dealCardTo(game.player(), CardStatus.FACE_UP);
            game.display().printTable(game.player(), game.croupier());
            game.changeState(new PlayerTurnState(game));
        } else {
            game.croupier().dealCardTo(game.croupier(), CardStatus.FACE_UP);
            game.display().printTable(game.player(), game.croupier());
            game.display().acknowledge();
            game.changeState(new CroupierTurnState(game));
        }
    }
}
