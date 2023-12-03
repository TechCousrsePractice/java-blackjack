package blackjack.domain;

import blackjack.domain.card.Value;

public class Constants {
    public static final int BLACK_JACK_NUMBER = 21;
    public static final int ACE_VALUE_DIFFERENCE = Value.ACE.getOptionalNumber() - Value.ACE.getNumber();
}
