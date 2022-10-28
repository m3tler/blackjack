package org.example;

import org.example.app.ApplicationManager;
import org.example.models.Deck;

public class BlackjackApplication {
    public static void main(String[] args) {
        ApplicationManager applicationManager = new ApplicationManager();
        applicationManager.run();

        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck);
    }
}
