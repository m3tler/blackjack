package org.example.io;

public enum Subtitle {
    GREETINGS("Welcome to the Blackjack table!" + System.lineSeparator() + "Lets play a game of Blackjack, shall we?"),
    START("Press enter to continue"),
    NAME_QUESTION("Please enter your name"), THANKS("Thank you, ");

    private String content;

    Subtitle(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
