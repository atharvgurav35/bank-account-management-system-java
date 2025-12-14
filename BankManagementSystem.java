package SyntecxhubBankAccountManagement;

import java.util.HashMap;
import java.util.Scanner;

class Account {
	private int accountNumber;
	private String name;
	private double balance;

	public Account(int accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = 0.0;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Amount Deposited Successfully!");
		} else {
			System.out.println("Invalid Amount!");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Amount Withdrawn Successfully!");
		} else {
			System.out.println("Insufficient Balance or Invalid Amount!");
		}
	}

	public void showDetails() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Name: " + name);
		System.out.println("Balance: ₹" + balance);
	}
}

class Bank {
	private HashMap<Integer, Account> accounts = new HashMap<>();

	public void createAccount(int accNo, String name) {
		if (accounts.containsKey(accNo)) {
			System.out.println("Account number already exists!");
		} else {
			accounts.put(accNo, new Account(accNo, name));
			System.out.println("Account Created Successfully!");
		}
	}

	public void depositMoney(int accNo, double amount) {
		Account acc = accounts.get(accNo);
		if (acc != null) {
			acc.deposit(amount);
		} else {
			System.out.println("Account Not Found!");
		}
	}

	public void withdrawMoney(int accNo, double amount) {
		Account acc = accounts.get(accNo);
		if (acc != null) {
			acc.withdraw(amount);
		} else {
			System.out.println("Account Not Found!");
		}
	}

	public void checkBalance(int accNo) {
		Account acc = accounts.get(accNo);
		if (acc != null) {
			System.out.println("Current Balance: ₹" + acc.getBalance());
		} else {
			System.out.println("Account Not Found!");
		}
	}

	public void showAccount(int accNo) {
		Account acc = accounts.get(accNo);
		if (acc != null) {
			acc.showDetails();
		} else {
			System.out.println("Account Not Found!");
		}
	}
}

public class BankManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		int choice;

		while (true) {
			System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Check Balance");
			System.out.println("5. Show Account Details");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter Account Number: ");
				int accNo = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				bank.createAccount(accNo, name);
				break;

			case 2:
				System.out.print("Enter Account Number: ");
				accNo = sc.nextInt();
				System.out.print("Enter Amount to Deposit: ");
				double depositAmount = sc.nextDouble();
				bank.depositMoney(accNo, depositAmount);
				break;

			case 3:
				System.out.print("Enter Account Number: ");
				accNo = sc.nextInt();
				System.out.print("Enter Amount to Withdraw: ");
				double withdrawAmount = sc.nextDouble();
				bank.withdrawMoney(accNo, withdrawAmount);
				break;

			case 4:
				System.out.print("Enter Account Number: ");
				accNo = sc.nextInt();
				bank.checkBalance(accNo);
				break;

			case 5:
				System.out.print("Enter Account Number: ");
				accNo = sc.nextInt();
				bank.showAccount(accNo);
				break;

			case 6:
				System.out.println("Thank you for using the system!");
				System.exit(0);

			default:
				System.out.println("Invalid Option! Try again.");
			}
		}
	}
}
