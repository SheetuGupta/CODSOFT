import java.util.Scanner;

class BankAccount {
    int balance = 10000;

    void deposit(int amount) {
        balance += amount;
        System.out.println("Amount Deposited: ₹" + amount);
    }

    void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawn: ₹" + amount);
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        while (true) {
            System.out.println(" ATM Menu ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                account.checkBalance();
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ₹");
                int amount = sc.nextInt();
                account.deposit(amount);
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ₹");
                int amount = sc.nextInt();
                account.withdraw(amount);
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
