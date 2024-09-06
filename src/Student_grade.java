import java.util.Scanner;

public class Student_grade { // Declares the class Student_grade
    public static void main(String[] args) { // The main method, entry point of the Java application
        Scanner scanner = new Scanner(System.in); // Creates a new Scanner object for reading input from the console
        System.out.print("Enter the number of subjects: "); // Prompts the user to enter the number of subjects
        int numSubjects = scanner.nextInt(); // Reads the number of subjects from the user input and stores it in the variable numSubjects
        int[] marks = new int[numSubjects]; // Creates an array to store marks for each subject
        int totalMarks = 0; // Initializes a variable to store the total marks obtained
        int maxMarks = 0; // Initializes a variable to store the sum of maximum marks possible

        for (int i = 0; i < numSubjects; i++) { // Loops through each subject
            System.out.print("Enter maximum marks for subject " + (i + 1) + ": "); // Prompts the user to enter the maximum marks for the current subject
            int maxMark = scanner.nextInt(); // Reads the maximum marks for the current subject
            maxMarks += maxMark; // Adds the maximum marks to the total maximum marks
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": "); // Prompts the user to enter the marks obtained for the current subject
            marks[i] = scanner.nextInt(); // Reads the marks obtained for the current subject and stores it in the marks array
            totalMarks += marks[i]; // Adds the marks obtained to the total marks
        }

        double averagePercentage = (double) totalMarks / maxMarks * 100; // Calculates the average percentage of marks obtained
        String grade = ""; // Initializes a variable to store the grade

        if (averagePercentage >= 90) { // Checks if the average percentage is 90 or above
            grade = "A"; // Sets grade to "A" if the condition is true
        } else if (averagePercentage >= 80) { // Checks if the average percentage is between 80 and 89.99
            grade = "B"; // Sets grade to "B" if the condition is true
        } else if (averagePercentage >= 70) { // Checks if the average percentage is between 70 and 79.99
            grade = "C"; // Sets grade to "C" if the condition is true
        } else if (averagePercentage >= 60) { // Checks if the average percentage is between 60 and 69.99
            grade = "D"; // Sets grade to "D" if the condition is true
        } else { // If the average percentage is below 60
            grade = "F"; // Sets grade to "F"
        }

        System.out.println("Total marks: " + totalMarks); // Prints the total marks obtained
        System.out.println("Average percentage: " + averagePercentage + "%"); // Prints the average percentage
        System.out.println("Grade: " + grade); // Prints the grade
    }
}