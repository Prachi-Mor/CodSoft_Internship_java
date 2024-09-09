import java.util.*;

// Class representing a quiz question
class QuizQuestion {
    private String questionText; // The text of the question
    private String[] options;    // The multiple-choice options for the question
    private int correctAnswerIndex; // The index of the correct answer

    // Constructor to initialize a quiz question
    public QuizQuestion(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getter method to get the text of the question
    public String getQuestionText() {
        return questionText;
    }

    // Getter method to get the options of the question
    public String[] getOptions() {
        return options;
    }

    // Getter method to get the correct answer index
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

// Class representing the timer for each quiz question
class QuizTimer {
    private Timer timer; // Java Timer to handle countdown
    private boolean timeUp; // Boolean flag to indicate if time is up

    // Constructor to initialize the timer
    public QuizTimer(int seconds) {
        timer = new Timer(); // Creates a new timer instance
        timeUp = false; // Sets initial flag for timeUp
        timer.schedule(new TimerTask() { // Schedules a task to run after a delay
            @Override
            public void run() {
                timeUp = true; // Marks time up as true once timer expires
            }
        }, seconds * 1000); // Converts seconds to milliseconds
    }

    // Method to check if the time is up
    public boolean isTimeUp() {
        return timeUp;
    }

    // Method to stop the timer
    public void stopTimer() {
        timer.cancel();
    }
}

// Class managing the entire quiz
class Quiz {
    private List<QuizQuestion> questions; // List of quiz questions
    private int score; // User's score
    private int currentQuestionIndex; // Index of the current question

    // Constructor to initialize quiz parameters
    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;
    }

    // Method to add a question to the quiz
    public void addQuestion(QuizQuestion question) {
        questions.add(question);
    }

    // Method to start the quiz
    public void start() {
        Scanner scanner = new Scanner(System.in); // Scanner for reading user input
        long quizStartTime = System.currentTimeMillis(); // Record the quiz start time

        // Loop through all questions
        while (currentQuestionIndex < questions.size()) {
            QuizQuestion question = questions.get(currentQuestionIndex); // Get the current question
            System.out.println("Question: " + question.getQuestionText()); // Display the question text
            String[] options = question.getOptions(); // Get the options for the current question
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]); // Display the options
            }

            QuizTimer timer = new QuizTimer(10); // Set a 10-second timer for each question
            int userAnswer = -1;
            while (!timer.isTimeUp()) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt() - 1; // Convert to zero-based index
                    break;
                }
            }

            timer.stopTimer(); // Stop the timer once the user has answered or time is up

            if (timer.isTimeUp()) {
                System.out.println("Time's up!"); // Inform the user if the time is up
            } else if (userAnswer == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!"); // Inform the user if the answer is correct
                score++; // Increase score for the correct answer
            } else {
                System.out.println("Incorrect!"); // Inform the user if the answer is incorrect
            }
            currentQuestionIndex++; // Move to the next question
        }

        long quizEndTime = System.currentTimeMillis(); // Record the quiz end time
        long totalTimeTaken = (quizEndTime - quizStartTime) / 1000; // Calculate the total time taken in seconds

        displayResults(totalTimeTaken); // Display final results
    }

    // Method to display the final results
    private void displayResults(long totalTimeTaken) {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());
        System.out.println("Time Taken: " + totalTimeTaken + " seconds");
    }
}

// Main class to run the quiz application
public class java_internship_question_04 {
    public static void main(String[] args) {
        Quiz quiz = new Quiz(); // Create a new Quiz instance

        // Add Java programming-related questions to the quiz
        quiz.addQuestion(new QuizQuestion("Which keyword is used to define a class in Java?",
                new String[]{"class", "Class", "struct", "define"}, 0));
        quiz.addQuestion(new QuizQuestion("Which of these is a valid declaration of the main method in Java?",
                new String[]{"public void main(String[] args)", "public static void main(String[] args)",
                        "void main(String[] args)", "static void main(String args[])"}, 1));
        quiz.addQuestion(new QuizQuestion("Which of the following is not a primitive data type in Java?",
                new String[]{"int", "boolean", "String", "char"}, 2));
        quiz.addQuestion(new QuizQuestion("Which exception is thrown when a division by zero occurs in Java?",
                new String[]{"NullPointerException", "ArithmeticException", "IOException", "NumberFormatException"}, 1));
        quiz.addQuestion(new QuizQuestion("Which method is used to convert a string to an integer in Java?",
                new String[]{"Integer.parseInt()", "int.parse()", "String.toInt()", "parseInt()"}, 0));

        // Start the quiz
        quiz.start();
    }
}
