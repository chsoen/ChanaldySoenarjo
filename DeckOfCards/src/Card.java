public class Card {
    private Suit suit;
    private Rank rank;

    enum Suit {
        SPADES(1), HEARTS(2), CLUBS(3), DIAMONDS(4);
        int value;

        Suit(int value) {
            this.value = value;
        }
    }

    enum Rank {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
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

    @Override
    public int hashCode() {
        return this.suit.value * 100 + this.rank.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            return this.rank.value == ((Card) obj).rank.value && this.suit.value == ((Card) obj).suit.value;
        }
        return false;
    }
}
