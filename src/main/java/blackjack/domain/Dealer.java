package blackjack.domain;

import blackjack.domain.card.Cards;

public class Dealer {
    private Cards cards;

    private Dealer(Cards cards) {
        this.cards = cards;
    }

    public static Dealer from(Cards cards) {
        return new Dealer(cards);
    }

    public Cards getCards() {
        return cards;
    }
}
