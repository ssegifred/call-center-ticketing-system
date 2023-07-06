package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean calculating = true;
        System.out.println("*...Welcome to the world of calculations...*");
        while (calculating) {
            System.out.println("Select the operation from the list by entering their corresponding numbers:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Division (/)");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            String select = scanner.nextLine();

            if (select.matches("\\d+")) {
                int choice = Integer.parseInt(select);

                switch (choice) {
                    case 1:
                        doAddition();
                        break;
                    case 2:
                        doSubtract();
                        break;
                    case 3:
                        doDiv();
                        break;
                    case 4:
                        calculating = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Strings are not allowed!\nPlease try again.");
            }
        }

        scanner.close();
    }

    public static void doAddition() {
        System.out.println("Enter the first number:");
        try {
            double num1 = scanner.nextDouble();
            System.out.println("Enter the second number:");
            double num2 = scanner.nextDouble();
            double sum = num1 + num2;
            System.out.println("Result: " + sum);
        } catch (Exception e) {
            System.out.println("Calculations cannot be performed on strings.");
        } finally {
            scanner.nextLine(); // Consume the newline character
        }
    }

    public static void doSubtract() {
        System.out.println("Enter the first number:");
        try {
            double num1 = scanner.nextDouble();
            System.out.println("Enter the second number:");
            double num2 = scanner.nextDouble();
            double sub = num1 - num2;
            System.out.println("Result: " + sub);
        } catch (Exception e) {
            System.out.println("Calculations cannot be performed on strings.");
            System.out.println("\n");
        } finally {
            scanner.nextLine(); // Consume the newline character
        }
    }

    public static void doDiv() {
        System.out.println("Enter the first number:");
        try {
            double num1 = scanner.nextDouble();
            System.out.println("Enter the second number:");
            double num2 = scanner.nextDouble();
            if (num2 != 0) {
                double div = num1 / num2;
                System.out.println("Result: " + div);
                System.out.println("\n");
            } else {
                System.out.println("Cannot divide by zero.");
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.out.println("Calculations cannot be performed on strings.");
            System.out.println("\n");
        } finally {
            scanner.nextLine(); // Consume the newline character
        }
    }
}
