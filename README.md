# Time Keeping System

The Time Keeping System is a Java program that allows employees to clock in and out, record hours worked, and calculate payroll for both hourly and salaried employees.

## Features

- Clock in and clock out functionality.
- Record hours worked for hourly employees.
- Calculate salary for both hourly and salaried employees.
- Print payroll report.

## How to Use

1. Clone the repository to your local machine.
2. Open the project in your preferred Java development environment.
3. Compile and run the `TimeKeepingSystem.java` file.
4. Follow the on-screen instructions to interact with the program.

## Class Structure

The program consists of the following classes:

- `ClockInSystem` (interface): Defines the clock in and clock out methods.
- `Employee` (abstract class): Represents an employee and provides common attributes and methods.
- `HourlyEmployee` (subclass of `Employee`): Represents an hourly employee and calculates their salary based on hours worked and hourly rate.
- `SalariedEmployee` (subclass of `Employee`): Represents a salaried employee and calculates their fixed monthly salary.
- `TimeClock` class: Implements the `ClockInSystem` interface and provides methods for managing employees, recording hours worked, and calculating payroll.
- `TimeKeepingSystem` class: Contains the main method and handles user interaction through a menu system.

## Dependencies

This project does not have any external dependencies.


## Author

[Dorwin Garcia](https://github.com/yourusername)

## Acknowledgements

The Time Keeping System was developed as a sample project for educational purposes.
