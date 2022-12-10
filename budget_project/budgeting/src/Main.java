//import utils
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // BUDGETING PROGRAM

        // Declare Variables
        String userName = "";
        double budget = 0;
        double balance = 0;
        String expenseName;
        double expenseAmount;
        String expenseCategory;
        String note;
        int quantity = 0;
        int choice = 0;


        //Create Scanner
        Scanner scan = new Scanner(System.in);

        //Show welcome message
        System.out.println("Welcome to the Budgeting App!");



        //Ask For Username
        System.out.println("Please Enter Your Name:");
        userName = scan.nextLine();

        //Ask For Budget
        System.out.println("Please Enter Your Budget:");
        budget = scan.nextDouble();

        //check if budget is valid number
        while (budget <= 0) {
            System.out.println("Please Enter a Valid Budget:");
            budget = scan.nextDouble();
            balance = budget * 1;
        }

        //Create User
        User user = new User(userName);
        ExpenseList list = new ExpenseList(userName, budget, balance);
        System.out.println("Welcome " + user.getUserName() + "! Your budget is $" + list.getBudget());




        //do while loop to run a switch statement
        try {
            do {
                scan.nextLine();
                //Show Menu
                showMenu();
                //Ask for choice
                System.out.println("Please Enter Your Choice (1-8):");
                choice = scan.nextInt();
                //validate choice
                while (choice < 1 || choice > 8) {
                    System.out.println("Please Enter a Valid Choice (1-8):");
                    choice = scan.nextInt();
                }
                switch(choice) {
                    case 1: //Add Expense
                        scan.nextLine();
                        System.out.println("\t Add New Expense");
                        System.out.println("----------------------------");
                        System.out.println("Enter Expense Name:");
                        expenseName = scan.nextLine();
                        System.out.println("Enter Expense Category:");
                        expenseCategory = scan.nextLine();
                        System.out.println("(optional) Enter Note:");
                        note = scan.nextLine();
                        System.out.println("Enter Expense Cost:");
                        expenseAmount = scan.nextDouble();
                        //validate expense amount
                        while (expenseAmount <= 0) {
                            System.out.println("Cannot have an amount less than 0. Please Enter a Valid Expense Cost:");
                            expenseAmount = scan.nextDouble();
                        }
                        System.out.println("Enter the Number of Times You Made This Expense:");
                        quantity = scan.nextInt();
                        //validate quantity
                        while (quantity <= 0) {
                            System.out.println("Cannot have a quantity less than 0. Please Enter a Valid Quantity:");
                            quantity = scan.nextInt();
                        }


                        //Create Expense
                        Expense expense = new Expense(expenseName, expenseAmount, quantity, expenseCategory, note);

                        //Add Expense to ExpenseList
                        list.addExpense(expense);
                        EnterToContinue();
                        break;
                    case 2: //Remove Expense
                        System.out.println("\t Remove Expense");
                        System.out.println("----------------------------");
                        System.out.println("Enter the expense name you want to remove:");
                        scan.nextLine();
                        String removeName = scan.nextLine();
                        list.removeExpense(removeName);
                        EnterToContinue();
                        break;
                    case 3: //View Expenses
                        System.out.println("\t View Expenses");
                        System.out.println("----------------------------");
                        list.printTotal();
                        EnterToContinue();
                        break;
                    case 4: //View Category
                        System.out.println("\t View Category");
                        System.out.println("----------------------------");
                        System.out.println("Enter the category you want to view:");
                        scan.nextLine();
                        String categoryName = scan.nextLine();
                        list.printCategoryItems(categoryName);
                        EnterToContinue();
                        break;
                    case 5: //Print percentage details
                        System.out.println("\t View Percentage Details");
                        System.out.println("----------------------------");
                        list.printPercentageDetails();
                        EnterToContinue();
                        break;
                    case 6: //Add budget
                        System.out.println("\t Add Budget");
                        System.out.println("----------------------------");
                        System.out.println("Your current budget is: $" + list.getBudget());
                        System.out.println("Enter the amount you want to add to your budget:");
                        double addBudget = scan.nextDouble();
                        //validate addBudget
                        while (addBudget <= 0) {
                            System.out.println("Cannot have an amount less than 0.\nPlease Enter a Valid Amount:");
                            addBudget = scan.nextDouble();
                        }
                        list.setBudget(list.getBudget() + addBudget);
                        System.out.println("Your new budget is $" + list.getBudget());
                        break;
                    case 7: //Reset Program
                        System.out.println("\t Reset Program");
                        System.out.println("----------------------------");
                        System.out.println("Are you sure you want to reset the program? (y/n)");
                        scan.nextLine();
                        String reset = scan.nextLine();
                        if (reset.equalsIgnoreCase("y")) {
                            System.out.println("Resetting Program...");
                            System.out.println("Please Enter Your Name:");
                            userName = scan.nextLine();
                            System.out.println("Please Enter Your Budget:");
                            budget = scan.nextDouble();
                            //check if budget is valid number
                            while (budget <= 0) {
                                System.out.println("Please Enter a Valid Budget:");
                                budget = scan.nextDouble();
                                balance = budget * 1;
                            }
                            //Create User
                            user = new User(userName);
                            list = new ExpenseList(userName, budget, balance);
                            System.out.println("Welcome " + user.getUserName() + "! Your budget is $" + list.getBudget());
                        }
                        EnterToContinue();
                        break;
                    case 8: //Exit Program
                        System.out.println("Thank you for using the Budgeting App!");
                        break;
                    default:
                        break;
                }

            } while (choice != 8);
        } catch(Exception e) {
            System.out.println("Error caught while running menu options. \n" + e);
        }



    } //end main

    public static void showMenu() {
        System.out.println("\nSelect an Option:");
        System.out.println("1. Add Expense");
        System.out.println("2. Remove Expense");
        System.out.println("3. View Expenses");
        System.out.println("4. View Category");
        System.out.println("5. View Details");
        System.out.println("6. Add Budget");
        System.out.println("7. Reset Program");
        System.out.println("8. Exit Program");
    }

    public static void EnterToContinue(){
        System.out.println("Press Enter to Continue...");
        try {
            System.in.read();
        } catch(Exception e) {
            System.out.println("Error caught while running EnterToContinue(). \n" + e);
        }
    }
} //end class