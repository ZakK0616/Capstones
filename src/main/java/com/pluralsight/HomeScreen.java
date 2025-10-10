package com.pluralsight;

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
                    System.out.println("Deposit: ");
                    break;
                case ("P"):
                    System.out.println("Make a Payment: ");
                    break;
                case ("L"):
                    System.out.println("Open the Ledger Screen: ");
                    break;
                case ("X"):
                    running = false;
                    System.out.println("Exiting goodbye!! \uD83D\uDE34 \uD83D\uDE34 \uD83D\uDE34");
                    break;
                default:

                    }
                }

            }
        }





























//        System.out.print("Enter the deposit date (YYYY-MM-DD): ");
//        String date = scanner.nextLine();
//
//        System.out.print("Enter the time (HH:MM:SS): ");
//        String time = scanner.nextLine();
//
//        System.out.print("Enter a description: ");
//        String description = scanner.nextLine();
//
//        System.out.print("Enter the vendor name: ");
//        String vendor = scanner.nextLine();
//
//        System.out.print("Enter the amount: ");
//        String amount = scanner.nextLine();
//
//        String depositLine = date + "|" + time + "|" + description + "|" + vendor + "|" + amount + "\n";

//        try {
//            FileWriter writer = new FileWriter("transactions.csv", true); // true = append mode
//            writer.write(depositLine);
//            writer.close();
//            System.out.println("Deposit saved successfully!");
//        } catch (IOException e) {
//            System.out.println("An error occurred while saving the deposit.");
//            e.printStackTrace();
//        }




