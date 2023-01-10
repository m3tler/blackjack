package org.example.app.states;

import org.example.app.Game;
import org.example.models.players.PlayerDecision;

public class PlayerTurnState extends State {
    public PlayerTurnState(Game game) {
        super(game);
    }

    @Override
    public void doAction() {
        PlayerDecision decision = game.display().askAboutChoice();
        if (decision == PlayerDecision.HIT) {
            game.changeState(new DealingCardState(game));
        } else {
            game.changeState(new FacingUpCroupierCardsState(game));
        }
    }
}
