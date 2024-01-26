package com.u2team.huansync.activity.cosplay;

import java.util.List;
import java.util.Scanner;

import com.u2team.huansync.activity.cosplay.Controller.ControllerMagnamentCosplay;
import com.u2team.huansync.activity.cosplay.model.Cosplay;

public class cosplayView {

    private ControllerMagnamentCosplay controllerCosplay = new ControllerMagnamentCosplay();

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("********** Cosplay Management **********");
            System.out.println("1. View All cosplays");
            System.out.println("2. Add New Cosplay");
            System.out.println("3. Update Casplay");
            System.out.println("4. Delete Casplay");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewAllCosplays(scanner);
                    break;
                case 2:
                    addNewCosplay(scanner);
                    break;
                case 3:
                    updateCosplay(scanner);
                    break;
                case 4:
                    deleteCosplay(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAllCosplays(Scanner scanner) {
        System.out.print("\nEnter the ID of the cosplay contest you want to list : ");
        int idActivitieCosplay = scanner.nextInt();
        System.out.println("********** All Cosplay **********");

        List<Cosplay> cosplays = controllerCosplay.readAllCosplays(idActivitieCosplay);
        for (Cosplay i : cosplays) {
            System.out.println(i.toString());
        }
        System.out.println();
    }

    private void addNewCosplay(Scanner scanner) {
        System.out.print("\nEnter the name of the cosplay: ");
        String nombreCosplay = scanner.nextLine();
    
        System.out.print("\nEnter the participant ID: ");
        int idParticipant = scanner.nextInt();

        System.out.print("\nEnter the ID of the activity: ");
        int idActivicty = scanner.nextInt();

        controllerCosplay.addCosplay(nombreCosplay, idParticipant, idActivicty);

        System.out.println("Cosplay added successfully.\n");
    }
    

    private void updateCosplay(Scanner scanner) {
        System.out.print("\nEnter the ID of the cosplay to modify : ");
        int idParticipant = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nEnter the new cosplay name : ");
        String nombreCosplay = scanner.nextLine();

        controllerCosplay.updateCosplay(idParticipant, nombreCosplay);
        // Llamas al método correspondiente en tu controlador aquí
        // Por ejemplo: controllerCosplay.updateCosplay(cosplayId, newCosplayName);
        System.out.println("Cosplay updated successfully.\n");
    }

    private void deleteCosplay(Scanner scanner) {
        System.out.print("\nEnter the ID of the cosplay to be removed : ");
        int idCosplay = scanner.nextInt();
        
        controllerCosplay.deleteCosplay(idCosplay);
        System.out.println("Cosplay deleted successfully.\n");
    }

    
}
