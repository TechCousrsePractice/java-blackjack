package blackjack.domain.player;

import blackjack.domain.card.Cards;

public class Player {
    private final String name;
    private final int bettingAmount;
    private Cards cards;

    private Player(String name, int bettingAmount) {
        this.name = name;
        this.bettingAmount = bettingAmount;
    }

    public static Player from(String name, int bettingAmount) {
        return new Player(name, bettingAmount);
    }
}
