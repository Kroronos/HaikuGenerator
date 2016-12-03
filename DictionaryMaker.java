import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class DictionaryMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text file you wish to alter");
        String filePath = (in.next() + ".txt");
        File fileAltered = new File(filePath);
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(fileAltered);
        }
        catch (FileNotFoundException e) {
            
        }
        ArrayList <String> wordInFile = new  ArrayList<String>();
        
        while(fileReader.hasNext()) {
            wordInFile.add(fileReader.next());
        }
        System.out.println("Enter syllable count");
        String syllables = in.next();
        System.out.println("Enter determiner type");
        String determiner = in.next();
        PrintWriter writeToFile = null;
        try {
            writeToFile = new PrintWriter(filePath);
        } 
        catch (FileNotFoundException e) {
        }

        for(int i = 0; i < wordInFile.size(); i++) {
            writeToFile.println(wordInFile.get(i));
            writeToFile.println(syllables);
            writeToFile.println(determiner);
        
        }
        writeToFile.close();
    }
}
