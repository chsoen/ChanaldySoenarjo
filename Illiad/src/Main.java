import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("illiad.txt"));

        HashSet<Word> words = new HashSet<>();

        while (scan.hasNext()) {
            words.add(new Word(scan.next().toLowerCase()));
        }

        Iterator<Word> wordsIter = words.iterator();

        while (wordsIter.hasNext()) {
            System.out.println(wordsIter.next());
        }
    }
}
