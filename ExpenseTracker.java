import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExpenseTracker {
    private static final String FILE_NAME = "expenses.txt";
    private static List<Expense> expenses = new ArrayList<>();
    private static int expenseIdCounter = 1;

    public static void main(String[] args) {
        loadExpensesFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Personal Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Search Expense by ID");
            System.out.println("5. Calculate Total Expenses");
            System.out.println("6. Show Month-Wise Expenses");
            System.out.println("7. Save and Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addExpense(scanner);
                case 2 -> viewAllExpenses();
                case 3 -> deleteExpense(scanner);
                case 4 -> searchExpenseById(scanner);
                case 5 -> calculateTotalExpenses();
                case 6 -> showMonthWiseExpenses();
                case 7 -> {
                    saveExpensesToFile();
                    System.out.println("Exiting... Thank you!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Expense expense = new Expense(expenseIdCounter++, date, category, amount, description);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    private static void viewAllExpenses() {
        System.out.println("\n--- All Expenses ---");
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private static void deleteExpense(Scanner scanner) {
        System.out.print("Enter the ID of the expense to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean removed = expenses.removeIf(expense -> expense.getId() == id);
        if (removed) {
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Expense not found.");
        }
    }

    private static void searchExpenseById(Scanner scanner) {
        System.out.print("Enter the ID of the expense to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                System.out.println("Expense Found: " + expense);
                return;
            }
        }
        System.out.println("Expense with ID " + id + " not found.");
    }

    private static void calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total Expenses: " + total);
    }

    private static void showMonthWiseExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        Map<String, Double> monthWiseExpenses = new TreeMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        for (Expense expense : expenses) {
            LocalDate date = LocalDate.parse(expense.getDate());
            String month = date.format(formatter);

            monthWiseExpenses.put(month, monthWiseExpenses.getOrDefault(month, 0.0) + expense.getAmount());
        }

        System.out.println("\n--- Month-Wise Expenses ---");
        for (Map.Entry<String, Double> entry : monthWiseExpenses.entrySet()) {
            System.out.printf("Month: %s | Total Expense: %.2f\n", entry.getKey(), entry.getValue());
        }
    }

    private static void saveExpensesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense expense : expenses) {
                writer.write(expense.toFileString());
                writer.newLine();
            }
            System.out.println("Expenses saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    private static void loadExpensesFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No previous data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Expense expense = Expense.fromFileString(line);
                expenses.add(expense);
                expenseIdCounter = Math.max(expenseIdCounter, expense.getId() + 1);
            }
            System.out.println("Expenses loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }
}
