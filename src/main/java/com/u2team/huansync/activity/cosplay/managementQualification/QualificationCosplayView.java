package com.u2team.huansync.activity.cosplay.managementQualification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.u2team.huansync.activity.cosplay.managementQualification.controller.ControllerQualification;
import com.u2team.huansync.activity.cosplay.model.Cosplay;

public class QualificationCosplayView {

    private ControllerQualification controllerQualification = new ControllerQualification();

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("********** Qualifications Cosplay Management **********");
            System.out.println("1. Add Qualification");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addQualifications(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addQualifications(Scanner scanner) {
        System.out.print("\nEnter the cosplay ID to qualify: ");
        int cosplayId = scanner.nextInt();

        int numberCalifications = controllerQualification.numberQualification(cosplayId);

        List<Integer> qualifications = new ArrayList<>();

        for (int i = 0; i < numberCalifications; i++) {
            System.out.print("\nEnter your qualification jury ");
            int qualification = scanner.nextInt();
            qualifications.add(qualification);
        }

        controllerQualification.sendQualification(cosplayId,qualifications);
        
    }

    
}
