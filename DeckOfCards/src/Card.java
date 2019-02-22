public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;

    enum Suit {
        DIAMONDS(1), CLUBS(2), HEARTS(3), SPADES(4);
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
            return this.hashCode() == obj.hashCode();
        }
        return false;
    }

    @Override
    public int compareTo(Card o) {
        if (this.hashCode() > o.hashCode()) {
            return 1;
        } else if (this.hashCode() < o.hashCode()) {
            return -1;
        }
        return 0;
    }
}
