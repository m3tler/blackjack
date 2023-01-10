package org.example.models.players;

import java.util.Optional;

public enum PlayerDecision {
    HIT, STAY;

    public static Optional<PlayerDecision> getDecision(String decision) {
        if (decision.equals("h")) return Optional.of(PlayerDecision.HIT);
        if (decision.equals("s")) return Optional.of(PlayerDecision.STAY);
        return Optional.empty();
    }
}
