import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("illiad.txt"));

        HashSet<String> words = new HashSet<>();

        String[] filters = {"'ve", "'s", "'ll", "'", "\"", ",", ";", ":", "(", ")", ".", "?", "!"};
        //Problem with words like 'tis, en' 'a, ??? the' ???


        while (scan.hasNext()) {
            String word = scan.next();

            if (word.endsWith("-")) {
                word = word.substring(0,word.length()-1);
            }

            for (String filter: filters) {
                word = word.toLowerCase().replace(filter, " ").trim();
            }

            words.add(word);
        }

        for (String word: words) {
            if (word.length() < 4) {
                System.out.print(word + " ");
            }
        }

        System.out.println(words.size());
    }
}
