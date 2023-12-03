package blackjack.domain.card;

import java.util.Arrays;

import static blackjack.exception.ErrorMessage.INVALID_CARD_SHAPE;

public enum Value {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private final String valueName;

    Value(String valueName) {
        this.valueName = valueName;
    }

    public static Value getValue(String name) {
        return Arrays.stream(Value.values())
                .filter(value -> value.getValueName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CARD_SHAPE.getMessage()));
    }

    public String getValueName() {
        return valueName;
    }
}
