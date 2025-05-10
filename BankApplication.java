
	// Package declaration
package bankApp;

import java.util.ArrayList;
import java.util.Scanner;

// Class representing a bank account
class Account {
    private final String accountName;
    private final int accountNumber;
    private double balance;

    // Constructor
    public Account(String accountName, int accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Initial balance
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: ETB" + amount);
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawn: ETB" + amount);
        }
    }

    // Display account information
    public void displayInfo() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: ETB" + balance);
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }
}

// Main class for the Bank Application
public class BankApplication {
    private static final ArrayList<Account> accounts = new ArrayList<>();
    private static int accountNumberCounter = 10000; // Unique account numbers
    private static final Scanner scanner = new Scanner(System.in);

    // Create a new account
    private static void createNewAccount() {
        System.out.print("Enter Account Name: ");
        String name = scanner.next();
        Account newAccount = new Account(name, accountNumberCounter++);
        accounts.add(newAccount);
        System.out.println("New Account Created Successfully! \n Account Number: " + newAccount.getAccountNumber());
    }

    // Deposit money into account
    private static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNumber = scanner.nextInt();
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                System.out.print("Enter Amount to Deposit: ");
                double amount = scanner.nextDouble();
                acc.deposit(amount);
                return;
            }
        }
        System.out.println(" Invalid Account !");
    }

    // Withdraw money from account
    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNumber = scanner.nextInt();
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                System.out.print("Enter Amount to Withdraw: ");
                double amount = scanner.nextDouble();
                acc.withdraw(amount);
                return;
            }
        }
        System.out.println("Invalid Account!");
    }

    // Display all accounts
    private static void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available!");
        } else {
            System.out.println("\n---- Account Information ----");
            accounts.forEach((acc) -> {
                acc.displayInfo();
            });
        }
    }

    // Clearing the console (simulated)
    private static void clearScreen() {
        System.out.println("\nClearing Screen...");
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Display menu
    private static void displayMenu() {
        System.out.println("\n---- Bank Application Menu ----");
        System.out.println("1. Create New Account");
        System.out.println("2. Cash Deposit");
        System.out.println("3. Cash Withdrawal");
        System.out.println("4. Display Account Information");
        System.out.println("5. Clear Screen");
        System.out.println("6. Exit");
        System.out.print("Choose an option =: ");
    }

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    displayAccounts();
                    break;
                case 5:
                    clearScreen();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you for using the Bank Application!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}
