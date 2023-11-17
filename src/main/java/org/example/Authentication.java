package org.example;

import java.util.Scanner;

public class Authentication {
    private final UserManager userManager;
    private final Scanner scanner;

    public Authentication(UserManager userManager, Scanner scanner) {
        this.userManager = userManager;
        this.scanner = scanner;
    }

    public void registerAccount() {
        userManager.addUser(scanner, userManager);
    }

    public void logIn() {
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();

        if (email.equalsIgnoreCase("QUIT")) {
            System.out.println("Exiting app.");
            System.exit(0);
        }

            User loggedInUser = findUserByEmailAndPassword(email, password);

            if (loggedInUser != null) {
                System.out.println("Login successful!");
                System.out.println("Welcome " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
                System.exit(0);
            } else {
                System.out.println("Email or password is not valid.");
                logIn();
            }

        }
    private User findUserByEmailAndPassword(String email, String password) {
        for (User user : userManager.getUserList()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
