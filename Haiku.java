import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Haiku {
    String lineOne;
    String lineTwo;
    String lineThree;
    public Haiku(File dict){
        Scanner HaikuReader = null;
        try {
            HaikuReader = new Scanner(dict);
        } 
        catch (FileNotFoundException e) {
        }
       
        ArrayList <String[]> dictionaryList= new ArrayList<String[]>();
        
        while(HaikuReader.hasNext()) {
            String word = HaikuReader.next();
            String syllables = HaikuReader.next();
            String determiner = HaikuReader.next();
            String[] dictionaryEntry = new String[3];
            dictionaryEntry[0] = word ;
            dictionaryEntry[1] = syllables;
            dictionaryEntry[2] = determiner;
            dictionaryList.add(dictionaryEntry);
        }
        
        Random variableRandom = new Random();
        //Haiku Form 1
        //Line 1  article, noun 
        //Line 2  adjective, noun, verb
        //Line 3  article, verb, adverb
        
        // Haiku Form 2
        //Line 1  verb, noun
        //Line 2 noun, verb
        //Line 3 article, noun, noun
        
        int HaikuForm = variableRandom.nextInt(2);
        
        if (HaikuForm == 0) {
            lineOne = findSyllableLine(dictionaryList, 5, "article", "noun");
            lineTwo = findSyllableLine(dictionaryList, 7, "adjective", "noun", "verb");
            lineThree = findSyllableLine(dictionaryList, 5, "adjective", "verb", "adverb");
        }
        
        if (HaikuForm == 1) {
            lineOne = findSyllableLine(dictionaryList, 5, "verb", "noun");
            lineTwo = findSyllableLine(dictionaryList, 7, "noun", "verb");
            lineThree = findSyllableLine(dictionaryList, 5, "article", "noun", "noun");
        }
   
        
    }
    
    public String getLineOne() {
        return lineOne;
    }
    public String getLineTwo() {
        return lineTwo;
    }
    public String getLineThree() {
        return lineThree;
    }
    
    public String findSyllableLine(ArrayList <String[]> dictionary, int syllables, String a, String b, String c) {
        String[] generatedLine = new String[3];
        ArrayList <String> aOneList = new ArrayList<String>();
        ArrayList <String> bOneList = new ArrayList<String>();
        ArrayList <String> cOneList = new ArrayList<String>();
        ArrayList <String> aTwoList = new ArrayList<String>();
        ArrayList <String> bTwoList = new ArrayList<String>();
        ArrayList <String> cTwoList = new  ArrayList<String>();
        ArrayList <String> aThreeList = new ArrayList<String>();
        ArrayList <String> bThreeList = new ArrayList<String>();
        ArrayList <String> cThreeList = new ArrayList<String>();
        ArrayList <String> aFourList = new ArrayList<String>();
        ArrayList <String> bFourList = new ArrayList<String>();
        ArrayList <String> cFourList = new ArrayList<String>();
        ArrayList <String> aFiveList = new ArrayList<String>();
        ArrayList <String> bFiveList = new ArrayList<String>();
        ArrayList <String> cFiveList = new ArrayList <String>();

        for(int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i)[2].equals(a)) {
                if (dictionary.get(i)[1].equals("1")) {
                    aOneList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("2")) {
                    aTwoList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("3")) {
                    aThreeList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("4")) {
                    aFourList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("5")) {
                    aFiveList.add(dictionary.get(i)[0]);
                }

            }
            if (dictionary.get(i)[2].equals(b)) {
                if (dictionary.get(i)[1].equals("1")) {
                    bOneList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("2")) {
                    bTwoList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("3")) {
                    bThreeList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("4")) {
                    bFourList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("5")) {
                    bFiveList.add(dictionary.get(i)[0]);
                }

            }
            if (dictionary.get(i)[2].equals(c)) {
                if (dictionary.get(i)[1].equals("1")) {
                    cOneList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("2")) {
                    cTwoList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("3")) {
                    cThreeList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("4")) {
                    cFourList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("5")) {
                    cFiveList.add(dictionary.get(i)[0]);
                }

            }
        }
        Random variableRandom = new Random();
        int variableA = 0;
        int variableB = 0;
        int variableC = 0;
        
        //Get word of type A 
        while ( (generatedLine[0] == null) && (variableA == 0 || variableA == syllables || variableA == syllables - 1)) {
            variableA = variableRandom.nextInt((syllables - 1));          
            
            if (variableA == 5) {
                int indexReference = variableRandom.nextInt(aFiveList.size());
                generatedLine[0] = aFiveList.get(indexReference);
            }
            if (variableA == 4) {
                int indexReference = variableRandom.nextInt(aFourList.size());
                generatedLine[0] = aFourList.get(indexReference);
            }
            if (variableA == 3) {
                int indexReference = variableRandom.nextInt(aThreeList.size());        
                generatedLine[0] = aThreeList.get(indexReference);
            }
            if (variableA == 2) {
                int indexReference = variableRandom.nextInt(aTwoList.size());
                generatedLine[0] = aTwoList.get(indexReference);
            }
            if (variableA == 1) {
                int indexReference = variableRandom.nextInt(aOneList.size());
                generatedLine[0] = aOneList.get(indexReference);
            }
        }
        
        //Get word of type B
        while (variableB == 0) {
            variableB = variableRandom.nextInt(syllables - variableA);
        }
        
        if (variableB == 5) {
            int indexReference = variableRandom.nextInt(bFiveList.size());
            generatedLine[1] = bFiveList.get(indexReference);
        }
        if (variableB == 4) {
            int indexReference = variableRandom.nextInt(bFourList.size());
            generatedLine[1] = bFourList.get(indexReference);
        }
        if      (variableB == 3) {
            int indexReference = variableRandom.nextInt(bThreeList.size());        
            generatedLine[1] = bThreeList.get(indexReference);
        }
        if (variableB == 2) {
            int indexReference = variableRandom.nextInt(bTwoList.size());
            generatedLine[1] = bTwoList.get(indexReference);
        }
        if (variableB == 1) {
            int indexReference = variableRandom.nextInt(bOneList.size());
            generatedLine[1] = bOneList.get(indexReference);
        }
        
        //Get word of type C
        variableC = syllables - variableA - variableB;
        
        if (variableC == 5) {
            int indexReference = variableRandom.nextInt(cFiveList.size());
            generatedLine[2] = cFiveList.get(indexReference);
        }
        if (variableC == 4) {
            int indexReference = variableRandom.nextInt(cFourList.size());
            generatedLine[2] = cFourList.get(indexReference);
        }
        if (variableC == 3) {
            int indexReference = variableRandom.nextInt(cThreeList.size());        
            generatedLine[2] = cThreeList.get(indexReference);
        }
        if (variableC == 2) {
            int indexReference = variableRandom.nextInt(cTwoList.size());
            generatedLine[2] = cTwoList.get(indexReference);
        }
        if (variableC == 1) {
            int indexReference = variableRandom.nextInt(cOneList.size());
            generatedLine[2] = cOneList.get(indexReference);
        }
        
        
        
        String finalLine = generatedLine[0] + " " + generatedLine[1] + " " + generatedLine[2];
        return finalLine;
    }
    
    //Overload Method for lines with less words
    public String findSyllableLine(ArrayList <String[]> dictionary, int syllables, String a, String b) {
        String[] generatedLine = new String[2];
        
        ArrayList <String> aOneList = new ArrayList<String>();
        ArrayList <String> bOneList = new ArrayList<String>();
        ArrayList <String> aTwoList = new ArrayList<String>();
        ArrayList <String> bTwoList = new ArrayList<String>();
        ArrayList <String> aThreeList = new ArrayList<String>();
        ArrayList <String> bThreeList = new ArrayList<String>();
        ArrayList <String> aFourList = new ArrayList<String>();
        ArrayList <String> bFourList = new ArrayList<String>();
        ArrayList <String> aFiveList = new ArrayList<String>();
        ArrayList <String> bFiveList = new ArrayList<String>();


        for(int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i)[2].equals(a)) {
                if (dictionary.get(i)[1].equals("1")) {
                    aOneList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("2")) {
                    aTwoList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("3")) {
                    aThreeList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("4")) {
                    aFourList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("5")) {
                    aFiveList.add(dictionary.get(i)[0]);
                }

            }
            if (dictionary.get(i)[2].equals(b)) {
                if (dictionary.get(i)[1].equals("1")) {
                    bOneList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("2")) {
                    bTwoList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("3")) {
                    bThreeList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("4")) {
                    bFourList.add(dictionary.get(i)[0]);
                }
                if (dictionary.get(i)[1].equals("5")) {
                    bFiveList.add(dictionary.get(i)[0]);
                }

            }
        }
        Random variableRandom = new Random();
        int variableA = 0;
        int variableB = 0;
        
        //Get word of type A 
        
        while ( (generatedLine[0] == null) && (variableA == 0 || variableA == syllables || variableA == syllables - 1)) {
            variableA = variableRandom.nextInt(syllables-1);
            
            if (variableA == 5) {
                int indexReference = variableRandom.nextInt(aFiveList.size());
                generatedLine[0] = aFiveList.get(indexReference);
            }
            if (variableA == 4) {
                int indexReference = variableRandom.nextInt(aFourList.size());
                generatedLine[0] = aFourList.get(indexReference);
            }
            if (variableA == 3) {
                int indexReference = variableRandom.nextInt(aThreeList.size());        
                generatedLine[0] = aThreeList.get(indexReference);
            }
            if (variableA == 2) {
                int indexReference = variableRandom.nextInt(aTwoList.size());
                generatedLine[0] = aTwoList.get(indexReference);
            }
            if (variableA == 1) {
                int indexReference = variableRandom.nextInt(aOneList.size());
                generatedLine[0] = aOneList.get(indexReference);
            }
        }
        //Get word of type B
        while ( (generatedLine[1] == null) && (variableB == 0)) {
            variableB = syllables - variableA;
            
            
            if (variableB == 5) {
                int indexReference = variableRandom.nextInt(bFiveList.size());
                generatedLine[1] = bFiveList.get(indexReference);
            }
            if (variableB == 4) {
                int indexReference = variableRandom.nextInt(bFourList.size());
                generatedLine[1] = bFourList.get(indexReference);
            }
            if (variableB == 3) {
                int indexReference = variableRandom.nextInt(bThreeList.size());        
                generatedLine[1] = bThreeList.get(indexReference);
            }
            if (variableB == 2) {
                int indexReference = variableRandom.nextInt(bTwoList.size());
                generatedLine[1] = bTwoList.get(indexReference);
            }
            if (variableB == 1) {
                int indexReference = variableRandom.nextInt(bOneList.size());
                generatedLine[1] = bOneList.get(indexReference);
            }
        }
        
        
        String finalLine = generatedLine[0] + " " + generatedLine[1];
        return finalLine;
    }
}
