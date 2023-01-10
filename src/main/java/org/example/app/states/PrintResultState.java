package org.example.app.states;

import org.example.app.Game;
import org.example.models.game.GameResult;

public class PrintResultState extends State {
    public PrintResultState(Game game) {
        super(game);
    }

    @Override
    public void doAction() {
        GameResult result;
        if (game.player().getScore() > 21) {
            result = GameResult.LOSE;
        } else if (game.croupier().getScore() > 21) {
            result = GameResult.WIN;
        } else if (game.player().getScore() < game.croupier().getScore()) {
            result = GameResult.LOSE;
        } else if (game.player().getScore() == game.croupier().getScore()) {
            result = GameResult.TIE;
        } else {
            result = GameResult.WIN;
        }
        game.display().printGameResult(result);

        game.changeState(new ExitState(game));
    }
}
