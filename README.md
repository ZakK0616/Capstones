Description for the HomeScreen class

This is a simple command-line Java application that helps users track their financial transactions. Users can add deposits, make payments (debits), and view a ledger of all transactions. All transaction data is saved to a transactions.csv file.

Features:

Add Deposit (D): Record income by entering description, vendor, and amount.

Make Payment (P): Record expenses with description, vendor, and amount (saved as negative).

Ledger (L): View all transactions in a simple table format.

Exit (X): Quit the application safely.

How It Works

Run HomeScreen.java.

Follow the on-screen prompts to choose an action (Deposit, Payment, Ledger, Exit).

Transactions are stored in transactions.csv in the format:



Description for the Ledger

Display All Entries: View all transactions in reverse chronological order.

Show Deposits: Filter only deposits.

Show Payments: Filter only payments.

Reports (R): Generate financial reports:

Month-to-date

Previous month

Year-to-date

Previous year

Search by vendor

Description for Reports

Month-To-Date: Shows all transactions from the current month.

Previous Month: Shows all transactions from the last month.

Year-To-Date: Shows all transactions from the current year.

Previous Year: Shows all transactions from the previous year.

Search by Vendor: Finds all transactions for a specific vendor (case-insensitive).


Description Transaction Management

transactions Class: Represents individual transactions with:

Date

Time

Description

Vendor

Amount

CSV Handling: Transactions are read from and written to transactions.csv using the pipe | as a delimiter.
