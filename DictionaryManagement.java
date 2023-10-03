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

}
