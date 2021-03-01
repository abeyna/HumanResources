package human.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Main Class
 * 
 * @author Luan N Nguyen
 * @since February 07th, 2021
 * @version 1.0
 */
public class HummanResources {
    public static Scanner sc;

    /** Array for staff list */
    public static ArrayList<Staff> staffList = new ArrayList<>();

    /** Array for department list */
    public static ArrayList<Department> departmentsList = new ArrayList<>();

    /**
     * 
     * Main method to run program
     */
    public static void main(String[] args) {
        // Create variable to store user choice in 8 options
        int userChoice;
        sc = new Scanner(System.in);

        departments();

        do {
            menu();
            userChoice = InputHelper.inputVal(sc, 1, 8);
            switch (userChoice) {
            case 1:
                dpStaff();
                break;
            case 2:
                dpDepartment();
                break;
            case 3:
                dpStaffByDepartment();
                break;
            case 4:
                add();
                break;
            case 5:
                search();
                break;
            case 6:
                dpPayroll();
                break;
            case 7:
                dpPayrollSort();
                break;
            case 8:
            default:
                exit();
                break;
            }
        } while (userChoice != 8);

        sc.close();
    }

    /**
     * Display the introducing of program include options
     */
    public static void menu() {
        System.out.println("=============== EMPLOYEE MANAGEMENT ==============");
        System.out.println("Enter the number you want to execute [1 - 8]: ");
        System.out.println("1. Employees list");
        System.out.println("2. Department list");
        System.out.println("3. Employees list by department");
        System.out.println("4. New staff");
        System.out.println("5. Searching");
        System.out.println("6. Payroll");
        System.out.println("7. Payroll sort by increment");
        System.out.println("8. Exit.");
        System.out.print("Your choice: ");
    }

    /**
     * Declare some departments
     */
    public static void departments() {
        // Declare department objects with ID, name of department and staffs amount in each.
        Department devDepartment = new Department(1, "Development", 0);
        Department bussDepartment = new Department(2, "Business", 0);
        Department marDepartment = new Department(3, "Marketing", 0);
        Department hrDepartment = new Department(4, "HR", 0);

        // Add department object to departmentList
        departmentsList.add(0, devDepartment);
        departmentsList.add(1, bussDepartment);
        departmentsList.add(2, marDepartment);
        departmentsList.add(3, hrDepartment);
    }

