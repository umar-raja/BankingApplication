package com.bankingApp;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //create accounts in this space
        bankAccount obj1 = new bankAccount("Umar", "UR140900");
        obj1.showMenu();
    }
}

class bankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //constructor class^

    bankAccount(String cusname, String cusid) {
        customerName = cusname;
        customerID = cusid;
        // outlines what to include in the object when a bankAccount object is created
    }

    void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;
        } 
    }

    void withdraw(int amount) {
        if (amount > 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("You have deposited £" + previousTransaction);
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID number is " + customerID);
        //System.out.println("\n");

        do {
            System.out.println("===================");
            System.out.println("What can we do for you today?");
            System.out.println("===================");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transactions");
            System.out.println("E. Log Out");
            System.out.println("===================");
            System.out.println("Enter an option here:");
            option = scanner.next().charAt(0);
            System.out.println("\n");


            switch (option) { //fix all options so that if anything follows the byte (ie a followed by poo or a space an error is returned
                case 'a':
                case 'A':
                    System.out.println("==========");
                    System.out.println("Balance is £" + balance);
                    System.out.println("==========");
                    System.out.println("\n");
                    break;

                case 'B':
                case 'b': // fix so that if anything but an integer is entered, user is prompted to enter an amount
                    System.out.println("==========");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("==========");
                    Scanner amount = new Scanner(System.in);
                    while (!amount.hasNextInt()) {
                        System.out.println("This is not a valid amount to deposit.\n " +
                                "Enter a valid amount:");
                        System.out.println("/n");
                        amount.next();
                    }
                    int x = amount.nextInt();
                    if (x == 0) {
                        System.out.println("This is not a valid  amount to deposit!");
                        System.out.println("\n");
                        break;

                    } else if (x < 0) {
                        System.out.println("This is not a valid  amount to deposit!");
                        System.out.println("\n");
                        break;
                    }
                    deposit(x);
                    System.out.println("You have successfully deposited £" + x);
                    System.out.println("\n");
                    break;

                case 'C':
                case 'c': // fix so that if anything but an integer is entered, user is prompted to enter an amount
                    System.out.println("==========");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("==========");
                    Scanner amount2 = new Scanner(System.in);
                    while (!amount2.hasNextInt()) {
                        System.out.println("This is not a valid amount to withdraw.\n" +
                                "Enter a valid amount:");
                        amount2.next();
                    }
                    int y = amount2.nextInt();
                    if (y == 0) {
                        System.out.println("This is not a valid  amount to withdraw");
                        System.out.println("\n");
                        break;

                    } else if (y < 0) {
                        System.out.println("This is not a valid  amount to withdraw");
                        System.out.println("\n");
                        break;
                    }
                    withdraw(y);
                    System.out.println("You have successfully withdrawn £" + y);
                    System.out.println("\n");
                    break;

                case 'D':
                case 'd':
                    System.out.println("==========");
                    getPreviousTransaction();
                    System.out.println("==========");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("==========");
                    break;

                default:
                    System.out.println("Invalid input!");
                    System.out.println("\n");
                    break;

            }

        }
        while (option != 'E') ;
        System.out.println("Thank you for banking with us. You have been logged out of your account.");
    }

}


