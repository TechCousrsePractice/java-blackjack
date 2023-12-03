package blackjack.domain.player;

import blackjack.domain.Constants;
import blackjack.domain.card.Card;
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

    public void initializeCards(Cards cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean isBlackJack() {
        return cards.calculateTotalValue() == Constants.BLACK_JACK_NUMBER;
    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }
}
