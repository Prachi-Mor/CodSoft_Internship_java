import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculataing_grade extends JFrame implements ActionListener { // Declares a class extending JFrame and implementing ActionListener

    JLabel[] labels; // Array of JLabels to display subject names
    JTextField[] textFields; // Array of JTextFields for user input of marks
    JButton calculateButton; // Button to trigger grade calculation

    public Calculataing_grade() { // Constructor to set up the GUI
        labels = new JLabel[6]; // Initializes an array for 6 labels
        textFields = new JTextField[6]; // Initializes an array for 6 text fields

        String[] subjects = {"Java", "Python", "JavaScript", "C++", "BioTechnology", "SoftSkill"}; // Array of subjects

        for (int i = 0; i <= 5; i++) { // Loop to create and position each label and text field
            labels[i] = new JLabel(subjects[i]); // Creates a new JLabel with the subject name
            textFields[i] = new JTextField(); // Creates a new JTextField for marks input
            labels[i].setBounds(50, 50 + i * 50, 100, 30); // Sets the position and size of each JLabel
            textFields[i].setBounds(160, 50 + i * 50, 100, 30); // Sets the position and size of each JTextField
            add(labels[i]); // Adds the JLabel to the JFrame
            add(textFields[i]); // Adds the JTextField to the JFrame
        }

        calculateButton = new JButton("Calculate"); // Creates a new JButton for calculation
        calculateButton.setBounds(100, 350, 100, 30); // Sets the position and size of the button
        calculateButton.addActionListener(this); // Registers the current instance as the button's ActionListener
        calculateButton.setBackground(new Color(50, 205, 50)); // Sets the button's background color to green
        calculateButton.setForeground(Color.WHITE); // Sets the button's text color to white
        add(calculateButton); // Adds the button to the JFrame

        setTitle("Student Grade Calculator"); // Sets the title of the JFrame window
        setSize(300, 400); // Sets the window size to 300x400 pixels
        setLayout(null); // Uses no layout manager, setting absolute positions for components
        setVisible(true); // Makes the window visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Specifies the operation that will happen by default when the user initiates a "close" on this frame
        getContentPane().setBackground(new Color(240, 240, 240)); // Sets the background color of the content pane to light gray
    }

    public static void main(String[] args) { // Main method to run the program
        new Calculataing_grade(); // Creates an instance of the class, launching the GUI
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Method to handle button click events
        if (e.getSource() == calculateButton) { // Checks if the event source is the calculate button
            int totalMarks = 0; // Variable to accumulate total marks
            int numSubjects = 0; // Variable to count the number of subjects with valid marks

            for (int i = 0; i < 5; i++) { // Loop through each text field to calculate total marks
                String marksText = textFields[i].getText(); // Gets text from each JTextField
                if (!marksText.isEmpty()) { // Checks if the text field is not empty
                    int marks = Integer.parseInt(marksText); // Converts text input to an integer
                    totalMarks += marks; // Adds marks to total
                    numSubjects++; // Increments the number of subjects
                }
            }

            double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100; // Calculates average percentage
            String grade = calculateGrade(averagePercentage); // Calls method to determine the grade based on percentage

            JOptionPane.showMessageDialog(this, "Total Marks: " + totalMarks + // Displays result in a dialog box
                    "\nAverage Percentage: " + averagePercentage + "%" +
                    "\nGrade: " + grade);
        }
    }

    private String calculateGrade(double percentage) { // Method to calculate grade based on percentage
        if (percentage >= 95) {
            return "A+"; // Returns grade "A+" for 95% and above
        } else if (percentage >= 90) {
            return "A"; // Returns grade "A" for 90% to 94.99%
        } else if (percentage >= 80) {
            return "B+"; // Returns grade "B+" for 80% to 89.99%
        } else if (percentage >= 70) {
            return "B"; // Returns grade "B" for 70% to 79.99%
        } else if (percentage >= 60) {
            return "C"; // Returns grade "C" for 60% to 69.99%
        } else if (percentage >= 50) {
            return "D"; // Returns grade "D" for 50% to 59.99%
        } else {
            return "F"; // Returns grade "F" for below 50%
        }
    }
}