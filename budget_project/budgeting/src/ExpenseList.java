import java.util.*;
public class ExpenseList {
    private String userName;
    private double budget;
    private double balance;
    private ArrayList<Expense> expenseList = new ArrayList<Expense>();

    //Constructor


    public ExpenseList(String userName, double budget, double balance) {
        this.userName = userName;
        this.budget = budget;
        this.balance = balance;
    }

    //Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Methods
    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public void removeExpense(String expenseName) {
        if(expenseList.size() == 0) {
            System.out.println("Expense list is empty");
        } else {
            for(int i = 0; i < expenseList.size(); i++) {
                if(expenseList.get(i).getExpenseName().equals(expenseName)) {
                    expenseList.remove(i);
                }
            }
        }
    }

    public int getNumberOfExpenses() {
        int num = 0;
        for(Expense items : expenseList) {
            num += items.getQuantity();
        }
        return num;
    }

    public double getTotalExpenseCost() {
        double total = 0;
        for(Expense items : expenseList) {
            total += items.getExpenseAmount() * items.getQuantity();
        }
        return total;
    }

    public void printTotal() {
        if(expenseList.size() == 0) {
            System.out.println("You currently have no expenses");
        } else {
            System.out.println(userName + "'s Expenses");
            System.out.println("Number of Expenses: " + getNumberOfExpenses());
            //print expense name, quantity, price per item, and total cost
            for(Expense items : expenseList) {
                System.out.println(items.getExpenseName() + " (" + items.getNote() + ") x " + items.getQuantity() + " @ $" + items.getExpenseAmount() + " = $" + (items.getExpenseAmount() * items.getQuantity()));
            }
            System.out.println("----------------------------------------");
            System.out.println("Total Spent: $" + getTotalExpenseCost());
            System.out.println("Remaining Balance: $" + (budget - getTotalExpenseCost()));
        }
    }

    public void printCategoryItems(String categoryName) {
        //create new arraylist to hold expenses in the same category
        ArrayList<Expense> categoryList = new ArrayList<Expense>();
        if(expenseList.size() == 0) {
            System.out.println("You currently have no expenses");
        } else {
            for(Expense items : expenseList) {
                if(items.getExpenseCategory().equals(categoryName)) {
                    categoryList.add(items);
                }
            }
        }
        if(categoryList.size() == 0) {
            System.out.println("You currently have no expenses in this category");
            //save getCategoryNames() call to a variable
            ArrayList<String> listNames = getCategoryNames();
            System.out.println("You have these categories in your expense list: " + listNames);
        } else {
            //print expense name, quantity, price per item, and total cost
            double total = 0;
            for(Expense items : categoryList) {
                System.out.println(items.getExpenseName() + " (" + items.getNote() + ") x " + items.getQuantity() + " @ $" + items.getExpenseAmount() + " = $" + (items.getExpenseAmount() * items.getQuantity()));
                total += (items.getExpenseAmount() * items.getQuantity());

            }
            System.out.println("---------------------------------");
            System.out.println("Total Spent on " + categoryName + ": $" + total);
        }
    }




    public void printPercentageDetails() {
        if(expenseList.size() == 0) {
            System.out.println("You currently have no expenses");
        } else {
            //create new arraylist to hold expenses in the same category
            ArrayList<Expense> categoryList = new ArrayList<Expense>();

            //save getCategoryNames() call to a variable
            ArrayList<String> listNames = getCategoryNames();

            //print total spent, remaining balance, and percentage of budget spent
            System.out.println("Your Budget: $" + budget);
            System.out.println("Total Spent: $" + getTotalExpenseCost());
            System.out.println("Remaining Balance: $" + (budget - getTotalExpenseCost()));
            System.out.println("Percentage of Budget Spent: " + Math.round(getTotalExpenseCost() / budget * 100) + "%");
            System.out.println("");


            for(String items : listNames) { //loop through list of category names
                double total = 0;
                for(Expense items2 : expenseList) { //loop through expense list (items was already used in getCategoryNames())
                    if(items2.getExpenseCategory().equals(items)) { //if the category from expense list matches the category from listNames in current iteration
                        total += (items2.getExpenseAmount() * items2.getQuantity()); // add the cost of the expense category to the running total
                    }
                }
                System.out.println(items + ": $" + total + " (" + Math.round((total/getTotalExpenseCost()) * 100) + "%)");
            }
        }
    }

    //method to return arraylist of category names
    public ArrayList<String> getCategoryNames() {
        ArrayList<String> listCategoryNames = new ArrayList<String>();
        for(Expense items : expenseList) {
            //add all unique category names to listNames
            if(!listCategoryNames.contains(items.getExpenseCategory())) {
                listCategoryNames.add(items.getExpenseCategory());
            }
        }
        return listCategoryNames;
    }


    public void resetProgram() {
        expenseList.clear();
        System.out.println("Expenses Reset");
    }







}//end ExpenseList class
