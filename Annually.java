import java.util.Scanner;

/**
 * The Annually class represents an annual parking pass, extending the Pass class.
 * It calculates the price based on vehicle type and sets the expiry to one year from the input date.
 * Owner : Arjun Gautam
 */
public class Annually extends Pass {
    
    public static Parking_System parking_System;
    public int price;
    public String expiry;

    Annually(Vehicle vehicle) {
        super(vehicle);
        this.price = price(parking_System.type);
        this.expiry = calculateExpiry(); // Calculate expiry for 1 year
    }

    public int price(String type) {
        switch (type) {
            case "cycle":
                return 500;
            case "bike":
                return 2000;
            case "car":
                return 5000;
            default:
                return 0;
        }
    }

    // Method to take date and time input step by step and calculate expiry
    public String calculateExpiry() {
        Scanner scanner = new Scanner(System.in);

        // Taking date and time input step by step
        int day = getInput("Enter the day (1-31): ", 1, 31, scanner);
        int month = getInput("Enter the month (1-12): ", 1, 12, scanner);
        int year = getInput("Enter the year (e.g., 2024): ", 1900, 2100, scanner);
        int hour = getInput("Enter the hour (0-23): ", 0, 23, scanner);
        int minute = getInput("Enter the minute (0-59): ", 0, 59, scanner);

        // Add 1 year for annually expiry
        year += 1;

        // Manually construct the expiry date string without using String.format
        String expiryDate = day + "-" + month + "-" + year + " " + hour + ":" + minute;
        return expiryDate;
    }

    // Helper method to get validated input from the user
    private int getInput(String prompt, int min, int max, Scanner scanner) {
        int input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextInt();
            if (input >= min && input <= max) {
                return input;
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
    }

    public String getExpiry() {
        return expiry;
    }

    public int getPrice() {
        return price; 
    }
}