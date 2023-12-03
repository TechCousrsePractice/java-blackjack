package blackjack.utils;

import blackjack.domain.Dealer;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Player;
import blackjack.domain.player.Players;
import blackjack.dto.*;

import java.util.List;

public class Mapper {
    public static ParticipantsDto toParticipantsDto(Dealer dealer, Players players) {
        return new ParticipantsDto(toDealerDto(dealer), toPlayerDtos(players));
    }

    public static DealerDto toDealerDto(Dealer dealer) {
        return new DealerDto(toCardsDto(dealer.getCards()));
    }

    public static List<PlayerDto> toPlayerDtos(Players players) {
        return players.getPlayers().stream()
                .map(player ->
                        new PlayerDto(player.getName(), toCardsDto(player.getCards())))
                .toList();
    }

    public static CardsDto toCardsDto(Cards cards) {
        List<CardDto> cardDtos = cards.getCards().stream()
                .map(card -> new CardDto(card.getValueName(), card.getShapeName()))
                .toList();
        return new CardsDto(cardDtos);
    }

    public static PlayerDto toPlayerDto(Player player) {
        return new PlayerDto(player.getName(), toCardsDto(player.getCards()));
    }
}