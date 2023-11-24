package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
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

        fetchUserData(email, password);
    }

    private void fetchUserData(String email, String password) {

        try (Scanner fileScanner = new Scanner(new File("user_data.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] userData = fileScanner.nextLine().split(",");
                if (userData.length == 4) {
                    String fetchedFirstName = userData[0];
                    String fetchedLastName = userData[1];
                    String fetchedEmail = userData[2];
                    String fetchedPassword = userData[3];

                    if (Objects.equals(email, fetchedEmail) && Objects.equals(password, fetchedPassword)) {
                        System.out.println("Logged in! Welcome " + fetchedFirstName + " " + fetchedLastName);
                        System.exit(0);
                    }
                }
            }

            System.out.println("Email or password is not valid. Please try again.");
            logIn();

        } catch (FileNotFoundException e) {
            System.out.println("User data file not found. Creating a new file.");
        }
    }
}