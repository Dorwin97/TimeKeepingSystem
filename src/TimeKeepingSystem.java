import java.util.*;

interface ClockInSystem {
    void clockIn();
    void clockOut();
}

abstract class Employee {
    private String name;
    private int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String name, int employeeId, double hourlyRate) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(String name, int employeeId, double monthlySalary) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class TimeClock implements ClockInSystem {
    private boolean clockedIn;
    private double totalHoursWorked;
    private List<Employee> employees;

    public TimeClock() {
        clockedIn = false;
        totalHoursWorked = 0.0;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void clockIn() {
        if (clockedIn) {
            System.out.println("You are already clocked in.");
        } else {
            clockedIn = true;
            System.out.println("Clocked in successfully.");
        }
    }

    @Override
    public void clockOut() {
        if (!clockedIn) {
            System.out.println("You are not clocked in.");
        } else {
            clockedIn = false;
            System.out.println("Clocked out successfully.");
        }
    }

    public void recordHoursWorked(double hours) {
        if (clockedIn) {
            totalHoursWorked += hours;
            System.out.println("Recorded " + hours + " hours worked.");
        } else {
            System.out.println("You need to clock in before recording hours worked.");
        }
    }

    public void printPayroll() {
        System.out.println("Payroll:");
        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            System.out.println("Employee: " + employee.getName() +
                    ", Employee ID: " + employee.getEmployeeId() +
                    ", Salary: $" + salary);
        }
    }
}

public class TimeKeepingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeClock timeClock = new TimeClock();

        HourlyEmployee hourlyEmployee = new HourlyEmployee("John Doe", 101, 15.0);
        SalariedEmployee salariedEmployee = new SalariedEmployee("Jane Smith", 102, 4000.0);
        timeClock.addEmployee(hourlyEmployee);
        timeClock.addEmployee(salariedEmployee);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Clock In");
            System.out.println("2. Clock Out");
            System.out.println("3. Record Hours Worked");
            System.out.println("4. Print Payroll");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    timeClock.clockIn();
                    break;
                case 2:
                    timeClock.clockOut();
                    break;
                case 3:
                    System.out.print("Enter hours worked: ");
                    double hours = scanner.nextDouble();
                    timeClock.recordHoursWorked(hours);
                    break;
                case 4:
                    timeClock.printPayroll();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 5);
    }
}
