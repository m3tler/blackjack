package org.example.app.states;

import org.example.app.Game;

public class InitializationState extends State {
    public InitializationState(Game game) {
        super(game);
    }

    @Override
    public void doAction() {
        game.display().printInitialPage();
        game.changeState(new PlayerRegistrationState(game));
    }
}
