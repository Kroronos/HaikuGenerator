import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    public static void printMenu() {
        System.out.println("1. Load a dictionary");
        System.out.println("2. Generate a Haiku");
        System.out.println("3. Save the previous Haiku");
        System.out.println("4. Exit the Program");
    }
    
    public static int invalidOption() {
        Scanner in = new Scanner(System.in);
        int userInput = 0;
        System.out.println("Please enter a valid input");
        printMenu();
        try {
            userInput = in.nextInt();
            }
        catch (InputMismatchException e) {
            userInput = invalidOption();
            }
        return userInput;
    }
}
