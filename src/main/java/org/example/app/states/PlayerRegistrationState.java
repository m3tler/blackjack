package org.example.app.states;

import org.example.app.Game;
import org.example.models.players.Player;

public class PlayerRegistrationState extends State {
    public PlayerRegistrationState(Game game) {
        super(game);
    }

    @Override
    public void doAction() {
        String name = game.display().askAboutName();
        Player player = game.player();
        player.setName(name);

        game.croupier().registerPlayer(player);

        game.changeState(new DealingCardsState(game));
    }
}
