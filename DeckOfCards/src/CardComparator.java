import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        if (o1.hashCode() % 100 > o2.hashCode() % 100) {
            return 1;
        } else if (o1.hashCode() % 100 < o2.hashCode() % 100) {
            return -1;
        } else if (o1.hashCode() / 100 > o2.hashCode() / 100) {
            return 1;
        } else if (o1.hashCode() / 100 < o2.hashCode() / 100) {
            return -1;
        }
        return 0;
    }
}
