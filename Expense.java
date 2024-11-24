public class Expense {
    private int id;
    private String date;
    private String category;
    private double amount;
    private String description;

    public Expense(int id, String date, String category, double amount, String description) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Date: " + date + ", Category: " + category + ", Amount: " + amount +
                ", Description: " + description;
    }

    public String toFileString() {
        return id + "," + date + "," + category + "," + amount + "," + description;
    }

    public static Expense fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        int id = Integer.parseInt(parts[0]);
        String date = parts[1];
        String category = parts[2];
        double amount = Double.parseDouble(parts[3]);
        String description = parts[4];
        return new Expense(id, date, category, amount, description);
    }
}
