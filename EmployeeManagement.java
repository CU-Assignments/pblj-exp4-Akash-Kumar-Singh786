import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully.");
    }

    public static void updateEmployee(int id, String newName, double newSalary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.name = newName;
                emp.salary = newSalary;
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void removeEmployee(int id) {
        Employee toRemove = null;
        for (Employee emp : employees) {
            if (emp.id == id) {
                toRemove = emp;
                break;
            }
        }
        if (toRemove != null) {
            employees.remove(toRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) { // Handling invalid input
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
            
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int addId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double addSalary = scanner.nextDouble();
                    addEmployee(addId, addName, addSalary);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter New Employee Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter New Employee Salary: ");
                    double updateSalary = scanner.nextDouble();
                    updateEmployee(updateId, updateName, updateSalary);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    removeEmployee(removeId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    searchEmployee(searchId);
                    break;

                case 5:
                    displayEmployees();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
