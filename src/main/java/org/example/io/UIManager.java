package org.example.io;

import org.apache.commons.lang.StringUtils;
import org.example.models.card.Card;
import org.example.models.card.CardValue;

import java.util.Set;


public class UIManager {
    private static final int PAGE_WIDTH = 120;
    private String topPageFrame;
    private String bottomPageFrame;

    private final IOManager ioManager;
    private final AssetManager assetManager;

    public UIManager(IOManager ioManager, AssetManager assetManager) {
        this.ioManager = ioManager;
        this.assetManager = assetManager;

        loadAssets();
    }

    private void loadAssets() {
        String pageFrameAsset = assetManager.getAsset("page_frame.txt");
        String[] frames = pageFrameAsset.split(System.lineSeparator());
        topPageFrame = frames[0];
        bottomPageFrame = frames[1];
    }

    public void printInitialPage() {
        printPage(assetManager.getAsset("banner.txt"));
        printPage(Subtitle.GREETINGS.toString());
    }

    public String askAboutName() {
        return getInput(Subtitle.NAME_QUESTION.toString());
    }

    public void printTable(Set<Card> playerCards, Set<Card> croupierCards) {
        printPage("");
    }

    private void printPage(String content) {
        ioManager.printLine(topPageFrame);
        content.lines().forEach(line -> ioManager.printLine(StringUtils.center(line, PAGE_WIDTH)));
        ioManager.printLine(bottomPageFrame);
    }

    private String getInput(String content) {
        ioManager.printLine(topPageFrame);
        content.lines().forEach(line -> ioManager.printLine(center(line)));
        ioManager.print(" => ");
        String input = ioManager.getLine();
        ioManager.printLine(center(Subtitle.THANKS + input + "!"));
        ioManager.printLine(bottomPageFrame);
        return input;
    }

    private String center(String str) {
        return StringUtils.center(str, PAGE_WIDTH);
    }

    public String printCard(Card card) {
        String cardAsset = assetManager.getAsset("card.txt");
        String[] lines = cardAsset.split(System.lineSeparator());
        StringBuilder cardSb = new StringBuilder();
        int signSize = card.cardValue().getSign().length();

        for (int i = 0; i < lines.length; i++) {
            StringBuilder lineSb = new StringBuilder(lines[i]);
            if (i == 1) {
                lineSb.replace(2,2 + signSize, card.cardValue().getSign());
            } else if (i == 3) {
                lineSb.replace(5,6, card.cardSuit().getSign());
            } else if (i == 5) {
                lineSb.replace(9 - signSize,9, card.cardValue().getSign());
            }
            cardSb.append(lineSb).append(System.lineSeparator());
        }
        return cardSb.toString();
    }

    public String printReversedCard() {
        return assetManager.getAsset("reversed_card.txt");
    }
}
