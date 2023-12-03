package blackjack.domain.card;

import java.util.Arrays;

import static blackjack.exception.ErrorMessage.INVALID_CARD_SHAPE;

public enum Shape {
    DIAMONDS("다이아몬드"), HEARTS("하트"), CLUBS("클로버"), SPADES("스페이드");

    private final String shapeValue;

    Shape(String shapeValue) {
        this.shapeValue = shapeValue;
    }

    public static Shape getShape(String name) {
        return Arrays.stream(Shape.values())
                .filter(value -> value.getShapeValue().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CARD_SHAPE.getMessage()));
    }

    public String getShapeValue() {
        return shapeValue;
    }
}
