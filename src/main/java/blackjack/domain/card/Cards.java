package blackjack.domain.card;

import blackjack.domain.Constants;

import java.util.List;

public class Cards {
    private final List<Card> cards;

    private Cards(List<Card> cards) {
        this.cards = cards;
    }

    public static Cards of(Card... cards) {
        return new Cards(List.of(cards));
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public int calculateTotalValue() {
        int totalValue = calculateOriginalTotalValue();
        long aceCount = getAceCount();

        for (int i = 0; i < aceCount; i++) {
            if (totalValue > Constants.BLACK_JACK_NUMBER) {
                totalValue -= Constants.ACE_VALUE_DIFFERENCE;
            }
        }
        return totalValue;
    }

    private int calculateOriginalTotalValue() {
        return cards.stream()
                .mapToInt(Card::getValueNumber)
                .sum();
    }

    private long getAceCount() {
        return cards.stream()
                .filter(Card::isAce)
                .count();
    }

    public List<Card> getCards() {
        return cards;
    }
}
