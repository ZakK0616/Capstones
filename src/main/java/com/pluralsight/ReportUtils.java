package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportUtils {

    // Format your transaction date string (e.g. "2025-10-14")
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 🗓️ 1) Month To Date
    public static void showMonthToDate(List<transactions> transactions) {
        LocalDate now = LocalDate.now();
        System.out.println("\n=== Month To Date ===");
        for (transactions t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMAT);
            if (date.getYear() == now.getYear() && date.getMonth() == now.getMonth()) {
                System.out.println(t);

            }
        }
    }

    // 🗓️ 2) Previous Month
    public static void showPreviousMonth(List<transactions> transactions) {
        LocalDate now = LocalDate.now();
        LocalDate prevMonth = now.minusMonths(1);
        System.out.println("\n=== Previous Month ===");
        for (transactions t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMAT);
            if (date.getYear() == prevMonth.getYear() && date.getMonth() == prevMonth.getMonth()) {
                System.out.println(t);
            }
        }
    }

    // 🗓️ 3) Year To Date
    public static void showYearToDate(List<transactions> transactions) {
        LocalDate now = LocalDate.now();
        System.out.println("\n=== Year To Date ===");
        for (transactions t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMAT);
            if (date.getYear() == now.getYear()) {
                System.out.println(t);
            }
        }
    }

    // 🗓️ 4) Previous Year
    public static void showPreviousYear(List<transactions> transactions) {
        LocalDate now = LocalDate.now();
        int prevYear = now.getYear() - 1;
        System.out.println("\n=== Previous Year ===");
        for (transactions t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMAT);
            if (date.getYear() == prevYear) {
                System.out.println(t);
            }
        }
    }

    // 🔍 5) Search by Vendor
    public static void showByVendor(List<transactions> transactions, String vendorName) {
        System.out.println("\n=== Transactions for Vendor: " + vendorName + " ===");
        for (transactions t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendorName.trim())) {
                System.out.println(t);
            }
        }
    }
}


