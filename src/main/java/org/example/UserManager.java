package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class UserManager {

    public void saveUser(User user) {

        try (FileWriter writer = new FileWriter("user_data.txt", true)) {
            writer.write(user.getFirstName() + "," + user.getLastName() + "," + user.getEmail() + "," + user.getPassword() + "\n");
            System.out.println("User add successfully: " + user.getFirstName() + " " + user.getLastName());
        } catch (IOException e) {
            System.out.println("Error saving user data to file: " + e.getMessage());
        }
    }

    public void addUser(Scanner scanner, UserManager userManager) {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        if (firstName.equalsIgnoreCase("QUIT")) {
            System.out.println("Exiting app.");
            System.exit(0);
        }

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email adress: ");
        String email = scanner.nextLine().trim();

        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        User newUser = new User(firstName, lastName, email, password);
        userManager.saveUser(newUser);
    }

    public void showUsers() {
        System.out.println("Users:");

        try (Scanner fileScanner = new Scanner(new File("user_data.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] userData = fileScanner.nextLine().split(",");
                if (userData.length == 4) {
                    String fetchedFirstName = userData[0];
                    String fetchedLastName = userData[1];

                    System.out.println(fetchedFirstName + " " + fetchedLastName);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("User data file not found. Creating a new file.");
        }
    }
}
