import java.util.Random;
import java.util.Scanner;
public class RandomGuessNumberGameTask1 {
    private static final int MAX_ATTEMPTS = 7;
    private static final int ROUNDS_TO_WIN = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsPlayed = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game...!!!");

        while (true) {
            boolean roundWon = playRound(random, scanner);

            if (roundWon) {
                score++;
            }
            roundsPlayed++;

            if (roundsPlayed >= ROUNDS_TO_WIN) {
                System.out.println("Game over! You've played " + roundsPlayed + " rounds.");
                System.out.println("Your score: " + score + " rounds won.");
                break;
            }

            if (!askToPlayAgain(scanner)) {
                System.out.println("Game over! You've played " + roundsPlayed + " rounds.");
                System.out.println("Your score: " + score + " rounds won.");
                break;
            }
        }
    }

    private static boolean playRound(Random random, Scanner scanner) {
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int guess;

            try {
                guess = Integer.parseInt(scanner.nextLine());

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess < numberToGuess) {
                    System.out.println("Too low...!!!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high...!!!");
                } else {
                    System.out.println("Congratulations! You've guessed the number.");
                    guessedCorrectly = true;
                }

                attempts++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
        }

        return guessedCorrectly;
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.print("Do you want to play another round? (yes/no): ");
        String playAgain = scanner.nextLine().trim().toLowerCase();
        return playAgain.equals("yes");
    }
}


