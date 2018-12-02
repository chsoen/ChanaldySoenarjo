import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static void findWord(String word, ArrayList<String> sentenceList) {
        for(String sentence:sentenceList) {
            int index = 0;
            while(sentence.indexOf(" " + word + " ", index) != -1) {
                index = sentence.indexOf(" " + word + " ", index) + word.length();
                System.out.println("Sentence " + sentenceList.indexOf(sentence) + " at " + index);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        FileReader in = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(in);

        ArrayList<String> wordList = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null) {
            String split[] = line.split(" ");
            wordList.addAll(Arrays.asList(split));
        }

        ArrayList<String> abbreviationList = new ArrayList<>(Arrays.asList("a.m.", "A.M.", "e.g.", "p.m.", "P.M.", "Mr.", "Mrs."));
        ArrayList<String> sentenceList = new ArrayList<>();
        String sentence = "";
        for(String word: wordList) {
            if (word.isEmpty()) continue;

            boolean check = false;
            for(String abbrev: abbreviationList) {
                check = word.contains(abbrev);
            }
            if (check) {
                sentence = sentence.concat(word + " ");
                continue;
            }

            if (word.contains(".")) {
                sentence = sentence.concat(word);
                sentenceList.add(sentence);
                sentence = "";
            } else {
                sentence = sentence.concat(word + " ");
            }
        }

        for(String sen:sentenceList) {
            System.out.println(sen + "\r");
        }

        findWord("as",sentenceList);
    }
}
