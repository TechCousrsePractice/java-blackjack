package blackjack.view;

import blackjack.dto.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final String CARD_DISTRIBUTION_TITLE_FORMAT = "딜러와 %s에게 2장을 나누었습니다.";
    private static final String CARD_DISTRIBUTION_NAME_DELIMITER = ", ";
    private static final String DEALER_CARD_FORMAT = "딜러: %s";
    private static final String PLAYER_CARD_FORMAT = "%s카드: %s";
    private static final String CARDS_DELIMITER = ", ";


    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printCardDistribution(ParticipantsDto participantsDto) {
        printLine();
        printDistributionTitle(participantsDto.playerDtos());
        CardDto dealerCard = participantsDto.dealerDto().cardsDto().cardDtos().get(0);
        printDealerCard(dealerCard);
        printPlayersCards(participantsDto);
    }

    private void printPlayersCards(ParticipantsDto participantsDto) {
        participantsDto.playerDtos().forEach(this::printCardStatus);
    }

    private void printCardStatus(PlayerDto playerDto) {
        System.out.println(String.format((PLAYER_CARD_FORMAT), playerDto.name(), makeCardsFormat(playerDto.cardsDto())));
    }

    private void printLine() {
        System.out.println();
    }

    private void printDistributionTitle(List<PlayerDto> playerDtos) {
        List<String> names = playerDtos.stream()
                .map(PlayerDto::name)
                .toList();
        System.out.printf((CARD_DISTRIBUTION_TITLE_FORMAT) + "%n",
                String.join(CARD_DISTRIBUTION_NAME_DELIMITER, names));
    }

    private void printDealerCard(CardDto dealerCard) {
        System.out.printf((DEALER_CARD_FORMAT) + "%n", makeCardFormat(dealerCard));
    }

    private String makeCardsFormat(CardsDto cardsDto) {
        List<String> cards = cardsDto.cardDtos().stream()
                .map(this::makeCardFormat)
                .toList();
        return String.join(CARDS_DELIMITER, cards);
    }

    private String makeCardFormat(CardDto cardDto) {
        return cardDto.value() + cardDto.shape();
    }

    public void printUpdatedCardStatus(PlayerDto playerDto) {
        printLine();
        printCardStatus(playerDto);
    }
}
