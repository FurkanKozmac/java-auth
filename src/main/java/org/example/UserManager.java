package org.example;
import java.util.ArrayList;
import  java.util.List;
import java.util.Scanner;

public class UserManager {
    private final List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void saveUser(User user) {
        userList.add(user);
        System.out.println("User add successfully: " + user.getFirstName() + " " + user.getLastName());
    }

    public void addUser(Scanner scanner, UserManager userManager) {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email adress: ");
        String email = scanner.nextLine().trim();

        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        User newUser = new User(firstName, lastName, email, password);

        userManager.saveUser(newUser);

        System.out.println("Account created: " +newUser.getFirstName() + " " + newUser.getLastName());
    }

    public void showUsers() {
        System.out.println("Users:");
        for (User user : userList) {
            System.out.println("First Name: " + user.getFirstName() +
                    ", Last Name: " + user.getLastName() +
                    ", Email: " + user.getEmail());
        }
    }


}
