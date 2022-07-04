import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utilites {
    public static int enterInt(String message, int leftSide, int rightSide) {

        boolean error;
        int value = 0;

        do {
            try {
                error = false;
                System.out.println(message);
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextInt();

                if (value < leftSide || value > rightSide) {
                    System.out.println("Wrong value!");
                    error = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong value");
                error = true;
            }
        } while (error);
        return value;
    }

    public static void clearConsole(){
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    public static int randomize(int rightSide){
        Random random = new Random();
        int number = random.nextInt(rightSide);
        return number;
    }
}
