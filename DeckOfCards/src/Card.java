public class Card {
    Suit suit;
    Rank rank;

    enum Suit {
        SPADES, HEARTS, CLUBS, DIAMONDS
    }

    enum Rank {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
        int value;

        Rank(int value) {
            this.value = value;
        }
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
