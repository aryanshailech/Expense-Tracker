# Expense Tracker - Java Console Application

## Overview
The Expense Tracker is a Java-based console application that helps users manage and track their expenses efficiently. The application allows users to add, view, update, and delete expenses. All expense data is stored persistently in files, so the data is retained even after the application is closed. It provides a clear and organized way to maintain records of daily, monthly, or any other type of expenses, helping users gain better control over their finances.

## Features
- **Add Expense**: Allows the user to input the details of an expense (amount, category, date, and description).
- **View Expenses**: Displays all recorded expenses.
- **Edit Expense**: Enables users to modify an existing expense's details.
- **Delete Expense**: Allows users to remove an expense record from the system.
- **Total Expense Calculation**: Automatically calculates the total of all recorded expenses.
- **Category-based Expense Filtering**: Users can view expenses based on a selected category.
- **Persistent Storage**: All expenses are saved in a file, so they persist between sessions.

## Requirements
- **Java 8 or higher**: The application is built using Java and requires Java version 8 or later to run.
- **JDK**: Java Development Kit (JDK) installed on your system.

## Usage
Upon running the application, the user will be presented with a menu of options to interact with the system.

## Sample Menu:
1. Add Expense
2. View Expenses
3. Edit Expense
4. Delete Expense
5. Total Expenses
6. View Expenses by Category
7. Exit
Example:
To add an expense, select option 1 from the menu. Then input the following details:

- Amount: 50.0
- Category: Food
- Date: 2024-11-22
- Description: Dinner at restaurant
  
To view all expenses, select option 2, and the system will display all saved expenses.

## How It Works
- **Data Persistence:** Expense data is saved to a file, so when the application is closed and reopened, the user’s data is still available.
- **Expense Storage:** Expenses are stored in a simple text file (e.g., expenses.txt), where each line represents an individual expense.
- **File Handling:** The application reads and writes to the expenses.txt file to save and retrieve expense records.
- **User Interaction:** The user interacts with the program through the console. The application provides a simple menu for the user to add, edit, view, and delete expenses.

## Data Storage Format
The expenses are saved in the expenses.txt file in the following format:


Amount, Category, Date, Description

50.0, Food, 2024-11-22, Dinner at restaurant

25.5, Transport, 2024-11-20, Bus fare

Each expense is stored on a new line in the file, and the values are separated by commas.

Example File (expenses.txt):
50.0, Food, 2024-11-22, Dinner at restaurant

25.5, Transport, 2024-11-20, Bus fare

100.0, Entertainment, 2024-11-21, Movie tickets

## Technologies Used
- **Java 21:** Core programming language used for building the application.
- **File I/O:** Java File Input/Output (I/O) is used for reading and writing data to a file (expenses.txt).
- **Console I/O:** Standard input and output for user interaction.
  
## Future Enhancements
- **Data Encryption:** Implement encryption for storing sensitive data (e.g., amounts, dates).
- **Expense Categorization:** Add the ability to categorize expenses for better tracking.
- **Graphical User Interface (GUI):** A future enhancement could include a GUI for a better user experience.
- **Cloud Sync:** Integrate with a cloud service to store expenses remotely and access them across multiple devices.
