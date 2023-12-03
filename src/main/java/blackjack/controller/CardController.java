package blackjack.controller;

import blackjack.domain.player.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class CardController {
    private final InputView inputView;
    private final OutputView outputView;

    private CardController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static CardController of(InputView inputView, OutputView outputView) {
        return new CardController(inputView, outputView);
    }

    public void play(Players players) {
        distributeCards();
    }

    private void distributeCards(Players players) {

    }


}
