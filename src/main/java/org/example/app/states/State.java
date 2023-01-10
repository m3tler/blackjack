package org.example.app.states;

import org.example.app.Game;

public abstract class State {
    protected final Game game;

    protected State(Game game) {
        this.game = game;
    }

    public abstract void doAction();
}
