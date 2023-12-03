package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.card.CardDeck;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Players;
import blackjack.dto.ParticipantsDto;
import blackjack.dto.PlayerDto;
import blackjack.dto.PlayerNamesDto;
import blackjack.utils.Mapper;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.function.Supplier;


public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CardDeck cardDeck;

    private GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cardDeck = CardDeck.create();
    }

    public static GameController of(InputView inputView, OutputView outputView) {
        return new GameController(inputView, outputView);
    }

    public void play(Players players) {
        Dealer dealer = createDealerWithCards();
        distributeCardsToPlayers(players);
        ParticipantsDto participantsDto = Mapper.toParticipantsDto(dealer, players);
        outputView.printCardDistribution(participantsDto);
        players.getPlayers().forEach(player -> {
            PlayerDto playerDto = Mapper.toPlayerDto(player);
            if (readHit(playerDto)) {
                player.addCard(cardDeck.drawCard());
                outputView.printUpdatedCardStatus(playerDto);
            }
        });
        //TODO dealer 카드 더 받을지 여부 결정 후 실행

    }

    private Dealer createDealerWithCards() {
        Cards cards = cardDeck.initialDraw();
        return Dealer.from(cards);
    }

    private void distributeCardsToPlayers(Players players) {
        players.initializeCards(cardDeck);
    }


    private boolean readHit(PlayerDto playerDto) {
        return readUserInput(() -> inputView.readHit(playerDto));
    }

    private <T> T readUserInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
