import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LabExer5A {
    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(50) + 1; // Random number between 1 and 50
        int guess = 0;
        int totalGuesses = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess a number between 1 and 50!");

        while (true) {
            try {
                System.out.print("Enter your guess: ");
                guess = Integer.parseInt(scanner.nextLine()); // Parse user input as an integer
                totalGuesses++;

                if (guess < 1 || guess > 50) {
                    throw new IllegalArgumentException("Out of range. Please guess a number between 1 and 50.");
                }

                if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("You got it in " + totalGuesses + " attempt(s)!");
        scanner.close();
    }
}
