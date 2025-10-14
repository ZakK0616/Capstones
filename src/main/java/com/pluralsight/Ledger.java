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
                    System.out.println("");
                    break;
                case ("D"):
                    System.out.println("");
                    break;
                case ("P"):
                    System.out.println("");
                    break;
                case ("R"):
                    System.out.println("");
                    break;
                case ("H"):
                    viewLedger = false;
                    System.out.println("Exiting goodbye!! \uD83D\uDE34 \uD83D\uDE34 \uD83D\uDE34");
                    break;
                default:


            }


        }
    }
}


