import Inventory.*;
import Inventory.Items.AbstractItem;
import Inventory.Items.GroceryItem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
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
        ItemFactory itemFactory = new ItemFactory();

        GroceryItem item = new GroceryItem("Banana", "Fruit", 2.69, 100);
        GroceryItem item2 = new GroceryItem("Pineapple", "Fruit", 3.89, 100);
        itemProcessor.addItem(item);
        itemProcessor.addItem(item2);

        while (isRunning) {
            try {
                System.out.print("Enter command (1-5): ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        itemProcessor.findAllItems();
                        System.out.println("Please enter item id and quantity, separated by a comma:");
                        System.out.println("Type Exit when you want to exit this command");
                        Order order = new Order();
                        String input = scanner.nextLine();
                        while (!input.equals("Exit")) {
                            int itemId = Integer.parseInt(input);
                            int quantity = Integer.parseInt(scanner.nextLine());
                            itemProcessor.sellQuantity(itemId, quantity);
                            order.addToCart(itemProcessor.getItem(itemId), quantity);
                            input = scanner.nextLine();
                        }
                        order.showOrder();
                        break;
                    case 2:
                        itemProcessor.findAllItems();
                        break;
                    case 3:
                        System.out.println("Please enter the following info, separated by comma:");
                        System.out.println("Product type, name, category, price, quantity:");
                        String tryNewItem = scanner.nextLine();
                        AbstractItem newItem = itemFactory.getInstance(tryNewItem.split(" "));
                        itemProcessor.addItem(newItem);
                        break;
                    case 4:
                        System.out.print("Enter item id: ");
                        itemProcessor.removeItem(scanner.next());
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                        break;
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
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

    private static Object composeAbstractItem(String input) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String[] itemValues = input.split("\\s+");
        Class<?> className = Class.forName(String.format("Inventory.Items.%s",itemValues[0]));
        Constructor<?> constructor = className.getConstructor();
        return constructor.newInstance((Object[]) Arrays.copyOfRange(itemValues, 1, itemValues.length));
    }
}