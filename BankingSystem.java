import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited ₹" + amount);
            System.out.println("✅ Successfully deposited ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew ₹" + amount);
            System.out.println("✅ Successfully withdrew ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    public void viewAccountInfo() {
        System.out.println("👤 Account Holder: " + accountHolder);
        System.out.println("💰 Balance: ₹" + balance);
    }

    public void printMiniStatement() {
        System.out.println("📜 Mini Statement:");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactions) {
                System.out.println("- " + t);
            }
        }
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🏦 Welcome to Simple Banking System!");
        System.out.print("Enter your name to open an account: ");
        String name = scanner.nextLine();

        BankAccount account = new BankAccount(name);

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1️⃣ Deposit");
            System.out.println("2️⃣ Withdraw");
            System.out.println("3️⃣ Check Balance");
            System.out.println("4️⃣ View Account Info");
            System.out.println("5️⃣ View Mini Statement");
            System.out.println("6️⃣ Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.viewAccountInfo();
                    break;
                case 5:
                    account.printMiniStatement();
                    break;
                case 6:
                    System.out.println("👋 Thank you for using our bank. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
