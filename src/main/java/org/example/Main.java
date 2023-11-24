package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        Authentication authentication = new Authentication(userManager, scanner);

        while (true) {
            System.out.println("------------Welcome!-------------");
            System.out.println("To log in, press 1.");
            System.out.println("To register, press 2");
            System.out.println("To display all accounts, press 3");
            System.out.println("To quit, press 4");

            System.out.println("Enter a value: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    authentication.logIn();
                    break;
                case 2:
                    authentication.registerAccount();
                    break;
                case 3:
                    userManager.showUsers();
                    break;
                case 4:
                    System.out.println("Exiting app.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid value.");
            }


        }

    }

}

