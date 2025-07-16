// Create BankAccount class with:
// - Fields: accountNumber, balance, holderName
// - Methods: deposit(double amount), withdraw(double amount), checkBalance()
// - Take user input for operations and display results

package basics;

import java.util.Scanner;

class BankAccount {
    private String accountNumber, holderName;
    private double balance;

    BankAccount(String holderName, String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.holderName = holderName;
    }

    void deposit(double amount) {
        this.balance += amount;
        System.out.println("Amount of " + amount + " deposited to your account.");
        System.out.println("Current Balance: " + this.balance);
    }

    void withdraw(double amount, Scanner sc) {
        System.out.print("Confirm withdrawal of " + amount + " (Y/N): ");

        char cnf = sc.next().charAt(0);

        switch (cnf) {
            case 'Y':
            case 'y':
                if (amount > this.balance) {
                    System.out.println("Insufficient Balance");
                    return;
                }
                this.balance -= amount;
                System.out.println("Withdrawn Successfully!");
                System.out.println("Current Balance: " + this.balance);
                return;
            default:
                System.out.println("Aborted by User.");
                return;
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + this.balance);
    }

    static BankAccount createNewAccount(Scanner sc) {
        System.out.print("Enter your name:");
        String name = sc.nextLine();
        System.out.print("Enter your generated account number:");
        String accountNumber = sc.nextLine();
        System.out.print("Enter your starting balance:");
        double balance = sc.nextDouble();
        sc.nextLine();
        return new BankAccount(name, accountNumber, balance);
    }

    void display() {
        System.out.println("------------------------");
        System.out.println("Account Holder Name: " + this.holderName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Current Balance: " + this.balance);
        System.out.println("------------------------");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount bk = BankAccount.createNewAccount(sc);

        bk.display();
        bk.deposit(1000);
        bk.checkBalance();
        bk.withdraw(500, sc);
        bk.checkBalance();

        sc.close();
    }

}
