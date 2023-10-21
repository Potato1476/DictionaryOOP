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

        while (text.hasNextLine()) {
            Word newWord = new Word();
            String line = text.nextLine();
            String temp[] = line.split("    ");
            newWord.setTaget(temp[0]);
            newWord.setExplain(temp[1]);
            wordList.add(newWord);
        }
        
    }

    public void addWord() {

        Scanner input = new Scanner(System.in);

        String target = input.nextLine();
        String explain = input.nextLine();

        for (int i = 0; i < wordList.size(); i++) {
            if (target.equals(wordList.get(i).getTarget()) && explain.equals(wordList.get(i).getExplain())) {
                System.out.println("Tu nay da ton tai!");
                return;
            }
        }

        Word newWord = new Word();
        newWord.setTaget(target);
        newWord.setExplain(explain);
        wordList.add(newWord);    

    }

    public void dictionaryLookup() {

        Scanner input = new Scanner(System.in);

        String inputString = input.nextLine();

        for (int i = 0; i < wordList.size(); i++) {
            String target = wordList.get(i).getTarget();
            String explain = wordList.get(i).getExplain();
            if (target.contains(inputString) || explain.contains(inputString)) {
                System.out.print(target);
                System.out.print(" | ");
                System.out.println(explain);
            }
    }

}
