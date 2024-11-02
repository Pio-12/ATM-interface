import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
            return false;
        }
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a linked bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method for depositing money
    public void deposit(double amount) {
        account.deposit(amount);
        checkBalance(); // Show balance after deposit
    }

    // Method for withdrawing money
    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            checkBalance(); // Show balance after successful withdrawal
        } else {
            System.out.println("Withdrawal failed. Please check your balance and try again.");
        }
    }

    // Method for checking balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + account.getBalance());
    }

    // Method to display the ATM menu
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return; // Exit the loop
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

// Main class to run the ATM program
public class ATMSystem {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000.00);
        
        // Initializing ATM with the user's bank account
        ATM atm = new ATM(userAccount);

        // Displaying ATM menu for user interaction
        atm.displayMenu();
    }
}
