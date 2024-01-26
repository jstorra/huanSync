package com.u2team.huansync.activity;

import com.u2team.huansync.activity.trivia.TriviaManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActivityManagement {
    private static final Scanner SCANNER = new Scanner(System.in);

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
