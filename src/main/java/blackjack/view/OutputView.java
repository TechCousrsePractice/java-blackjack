package blackjack.view;

import blackjack.dto.PlayerNamesDto;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final String CARD_DISTRIBUTION_TITLE_FORMAT = "딜러와 %s에게 2장을 나누었습니다.";
    private static final String CARD_DISTRIBUTION_NAME_DELIMITER = ", ";


    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printCardDistribution(PlayerNamesDto playerNamesDto) {
        printLine();
        System.out.printf((CARD_DISTRIBUTION_TITLE_FORMAT) + "%n",
                String.join(CARD_DISTRIBUTION_NAME_DELIMITER, playerNamesDto.names()));
    }

    private void printLine() {
        System.out.println();
    }
}
