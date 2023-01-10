package org.example.app;

import org.example.app.states.ExitState;
import org.example.app.states.InitializationState;
import org.example.app.states.State;
import org.example.io.AssetManager;
import org.example.io.DisplayManager;
import org.example.io.IOManager;
import org.example.models.players.Croupier;
import org.example.models.players.Player;

import java.util.Scanner;

public class Game {
    private final DisplayManager display;
    private final Croupier croupier;
    private final Player player;
    private State state;
    private State prevState;

    public Game() {
        Scanner scanner = new Scanner(System.in);
        IOManager ioManager = new IOManager(scanner);
        AssetManager assetManager = new AssetManager(ioManager);

        this.state = new InitializationState(this);
        this.display = new DisplayManager(ioManager, assetManager);
        this.croupier = new Croupier();
        this.player = new Player();
    }

    public DisplayManager display() {
        return display;
    }

    public Croupier croupier() {
        return croupier;
    }

    public Player player() {
        return player;
    }

    public State getPreviousState() {
        return this.prevState;
    }

    public void changeState(State state) {
        this.prevState = this.state;
        this.state = state;
    }

    public void run() {
        while (!(state instanceof ExitState)) {
            state.doAction();
        }
    }
}
