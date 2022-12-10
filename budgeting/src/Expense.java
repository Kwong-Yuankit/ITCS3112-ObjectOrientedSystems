public class Expense {
    //Variables
    private String expenseName;
    private double expenseAmount;
    private String expenseCategory;
    private String note;
    private int quantity;

    //Constructor
    public Expense(String expenseName, double expenseAmount, int quantity, String expenseCategory, String note) {
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.quantity = quantity;
        this.expenseCategory = expenseCategory;
        this.note = note;
    }

    //Getters and Setters
    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }


    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }


    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}

