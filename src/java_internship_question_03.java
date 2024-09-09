import java.util.*;

// Class representing a user's bank account
class BankAccount {
    private double balance; // Private variable to store the account balance
    private List<String> transactionHistory; // List to store the transaction history

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance; // Set the balance to the initial amount if it is positive
        } else {
            this.balance = 0; // Set balance to 0 if the initial amount is not positive
        }
        this.transactionHistory = new ArrayList<>(); // Initialize the transaction history
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Increase the balance by the deposit amount
            System.out.println("Successfully deposited: $" + amount);
            transactionHistory.add("Deposited: $" + amount); // Log the deposit transaction
        } else {
            System.out.println("Deposit amount must be positive."); // Show error for non-positive deposit
        }
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Decrease the balance by the withdrawal amount
            System.out.println("Successfully withdrew: $" + amount);
            transactionHistory.add("Withdrew: $" + amount); // Log the withdrawal transaction
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal."); // Show error for insufficient balance
        } else {
            System.out.println("Withdrawal amount must be positive."); // Show error for non-positive withdrawal
        }
    }

    // Method to check the current account balance
    public double checkBalance() {
        transactionHistory.add("Checked balance: $" + balance); // Log the balance check transaction
        return balance; // Return the current balance
    }

    // Method to display the transaction history
    public void displayTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found."); // Show message if no transactions are found
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction); // Display each transaction
            }
        }
    }
}

// Class representing the ATM machine interface
class ATM {
    private BankAccount account; // Reference to a BankAccount object
    private Timer timer; // Timer to handle session timeout

    // Constructor to initialize the ATM with a user's bank account
    public ATM(BankAccount account) {
        this.account = account; // Link the bank account to the ATM
    }

    // Method to start a session timer
    private void startSessionTimer() {
        timer = new Timer(); // Initialize a new Timer
        timer.schedule(new TimerTask() { // Schedule a task to run after a delay
            @Override
            public void run() {
                System.out.println("\nSession timed out. Please log in again.");
                System.exit(0); // Exit the application when the session times out
            }
        }, 30000); // Set the timer for 30 seconds
    }

    // Method to reset the session timer
    private void resetTimer() {
        if (timer != null) {
            timer.cancel(); // Cancel the existing timer
        }
        startSessionTimer(); // Start a new timer
    }

    // Method to display the ATM menu and handle user interactions
    public void start() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        boolean running = true; // Boolean flag to control the ATM loop

        startSessionTimer(); // Start the session timer

        // ATM user interface loop
        while (running) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Read user input for the menu choice

            resetTimer(); // Reset the timer after each input to keep the session alive

            switch (choice) {
                case 1: // Option to check balance
                    System.out.println("Current Balance: $" + account.checkBalance());
                    break;
                case 2: // Option to deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3: // Option to withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4: // Option to view transaction history
                    account.displayTransactionHistory();
                    break;
                case 5: // Option to exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false; // Exit the loop
                    break;
                default: // Handle invalid menu options
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close(); // Close the scanner to avoid resource leaks
    }
}

// Main class to run the ATM application
public class java_internship_question_03 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Create a new bank account with an initial balance
        ATM atm = new ATM(userAccount); // Create a new ATM interface linked to the user's bank account

        atm.start(); // Start the ATM interface
    }
}