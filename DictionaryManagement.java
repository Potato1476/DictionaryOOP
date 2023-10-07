import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {

    ArrayList<Word> wordList;

    DictionaryManagement() {
        wordList = new ArrayList<>();
    }

    public void insertFromCommandline() {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {

            String target = input.nextLine();
            String explain = input.nextLine();

            Word newWord = new Word();
            newWord.setTaget(target);
            newWord.setExplain(explain);

            wordList.add(newWord);

        }

        input.close();
    }

    public void insertFromFile() throws IOException {
        Scanner text = new Scanner(new File("dictionary.txt"));
        boolean isTarget = true;
        int i = 0;
        if (!text.hasNextLine()) {
            Word newWord = new Word();
            newWord.setTaget(text.next());
            newWord.setExplain(text.next());
            wordList.add(newWord);
        } else {
            while(text.hasNextLine()) {
                String line = text.nextLine();
                Word newWord = new Word();
                newWord.setTaget(line.next());
                newWord.setExplain(line.next());
                wordList.add(newWord);
            }
        }
    }
}
