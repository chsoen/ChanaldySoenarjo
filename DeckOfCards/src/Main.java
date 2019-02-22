import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Card> deck = new LinkedList<>();

        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(deck);

        for (Card card : deck) {
            System.out.println(card);
        }
        System.out.println();

        System.out.println(deck.peekFirst());
        System.out.println(deck.peekLast());

        System.out.println(deck.peekLast().equals(deck.peekLast()));

        System.out.println();
        System.out.println("--SORT--");
        Collections.sort(deck);
        for (Card card : deck) {
            System.out.println(card);
        }

        System.out.println();
        System.out.println("--SORT--");
        CardComparator valueOrg = new CardComparator();
        Collections.sort(deck,valueOrg);
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
