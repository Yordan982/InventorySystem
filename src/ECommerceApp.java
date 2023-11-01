import Inventory.InventoryManager;
import Inventory.ItemProcessor;
import Inventory.Items.AbstractItem;
import Inventory.Items.ElectronicsItem;
import Inventory.Items.GroceryItem;
import Inventory.PaymentProcessor;

import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        ItemProcessor itemProcessor = new ItemProcessor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the E-commerce Console Application!");
        displayMenu();
        boolean isRunning = true;

        // Below 4 lines are used for testing
        AbstractItem abstractItem = new GroceryItem("Banana", "Fruits", 3.69, 100);
        AbstractItem abstractItem2 = new ElectronicsItem("Fridge", "Kitchen", 899.99, 18);
        itemProcessor.addItem(abstractItem);
        itemProcessor.addItem(abstractItem2);

        while (isRunning) {
            System.out.print("Enter command (1-5): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    inventoryManager.listItems();
                    break;
                case 2:
                    itemProcessor.findAllItems();
                    break;
                case 3:
                    System.out.println("Please enter the following info, separated by comma:");
                    System.out.println("Product type, name, category, price");
                    String tryNewItem = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Enter item id: ");
                    itemProcessor.removeItem(scanner.nextInt());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Create an order");
        System.out.println("2. View all items");
        System.out.println("3. Add an item");
        System.out.println("4. Delete an item");
        System.out.println("5. Categorize an item");
    }
}