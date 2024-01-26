package com.u2team.huansync.activity.cosplay.categorycosplay;

import com.u2team.huansync.activity.cosplay.categorycosplay.controller.CategoryCosplayController;
import com.u2team.huansync.activity.cosplay.categorycosplay.model.CategoryCosplay;

import java.util.List;
import java.util.Scanner;

public class CosplayCategoryView {

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("********** Cosplay Category Management **********");
            System.out.println("1. View All Categories");
            System.out.println("2. Add New Category");
            System.out.println("3. Update Category");
            System.out.println("4. Delete Category");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewAllCategories();
                    break;
                case 2:
                    addNewCategory(scanner);
                    break;
                case 3:
                    updateCategory(scanner);
                    break;
                case 4:
                    deleteCategory(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAllCategories() {
        List<CategoryCosplay> categories = CategoryCosplayController.getAllCategories();
        System.out.println("********** All Categories **********");
        for (CategoryCosplay category : categories) {
            System.out.println("ID: " + category.getCategoryCosplayId() +
                    ", Name: " + category.getNameCategoryCosplay() +
                    ", Deletable: " + category.isDeletable());
        }
        System.out.println();
    }

    private static void addNewCategory(Scanner scanner) {
        System.out.print("Enter the name of the new category: ");
        String categoryName = scanner.nextLine();
        CategoryCosplayController.insertCategory(categoryName);
        System.out.println("Category added successfully.\n");
    }

    private static void updateCategory(Scanner scanner) {
        System.out.print("Enter the ID of the category to update: ");
        long categoryId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the new name for the category: ");
        String newName = scanner.nextLine();

        System.out.print("Do you want to change the deletable status? (Enter 'Y' for Yes, 'N' for No): ");
        String input = scanner.nextLine();

        boolean deletable;
        if (input.equalsIgnoreCase("Y")) {
            deletable = true;
        } else if (input.equalsIgnoreCase("N")) {
            deletable = false;
        } else {
            System.out.println("Invalid input. Assuming 'N' (No).");
            deletable = false;
        }

        CategoryCosplayController.updateCategory(categoryId, newName, deletable);
        System.out.println("Category updated successfully.\n");
    }

    private static void deleteCategory(Scanner scanner) {
        System.out.print("Enter the ID of the category to delete: ");
        long categoryId = scanner.nextLong();
        CategoryCosplayController.deleteCategory(categoryId);
        System.out.println("Category deleted successfully.\n");
    }
}