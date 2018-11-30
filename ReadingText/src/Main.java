import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws IOException {
        FileReader in = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(in);

        ArrayList<String> sentences = new ArrayList<>();

        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }
}
