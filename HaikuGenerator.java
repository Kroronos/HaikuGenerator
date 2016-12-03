import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
public class HaikuGenerator {
    public static void main(String [] args) {
            Scanner in = new Scanner(System.in);
            int userInput = 0;
            boolean validInput = false; 
            File dictionary = null;
            
            
            System.out.println("Welcome to the Haiku Generator");
            System.out.println();
            System.out.println("Select an option");
            Menu.printMenu();
            Haiku generated = null;
            while (userInput != 4) {
                try {
                    userInput = in.nextInt();
                }
                catch (InputMismatchException e){
                    userInput = Menu.invalidOption();
                }
                if (userInput > 0 && userInput < 5) {
                    validInput = true;
                }
                else {
                    Menu.invalidOption();
                }
                switch (userInput) {
                
                case 1:
                    System.out.println("Please type in directory of your Haiku dictionary");
                    System.out.println("Default: HaikuDictionary");
                    String dictionaryDirectory = in.next();
                    dictionary = new File(dictionaryDirectory+".txt");
                    if (dictionary.exists()) {
                       System.out.println("Dictionary sucessfully loaded"); 
                    }
                    else {
                        while(!dictionary.exists()) {
                            System.out.println("Please enter a dictionary that exists");
                            dictionaryDirectory = in.next();
                            dictionary = new File(dictionaryDirectory +".txt");
                            
                            if(dictionary.exists()) {
                                System.out.println("Dictionary sucessfully loaded"); 
                            }
                        }
                        
                    }
                    Menu.printMenu();
                    break;
                    
                case 2:
                    System.out.println("Generating Haiku...");
                    
                    if(dictionary != null) {
                        generated = new Haiku(dictionary);
                        System.out.println(generated.getLineOne());
                        System.out.println(generated.getLineTwo());
                        System.out.println(generated.getLineThree());
                    }
                    
                    else
                        System.out.println("Please load a dictionary before making a haiku");
                    
                    Menu.printMenu();
                    break;
                    
                case 3:
                    System.out.println("Name the Haiku file generated");
                    String filePath = in.next()+ ".txt";
                    PrintWriter HaikuWrite = null;
                    try {
                        HaikuWrite = new PrintWriter(filePath);
                    } 
                    catch (FileNotFoundException e) {
                    }
                    if(generated != null) {
                        HaikuWrite.println(generated.getLineOne());
                        HaikuWrite.println(generated.getLineTwo());
                        HaikuWrite.println(generated.getLineThree());
                        HaikuWrite.close();
                        System.out.println("Haiku saved!");
                    }
                    else
                        System.out.println("Please generate a haiku before trying to save one!");
                    
                    Menu.printMenu();
                    break;
                    
                case 4:
                    System.out.println("Thank you for using Haiku Generator!");
                    break;
                }
            }
    }
}
