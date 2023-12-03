package blackjack.domain.player;

import blackjack.domain.card.CardDeck;

import java.util.List;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<Player> players) {
        return new Players(players);
    }

    public void initializeCards(CardDeck cardDeck) {
        players.forEach(player -> player.initializeCards(cardDeck.initialDraw()));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
