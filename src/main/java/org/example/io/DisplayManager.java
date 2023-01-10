package org.example.io;

import org.apache.commons.lang.StringUtils;
import org.example.models.players.Croupier;
import org.example.models.game.GameResult;
import org.example.models.players.Player;
import org.example.models.players.PlayerDecision;
import org.example.models.cards.Card;

import java.util.Set;
import java.util.stream.Collectors;


public class DisplayManager {
    private static final int PAGE_WIDTH = 120;
    private static final String CURSOR = " => ";
    private String topPageFrame;
    private String bottomPageFrame;

    private final IOManager ioManager;
    private final AssetManager assetManager;

    public DisplayManager(IOManager ioManager, AssetManager assetManager) {
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
        printPage(Subtitle.GREETINGS);
    }

    public String askAboutName() {
        ioManager.printLine(topPageFrame);
        ioManager.printLine(center(Subtitle.NAME_QUESTION));
        ioManager.print(CURSOR);
        String name = ioManager.getLine();
        ioManager.printLine(center(Subtitle.THANKS + name + "! " + Subtitle.PLAY_ROUND));
        ioManager.printLine(bottomPageFrame);
        return name;
    }

    public void printTable(Player player, Croupier croupier) {
        String playerTable = player.getName() + " (" + player.getScore() + ")" + System.lineSeparator() + printCards(player.getHand());
        playerTable = playerTable.lines()
                .map(line -> StringUtils.rightPad(line, PAGE_WIDTH / 2 - 2) + System.lineSeparator())
                .collect(Collectors.joining());

        String croupierTable = croupier.getName() + " (" + croupier.getScore() + ")" + System.lineSeparator() + printCards(croupier.getHand());
        croupierTable = croupierTable.lines()
                .map(line -> StringUtils.leftPad(line, PAGE_WIDTH / 2 - 2) + System.lineSeparator())
                .collect(Collectors.joining());

        String table = mergeLines(playerTable, croupierTable);
        printPage(table);
    }

    private String printCards(Set<Card> cards) {
        String str = "";
        for (Card card : cards) {
            str = mergeLines(str, printCard(card));
        }
        return str;
    }

    private String mergeLines(String s1, String s2) {
        String[] l1 = s1.split(System.lineSeparator());
        String[] l2 = s2.split(System.lineSeparator());
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < l1.length || j < l2.length) {
            if (i < l1.length)
                sb.append(l1[i++]);
            if (j < l2.length)
                sb.append(l2[j++]);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private void printPage(String content) {
        ioManager.printLine(topPageFrame);
        content.lines().forEach(line -> ioManager.printLine(StringUtils.center(line, PAGE_WIDTH)));
        ioManager.printLine(bottomPageFrame);
    }

    private String center(String str) {
        return StringUtils.center(str, PAGE_WIDTH);
    }

    private String printCard(Card card) {
        if (!card.isFaceUp()) {
            return printReversedCard();
        }

        String cardAsset = assetManager.getAsset("card.txt");
        String[] lines = cardAsset.split(System.lineSeparator());
        StringBuilder cardSb = new StringBuilder();
        int signSize = card.getValue().getSign().length();

        for (int i = 0; i < lines.length; i++) {
            StringBuilder lineSb = new StringBuilder(lines[i]);
            if (i == 1) {
                lineSb.replace(2, 2 + signSize, card.getValue().getSign());
            } else if (i == 3) {
                lineSb.replace(5, 6, card.getSuit().getSign());
            } else if (i == 5) {
                lineSb.replace(9 - signSize, 9, card.getValue().getSign());
            }
            cardSb.append(lineSb).append(System.lineSeparator());
        }
        return cardSb.toString();
    }

    private String printReversedCard() {
        return assetManager.getAsset("reversed_card.txt");
    }

    public PlayerDecision askAboutChoice() {
        String choice;
        do {
            ioManager.printLine(topPageFrame);
            ioManager.printLine(center(Subtitle.CHOICE_QUESTION));
            ioManager.print(CURSOR);
            choice = ioManager.getLine();
            if (!(choice.equals("h") || choice.equals("s"))) {
                ioManager.printLine(center(Subtitle.ERROR_CHOICE));
            }
            ioManager.printLine(bottomPageFrame);
        } while (!(choice.equals("h") || choice.equals("s")));
        return PlayerDecision.getDecision(choice).get();
    }

    public void acknowledge() {
        ioManager.printLine(topPageFrame);
        ioManager.printLine(center(Subtitle.PRESS_ENTER_TO_CONTINUE));
        ioManager.pressEnter();
        ioManager.printLine(bottomPageFrame);
    }

    public void printGameResult(GameResult gameResult) {
        printPage(gameResult.getMessage());
    }
}
