import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add New Item");
            System.out.println("2. Update Item");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");

            int choice = getIntInput("Choose an option: ");
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItem();
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem() {
        try {
            String name = getStringInput("Enter item name: ");
            int quantity = getIntInput("Enter item quantity: ");
            double price = getDoubleInput("Enter item price: ");
            Item item = new Item(name, quantity, price);
            inventory.addItem(item);
            System.out.println("Item added successfully.");
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    private static void updateItem() {
        try {
            String name = getStringInput("Enter item name to update: ");
            int quantity = getIntInput("Enter new quantity: ");
            double price = getDoubleInput("Enter new price: ");
            inventory.updateItem(name, quantity, price);
            System.out.println("Item updated successfully.");
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    private static void displayInventory() {
        inventory.displayInventory();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                ExceptionHandler.handleInputMismatchException(e);
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                ExceptionHandler.handleInputMismatchException(e);
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