    /**
     * Option 1: Display staff list
     */
    public static void dpStaff() {
        System.out.println("STAFF List:");
        System.out.println(String.format("%-10s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s", "ID", "NAME", "Age",
                "Coefficients salary", "DATE START WORK", "DEPARTMENT", "Days-off (d)", "JOB TITLE", "Over Time (h)"));
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Staff staff : staffList) {
            System.out.println(staff.toString());
        }
        System.out.println("*****************************************************");
        System.out.println();
    }

    /**
     * Option 2: Display departments
     */
    public static void dpDepartment() {
        System.out.println(String.format("%-10s%-20s%-20s", "ID", "DEPARTMENT", "Amount Staff"));
        for (Department department : departmentsList) {
            System.out.println(department.toString());
        }
    }

    /**
     * Option 3: Display staff base on their department
     */
    public static void dpStaffByDepartment() {
        System.out.println(String.format("%-10s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s", "ID", "NAME", "Age",
                "Coefficients salary", "DATE START WORK", "DEPARTMENT", "Days-off (d)", "JOB TITLE", "Over Time (h)"));
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("DEVELOPMENT Team:");
        for (Staff staff : staffList) {
            if (staff.getDepartment().equals(departmentsList.get(0).getDpmName()))
                System.out.println(staff.toString());
        }
        System.out.println();

        System.out.println("BUSSINESS Team:");
        for (Staff staff : staffList) {
            if (staff.getDepartment().equals(departmentsList.get(1).getDpmName()))
                System.out.println(staff.toString());
        }
        System.out.println();

        System.out.println("MARKETING Team:");
        for (Staff staff : staffList) {
            if (staff.getDepartment().equals(departmentsList.get(2).getDpmName()))
                System.out.println(staff.toString());
        }
        System.out.println();

        System.out.println("HR Team:");
        for (Staff staff : staffList) {
            if (staff.getDepartment().equals(departmentsList.get(3).getDpmName()))
                System.out.println(staff.toString());
        }
        System.out.println("*****************************************************");
        System.out.println();
    }

    /**
     * Option 4: Create new staff
     */
    public static void add() {
        // Create variable stores staff's department after user choice
        String department;

        // Create variable and check it true if the ID was exist in list
        boolean checkID = true;

        System.out.println("Enter information for the new employee:");

        System.out.print("- ID: ");

        // Add staff's ID
        String id = sc.nextLine();

        do {
            for (int i = 0; i < staffList.size(); i++) {
                if (staffList.get(i).getId().contains(id)) {
                    System.out.println("This ID has been used before - Try again!");
                    checkID = false;
                    System.out.print("ID: ");
                    id = sc.nextLine();
                    break;
                } else {
                    checkID = true;
                }
            }
        } while (!checkID);

        System.out.print("- Name: ");

        // Add staff's name
        String name = sc.nextLine();

        System.out.print("- Age [from 18 to 65]: ");

        // Add staff's age
        int age = InputHelper.inputVal(sc, 18, 65);

        System.out.print("- Coefficients salary [from 1 to 10]: ");

        // Add staff's coefficients salary from 1 to 10
        int coefficients = InputHelper.inputVal(sc, 1, 10);

        System.out.print("- Date start work: ");

        // Add date when he/she start to work
        String dateStart = sc.nextLine();

        System.out.println("- Department:");
        System.out.print(
                String.format("%-20s%-20s%-20s%-10s : ", "[1] Development", "[2] Business", "[3] Marketing", "[4] HR"));

        // Create variable store user's choice for department
        int depChoice = InputHelper.inputVal(sc, 1, 4);

        switch (depChoice) {
        // Development
        case 1:
            department = departmentsList.get(0).getDpmName();
            departmentsList.get(0).getStaffsAmount();
            break;

        // Business
        case 2:
            department = departmentsList.get(1).getDpmName();
            departmentsList.get(1).getStaffsAmount();
            break;

        // Marketing
        case 3:
            department = departmentsList.get(2).getDpmName();
            departmentsList.get(2).getStaffsAmount();
            break;

        // HR
        case 4:
        default:
            department = departmentsList.get(3).getDpmName();
            departmentsList.get(3).getStaffsAmount();
            break;
        }

        System.out.print("- Number of days off: ");

        // Add the number of days-off
        int daysOff = InputHelper.inputVal(sc, 0, 30);

        System.out.print("- Manager [1] / Employee [2] : ");

        // Allow user type "1" if he/she is the manager or "2" in the opposite way
        int choiceAdd = InputHelper.inputVal(sc, 1, 2);

        switch (choiceAdd) {
        // Adding manager to list
        case 1:
            System.out.println("- Job Title: ");
            System.out.print(String.format("%-30s%-30s%-30s : ", "[1] Business Leader", "[2] Technical Leader",
                    "[3] Project Leader"));

            // Create variable to store user's choice for job title
            int title = InputHelper.inputVal(sc, 1, 3);

            // Choosing job title base on user's choice before
            String jobTitle;

            switch (title) {
            // Business Leader
            case 1:
                jobTitle = "Business Leader";
                break;

            // Technical Leader
            case 2:
                jobTitle = "Technical Leader";
                break;

            // Project Leader
            case 3:
            default:
                jobTitle = "Project Leader";
                break;
            }

            // Create manager object with its parameters
            Manager manager = new Manager(id, name, age, coefficients, dateStart, department, daysOff, jobTitle);

            staffList.add(manager);

            System.out.println("A new manager has been added to list!");
            System.out.println("*****************************************************");
            System.out.println();
            break;

        // Adding employee to list
        case 2:
        default:
            System.out.print("- Number of overtime hours: ");

            // Add the number of over-time hours which this employee has worked
            int extraHours = InputHelper.inputVal(sc, 0, 100);

            // Create employee object with its parameters
            Employee employee = new Employee(id, name, age, coefficients, dateStart, department, daysOff, extraHours);

            staffList.add(employee);

            System.out.println("A new employee has been added to list!");
            System.out.println("*****************************************************");
            System.out.println();
            break;
        }
    }

    /**
     * Option 5: Searching for a staff by ID or name
     */
    public static void search() {
        // Create an array stores results of searching
        ArrayList<Staff> staffsSearch = new ArrayList<>();

        // Create variable store user's keyboard type
        String searchKey;

        System.out.print("By ID [1] / Name [2] :");

        // Create variable store user's choice to search by ID or name
        int searchOption = InputHelper.inputVal(sc, 1, 2);

        switch (searchOption) {
        // Search by ID
        case 1:
            System.out.println("Enter staff's ID to search.");
            System.out.print("ID: ");
            searchKey = sc.nextLine();
            for (Staff staff : staffList) {
                // If the ID that user type is contain the ID of any staff, import that staff to the staffsSearch array
                if (staff.getId().toLowerCase().contains(searchKey.toLowerCase())) {
                    staffsSearch.add(staff);
                }
            }
            if (staffsSearch.isEmpty()) {
                System.out.println("This ID does not exist!");
            } else {
                System.out.println(String.format("%-10s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s", "ID", "NAME", "Age",
                        "Coefficients salary", "DATE START WORK", "DEPARTMENT", "Days-off (d)", "JOB TITLE",
                        "Over Time (h)"));
                // Using loop to print result from staff searching list
                for (Staff staff : staffsSearch) {
                    System.out.println(staff.toString());
                }
            }
            break;

        // Search by name
        case 2:
        default:
            System.out.println("Enter staff's name to search.");
            System.out.print("Name: ");
            searchKey = sc.nextLine();
            for (Staff staff : staffList) {
                // If the name that user type is contain the name of any staff, import that staff to the staffsSearch array
                if (staff.getName().toLowerCase().contains(searchKey.toLowerCase())) {
                    staffsSearch.add(staff);
                }
            }
            if (staffsSearch.isEmpty()) {
                System.out.println("This name does not exist!");
            } else {
                System.out.println(String.format("%-10s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s", "ID", "NAME", "Age",
                        "Coefficients salary", "DATE START WORK", "DEPARTMENT", "Days-off (d)", "JOB TITLE",
                        "Over Time (h)"));
                // Using loop to print result from staff searching list
                for (Staff staff : staffsSearch) {
                    System.out.println(staff.toString());
                }
            }
            break;
        }

        System.out.println("*****************************************************");
        System.out.println();
    }

    /**
     * Option 6: Display payroll of all staff from the top down
     */
    @SuppressWarnings("unchecked")
    public static void dpPayroll() {
        // Create an array to copy all object from the staffList
        ArrayList<Staff> payRollList = new ArrayList<>();
        payRollList = (ArrayList<Staff>) staffList.clone();

        System.out.println(String.format("%-10s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s%-10s", "ID", "NAME", "Age",
                "Coefficients salary", "DATE START WORK", "DEPARTMENT", "Days-off (d)", "JOB TITLE", "Over Time (h)",
                "Salary (VND)"));
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Create variable to store the value of the method calculateSalary of one specific staff in array
        int staffWage = 0;

        // Create variable to store the value of the method calculateSalary of the next staff in array for comparison
        int compareTo = 0;

        for (int i = 0; i < payRollList.size() - 1; i++) {
            for (int j = i + 1; j < payRollList.size(); j++) {
                if (payRollList.get(i) instanceof Manager) {
                    staffWage = ((Manager) payRollList.get(i)).calculateSalary();
                } else if (payRollList.get(i) instanceof Employee) {
                    staffWage = ((Employee) payRollList.get(i)).calculateSalary();
                }
                if (payRollList.get(j) instanceof Manager) {
                    compareTo = ((Manager) payRollList.get(j)).calculateSalary();
                } else if (payRollList.get(j) instanceof Employee) {
                    compareTo = ((Employee) payRollList.get(j)).calculateSalary();
                }
                if (staffWage < compareTo) {
                    Collections.swap(payRollList, i, j);
                }
            }
        }

        for (Staff staff : payRollList) {
            System.out.print(staff.toString());
            if (staff instanceof Manager) {
                System.out.println(((Manager) staff).calculateSalary());
            } else if (staff instanceof Employee) {
                System.out.println(((Employee) staff).calculateSalary());
            }
        }
        System.out.println("*****************************************************");
        System.out.println();
    }

    /**
     * Option 7: Display payroll of all staff from the grow up
     */
    @SuppressWarnings("unchecked")
    public static void dpPayrollSort() {
        // Create an array to copy all object from the staffList
        ArrayList<Staff> payRollList = new ArrayList<>();
        payRollList = (ArrayList<Staff>) staffList.clone();

        System.out.println(String.format("%-10s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s%-10s", "ID", "NAME", "Age",
                "Coefficients salary", "DATE START WORK", "DEPARTMENT", "Days-off (d)", "JOB TITLE", "Over Time (h)",
                "Salary (VND)"));
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Create variable to store the value of the method calculateSalary of one specific staff in array
        double staffWage = 0;

        // Create variable to store the value of the method calculateSalary of the next staff in array for comparison
        double compareTo = 0;

        for (int i = 0; i < payRollList.size() - 1; i++) {
            for (int j = i + 1; j < payRollList.size(); j++) {
                if (payRollList.get(i) instanceof Manager) {
                    staffWage = ((Manager) payRollList.get(i)).calculateSalary();
                } else if (payRollList.get(i) instanceof Employee) {
                    staffWage = ((Employee) payRollList.get(i)).calculateSalary();
                }
                if (payRollList.get(j) instanceof Manager) {
                    compareTo = ((Manager) payRollList.get(j)).calculateSalary();
                } else if (payRollList.get(j) instanceof Employee) {
                    compareTo = ((Employee) payRollList.get(j)).calculateSalary();
                }
                if (staffWage > compareTo) {
                    Collections.swap(payRollList, i, j);
                }
            }
        }

        for (Staff staff : payRollList) {
            System.out.print(staff.toString());
            if (staff instanceof Manager) {
                System.out.println(((Manager) staff).calculateSalary());
            } else if (staff instanceof Employee) {
                System.out.println(((Employee) staff).calculateSalary());
            }
        }
        System.out.println("*****************************************************");
        System.out.println();
    }

    /**
     * Option 8: Exit program
     */
    public static void exit() {
        System.out.println("----------------------- END -----------------------");
        System.exit(0);
    }
}
