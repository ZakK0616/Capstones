package com.pluralsight;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Ledger {
    public static void openLedger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Ledger!!");
        boolean viewLedger = true;
        while (viewLedger){
            System.out.println("A) Display all Entries");
            System.out.println("D) Show all Deposits");
            System.out.println("P) Show all Payments");
            System.out.println("R) Show all Reports");
            System.out.println("H) Go Back to Home Screen");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case ("A"):
                    displayAll(loadTransactions());
                    break;
                case ("D"):
                    displayDeposits(loadTransactions());
                    break;
                case ("P"):
                    displayPayments(loadTransactions());
                    break;
                case ("R"):
                    openReports(scanner, loadTransactions());
                    break;
                case ("H"):
                    viewLedger = false;
                    System.out.println("Exiting goodbye!! \uD83D\uDE34 \uD83D\uDE34 \uD83D\uDE34");
                    break;
                default:
                    System.out.println("Invalid choice...");


            }


        }
    }

    // 🧩 Loads transactions from the CSV file
    private static List<transactions> loadTransactions() {
        List<transactions> list = new ArrayList<>();
        String fileName = "transactions.csv"; // make sure file name matches your save file

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                    transactions t = new transactions(
                            parts[0], // date
                            parts[1], // time
                            parts[2], // description
                            parts[3], // vendor
                            Double.parseDouble(parts[4]) // amount
                    );
                    list.add(t);
                }
            }

            // Show newest first (reverse order)
            Collections.reverse(list);

        } catch (IOException e) {
            System.out.println("⚠️ Error reading transactions file: " + e.getMessage());
        }

        return list;
    }

    // 🧾 A) Display all transactions
    private static void displayAll(List<transactions> list) {
        System.out.println("\n=== All Transactions (Newest First) ===");
        for (transactions t : list) {
            System.out.println(t);
        }
    }

    // 💰 D) Display only deposits (positive amounts)
    private static void displayDeposits(List<transactions> list) {
        System.out.println("\n=== Deposits ===");
        for (transactions t : list) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    // 💸 P) Display only payments (negative amounts)
    private static void displayPayments(List<transactions> list) {
        System.out.println("\n=== Payments ===");
        for (transactions t : list) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }

    // 📊 R) Reports menu
    private static void openReports(Scanner scanner, List<transactions> list) {
        boolean inReports = true;

        while (inReports) {
            System.out.println("\n===== REPORTS MENU =====");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Enter your choice: ");

            String reportChoice = scanner.nextLine().trim();

            switch (reportChoice) {
                case "1":
                    ReportUtils.showMonthToDate(list);
                    break;
                case "2":
                    ReportUtils.showPreviousMonth(list);
                    break;
                case "3":
                    ReportUtils.showYearToDate(list);
                    break;
                case "4":
                    ReportUtils.showPreviousYear(list);
                    break;
                case "5":
                    System.out.print("Enter Vendor Name: ");
                    String vendor = scanner.nextLine();
                    ReportUtils.showByVendor(list, vendor);
                    break;
                case "0":
                    inReports = false;
                    break;
                default:
                    System.out.println("⚠️ Invalid choice, please try again.");
            }
        }
    }
}



