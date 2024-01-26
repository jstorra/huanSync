/**
 * The `ActivityManagement` class provides a console-based user interface for managing different types of activities.
 * Users can choose to manage Cosplay or Trivia activities through a menu-driven interface.
 */
package com.u2team.huansync.activity;

import com.u2team.huansync.activity.trivia.TriviaManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActivityManagement {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Initializes the activity management application and provides a menu for users to choose the type of activity to manage.
     */
    public static void initApp() {
        while (true) {
            System.out.println("""
                
                ------------ MANAGE ACTIVITIES ------------
                
                Choose the activity to manage:
                1. Cosplay
                2. Trivia
                3. Exit
                """);
            System.out.print("Option: ");
            try {
                int option = SCANNER.nextInt();
                SCANNER.nextLine();

                if (option == 3) {
                    System.out.println("\nLeaving out...");
                    break;
                } else if (option == 1) {
                    // Implement Cosplay management functionality here
                } else if (option == 2) {
                    TriviaManagement.initAppTrivia();
                } else {
                    throw new Exception("\nError: The option entered is not valid.");
                }
            } catch (InputMismatchException e) {
                SCANNER.nextLine();
                System.out.println("\nError: The character entered is not valid.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
