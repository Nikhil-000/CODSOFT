import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Generate a random number within the specified range
        int answer, numberGuess; 
        final int MAX = 100; 
        answer = random.nextInt(MAX) + 1; 
  

        // Additional details
        int maxAttempts = 5;
        int roundsPlayed = 0;
        int totalAttempts = 0;
        int roundsWon = 0;

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\nRound " + (roundsPlayed + 1));

            // Step 2 and 3: Prompt the user to enter their guess and provide feedback
            for (int attempt = 0; attempt < maxAttempts; attempt++) {
                System.out.println("Guess the number between 1 to 100:");
                numberGuess = scanner.nextInt();

                if (numberGuess == answer) {
                    System.out.println("Congratulations! You guessed the correct number " + answer + " in " + (attempt + 1) + " attempts.");
                    totalAttempts += (attempt + 1);
                    roundsWon++;
                    break;
                } else if (numberGuess < answer) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // Additional details (Steps 5 and 6)
            roundsPlayed++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            // Display user's score (Step 7)
        }
        
        System.out.println("\nGame Over. You played " + roundsPlayed + " rounds and won " + roundsWon + " rounds.");
        if (roundsPlayed > 0) {
            double averageAttempts = (double) totalAttempts / roundsPlayed;
            System.out.printf("Average attempts per round: %.2f%n", averageAttempts);
        }

        scanner.close();
    }
}
