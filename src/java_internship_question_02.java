import java.util.Scanner;

public class java_internship_question_02 {
    public static void main(String[] args) {

//    }
//}

//import java.util.Scanner;
//
//public class StudentGradeCalculator {
//
//    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        double totalMarks = 0;

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter the marks obtained in subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble();
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = totalMarks / numberOfSubjects;

        // Determine grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

