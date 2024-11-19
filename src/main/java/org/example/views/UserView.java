package org.example.views;

import org.example.controller.UserController;
import org.example.enums.Role;

import java.util.Scanner;

public class UserView {

    private static final Scanner scanner = new Scanner(System.in);

    private final UserController userController;

    // Constructor to initialize UserController
    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n=== Welcome to the User System ===");
            System.out.println("1. Register as a new user");
            System.out.println("2. Log in");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerUser() {
        System.out.println("\n--- Register User ---");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.println("Select your role:");
        System.out.println("1. Volunteer");
        System.out.println("2. Publisher");
        System.out.print("Enter your choice: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Role role = null;
        if (roleChoice == 1) {
            role = Role.VOLUNTEER;
        } else if (roleChoice == 2) {
            role = Role.PUBLISHER;
        } else {
            System.out.println("Invalid role. Registration failed.");
            return;
        }

        // Call the controller to add the user
        try {
            userController.addUser(name, email, password, role);
            System.out.println("User registered successfully!");
        } catch (Exception e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
    }

    private void loginUser() {
        System.out.println("\n--- Log In ---");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Simulate login validation (add real logic in the controller or DAO)
        System.out.println("Login successful! Welcome, " + email);
    }

}
