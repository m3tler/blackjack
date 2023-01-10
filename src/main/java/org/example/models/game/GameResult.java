package org.example.models.game;

public enum GameResult {
    WIN("CONGRATULATIONS! YOU WIN!"),
    TIE("TIE! NOBODY WINS!"),
    LOSE("YOU'VE BUSTED! GAME OVER!");

    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
