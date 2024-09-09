import java.util.Random;
import java.util.Scanner;

public class java_internship_question_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for reading user input
        Random random = new Random(); // Create a Random object for generating random numbers
        boolean playAgain = true; // Boolean to control whether the user wants to play another round
        int totalScore = 0; // Variable to keep track of the user's total score

        System.out.println("Welcome to the Number Guessing Game!");

        // Main game loop to allow multiple rounds
        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;  // Generates a random number between 1 and 100
            int attempts = 0; // Counter for the number of attempts made by the user
            int maxAttempts = 7;  // Limit the number of attempts allowed
            boolean hasWon = false; // Flag to indicate whether the user has guessed correctly

            System.out.println("\nA random number between 1 and 100 has been generated.");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            // Loop to allow the user multiple attempts to guess the number
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt(); // Read user's guess
                attempts++; // Increment the attempts counter

                // Check if the user's guess matches the random number
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    // Calculate score based on remaining attempts; higher score for fewer attempts
                    totalScore += maxAttempts - attempts + 1;
                    hasWon = true; // Set the win flag to true
                    break; // Exit the loop since the user guessed correctly
                }
                // Provide feedback if the guess is too low
                else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                }
                // Provide feedback if the guess is too high
                else {
                    System.out.println("Too high! Try again.");
                }
            }

            // If the user did not guess the number within the allowed attempts
            if (!hasWon) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
            }

            // Display the current score after each round
            System.out.println("Your current score: " + totalScore);

            // Prompt the user to decide if they want to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next(); // Read the user's response
            playAgain = response.equalsIgnoreCase("yes"); // Check if the user wants to play again
        }

        // Game over, display the final score
        System.out.println("Thank you for playing! Your final score: " + totalScore);
        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
