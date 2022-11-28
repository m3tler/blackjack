package org.example.ui;

import org.example.io.IOManager;
import org.example.models.card.Card;
import org.example.models.card.CardValue;

import java.util.Optional;

public class UIManager {
    private static final String CARD_ASSET_PATH = "src\\main\\resources\\card.txt";
    private final IOManager ioManager;

    public UIManager(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void printCard(Card card) {
        if (card.getCardValue() == CardValue.TEN) {
            ioManager.tryReadFile(CARD_ASSET_PATH);
        }
    }

    public void printReversedCard() {
        Optional<String> cardAsset = ioManager.tryReadFile(CARD_ASSET_PATH);
    }
}
