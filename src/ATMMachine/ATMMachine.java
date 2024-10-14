// Old Code
//package ATMMachine;
//
//import java.util.Scanner;
//
//class ATM {
//    private float Balance;
//    private int PIN = 2025;
//    private int attempts = 0;  // Count number of wrong attempts
//    private final int maxAttempts = 3;  // Maximum allowed attempts
//
//    public void loadPin() {
//        Scanner scan = new Scanner(System.in);
//
//        while (attempts < maxAttempts) {  // Loop until max attempts reached
//            System.out.println("Enter your PIN: ");
//            int pin = scan.nextInt();
//
//            if (pin == PIN) {
//                System.out.println("PIN is valid");
//                menu();
//                return;  // Exit after successful PIN entry
//            } else {
//                attempts++;
//                System.out.println("Incorrect PIN. Attempts left: " + (maxAttempts - attempts));
//            }
//        }
//        System.out.println("Too many incorrect attempts. Exiting...");
//    }
//
//    public void checkPIN() {
//        loadPin();
//    }
//
//    public void menu() {
//        System.out.println("Welcome to ATMMachine");
//        System.out.println("Please enter your Choice : ");
//        System.out.println("1. Check Balance");
//        System.out.println("2. Withdraw Money");
//        System.out.println("3. Deposit Money");
//        System.out.println("4. Change PIN");
//        System.out.println("5. Exit");
//
//        Scanner scan = new Scanner(System.in);
//        int choice = scan.nextInt();
//        if (choice == 1) {
//            checkBalance();
//        } else if (choice == 2) {
//            withdrawMoney();
//        } else if (choice == 3) {
//            depositMoney();
//        } else if (choice == 4) {
//            changePin();
//        } else if(choice == 5){
//            System.out.println("Exiting...");
//            return;
//        }else {
//            System.out.println("Invalid Choice");
//        }
//    }
//
//    public void checkBalance() {
//        System.out.println("Balance Total : " + Balance);
//        menu();
//    }
//
//    public void withdrawMoney() {
//        System.out.println("Enter your withdraw money : ");
//        Scanner scan = new Scanner(System.in);
//        float amount = scan.nextFloat();
//        if (amount > Balance) {
//            System.out.println("Insufficient Balance");
//        } else {
//            Balance -= amount;
//            System.out.println("Withdraw Successful");
//        }
//        menu();
//    }
//
//    public void depositMoney() {
//        System.out.println("Enter your deposit money : ");
//        Scanner scan = new Scanner(System.in);
//        float amount = scan.nextFloat();
//        Balance += amount;
//        System.out.println("Deposit Successful");
//        menu();
//    }
//
//    public void changePin(){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter your current PIN : ");
//        int pin = scan.nextInt();
//        if(pin == PIN) {
//            System.out.println("Enter your new valid");
//            int newPin = scan.nextInt();
//
//            System.out.println("Enter your confirm PIN : ");
//            int confirmPin = scan.nextInt();
//
//            if(newPin == confirmPin) {
//                PIN = newPin;
//                System.out.println("PIN Changed Successful");
//            }else{
//                System.out.println("New PIN does not match. Try again.");
//            }
//        }else{
//            System.out.println("Invalid Current PIN");
//        }
//        menu();
//    }
//}
//
//public class ATMMachine {
//    public static void main(String[] args) {
//        ATM atm = new ATM();
//        atm.checkPIN();
//    }
//}

// Refactor Code

package ATMMachine;

import java.util.Scanner;

class ATM {
    private float balance;
    private int pin = 2025;
    private int attempts = 0;
    private static final int MAX_ATTEMPTS = 3;

    private final Scanner scanner = new Scanner(System.in);

    // Check PIN with limited attempts
    public void checkPin() {
        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (isPinValid(enteredPin)) {
                System.out.println("PIN is valid");
                displayMenu();
                return;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }
        System.out.println("Too many incorrect attempts. Exiting...");
    }

    // Validate PIN
    private boolean isPinValid(int enteredPin) {
        return enteredPin == pin;
    }

    // Main menu
    private void displayMenu() {
        while (true) {
            System.out.println("Welcome to ATMMachine");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    changePin();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // Display balance
    private void displayBalance() {
        System.out.println("Balance: MMK" + balance);
    }

    // Withdraw money
    private void withdrawMoney() {
        System.out.println("Enter amount to withdraw: ");
        float amount = scanner.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful");
        }
    }

    // Deposit money
    private void depositMoney() {
        System.out.println("Enter amount to deposit: ");
        float amount = scanner.nextFloat();
        balance += amount;
        System.out.println("Deposit Successful");
    }

    // Change PIN
    private void changePin() {
        System.out.println("Enter your current PIN: ");
        int currentPin = scanner.nextInt();

        if (isPinValid(currentPin)) {
            System.out.println("Enter your new PIN: ");
            int newPin = scanner.nextInt();

            System.out.println("Confirm your new PIN: ");
            int confirmPin = scanner.nextInt();

            if (newPin == confirmPin) {
                pin = newPin;
                System.out.println("PIN successfully changed");
            } else {
                System.out.println("New PINs do not match. Try again.");
            }
        } else {
            System.out.println("Invalid current PIN");
        }
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}