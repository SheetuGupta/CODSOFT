import java.util.Scanner;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int Guess = random.nextInt(100) + 1;
        int userGuess = 0;
        System.out.println("Enter a number between 1 and 100");
        while (userGuess != Guess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            if (userGuess < Guess) {
                System.out.println("Too low");
            } 
            else if (userGuess > Guess) {
                System.out.println("Too high");
            } 
            else {
                System.out.println("Congratulations! You guessed the number.");
            }
        }

        scanner.close();
    }
}
