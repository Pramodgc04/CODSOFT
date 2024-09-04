
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int score = 0;
            boolean playAgain = true;

            System.out.println("Welcome to the Number Guessing Game!");

            while (playAgain) {
                int targetNumber = random.nextInt(100) + 1; 
                int numberOfAttempts = 0;
                int maxAttempts = 10;
                boolean correctGuess = false;

                System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

                while (numberOfAttempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    numberOfAttempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number in " + numberOfAttempts + " attempts.");
                        score += (maxAttempts - numberOfAttempts + 1);
                        correctGuess = true;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }

                if (!correctGuess) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
                }

                System.out.println("Your current score is: " + score);

                System.out.print("Do you want to play another round? (yes/no): ");
                String userResponse = scanner.next();
                playAgain = userResponse.equalsIgnoreCase("yes");
            }

            System.out.println("Thanks for playing! Your final score is: " + score);
        }
    }
}
