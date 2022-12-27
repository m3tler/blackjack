package org.example.app;

import org.example.io.AssetManager;
import org.example.io.IOManager;
import org.example.io.UIManager;
import org.example.models.card.Card;
import org.example.models.card.CardSuit;
import org.example.models.card.CardValue;

import java.util.Scanner;

public class ApplicationManager {
    private final UIManager uiManager;

    public ApplicationManager() {
        Scanner scanner = new Scanner(System.in);
        IOManager ioManager = new IOManager(scanner);
        AssetManager assetManager = new AssetManager(ioManager);
        this.uiManager = new UIManager(ioManager, assetManager);
    }

    public void run() {
//        uiManager.printInitialPage();
//        String name = uiManager.askAboutName();

        Card card = new Card(CardValue.ACE, CardSuit.SPADE);
        System.out.print(uiManager.printCard(card));
        System.out.print(uiManager.printReversedCard());
    }
}
