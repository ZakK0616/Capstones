package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;




public class HomeScreen {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Start the project
        System.out.println("Welcome to your Finance Tracker!");

        //Made a boolean to show the options to pick from
        boolean running = true;

        // Made a loop for the options to pick
        while (running) {
            System.out.println("\n===== HOME SCREEN =====");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case ("D"):
                    addDeposit();
                    break;
                case ("P"):
                    addPayment();
                    break;
                case ("L"):
                    Ledger.openLedger();
                    break;
                case ("X"):
                    running = false;
                    System.out.println("Exiting goodbye!! \uD83D\uDE34 \uD83D\uDE34 \uD83D\uDE34");
                    break;
                default:

            }
        }
    }

    private static void addDeposit() {
        try {
            System.out.println("\n=== Add Deposit ===");
            System.out.println("Enter description: ");
            String description = scanner.nextLine();

            System.out.println("Enter the Vendor Name: ");
            String vendor = scanner.nextLine();

            double amount = 0;
            boolean validAmount = false;

            while (!validAmount) {
                System.out.println("Enter the amount ");
                String input = scanner.nextLine();

                try {
                    amount = Double.parseDouble(input);
                    validAmount = true;
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Please enter numbers only (example: 123.45)");
                }
            }
            LocalDateTime now = LocalDateTime.now();
            String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String cvsFile = date + "|" + time + "|"  + description + "|" + vendor + "|" + amount;

            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(cvsFile + "\n");
            writer.close();
            System.out.println("Deposit saved!");
        } catch (IOException e) {
            System.out.println("Error catching the file");
        }
    }

    private static void addPayment() {
        try {
            System.out.println("Welcome to the payment option");
            System.out.println("Enter the description: ");
            String description = scanner.nextLine();

            System.out.println("Enter the Vendor name: ");
            String vendor = scanner.nextLine();

            double amount = 0;
            boolean validAmount = false;

            while (!validAmount) {
                System.out.println("Enter the payment: ");
                String input = scanner.nextLine();

                try {
                    amount = Double.parseDouble(input);
                    if (amount <= 0) {
                        System.out.println("Please enter a positive number");
                    } else {
                        amount = -Math.abs(amount);
                        validAmount = true;
                    }


                } catch (NumberFormatException e) {
                    System.out.println("Please enter numbers only!");
                }

            }
            LocalDateTime now = LocalDateTime.now();
            String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            String cvsFile = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;

            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(cvsFile + "\n");
            writer.close();
            System.out.println("payment saved!");
        } catch (IOException e) {
            System.out.println("Error catching the file");
        }
    }
}

















