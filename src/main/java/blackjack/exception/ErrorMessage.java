package blackjack.exception;

public enum ErrorMessage {
    ERROR_CAPTION("[ERROR] "),
    NOT_NUMERIC_INPUT("숫자를 입력해 주세요."),
    NOT_POSITIVE_INPUT("양수를 입력해 주세요."),
    INVALID_PLAYER_NAME("이름 형식이 유효하지 않습니다."),
    INVALID_CARD_SHAPE("유효하지 않은 카드 심볼 입니다."),
    OUT_OF_INDEX_CARD_DECK("덱에 카드가 없습니다. 더 이상 카드를 뽑을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_CAPTION.message + message;
    }
}
