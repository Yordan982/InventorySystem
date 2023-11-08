import Inventory.*;
import Inventory.Items.AbstractItem;
import Inventory.Utils.JsonUtil;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) throws IOException {
        InventoryManager inventoryManager = new InventoryManager();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        ItemProcessor itemProcessor = new ItemProcessor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the E-commerce Console Application!");
        displayMenu();
        boolean isRunning = true;
        ItemFactory itemFactory = new ItemFactory();
        JsonUtil jsonUtil = new JsonUtil();
        AbstractItem[] items = jsonUtil.read();
        itemProcessor.fillInventory(items);
        Order order = new Order();

        while (isRunning) {
            try {
                System.out.print("Enter command (1-6): ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        itemProcessor.findAllItems();
                        System.out.println("Please enter item id and quantity, each on a new line:");
                        System.out.println("Type Exit when you want to exit this command");
                        String input = scanner.nextLine();
                        while (!input.equalsIgnoreCase("exit")) {
                            int itemId = Integer.parseInt(input);
                            int quantity = Integer.parseInt(scanner.nextLine());
                            int soldQuantity = itemProcessor.sellQuantity(itemId, quantity);
                            order.addToCart(itemProcessor.getItem(itemId), soldQuantity);
                            input = scanner.nextLine();
                        }
                        order.showOrder();
                        order.calculateOrderTotal();
                        isRunning = false;
                        break;
                    case 2:
                        itemProcessor.findAllItems();
                        break;
                    case 3:
                        System.out.println("Please enter the following info, separated by a space:");
                        System.out.println("Product type, name, category, price, quantity:");
                        String tryNewItem = scanner.nextLine();
                        AbstractItem newItem = itemFactory.getInstance(tryNewItem.split("\\s+"));
                        itemProcessor.addItem(newItem);
                        System.out.println("Successfully registered item.");
                        break;
                    case 4:
                        System.out.print("Enter item id: ");
                        itemProcessor.removeItem(scanner.nextLine());
                        break;
                    case 5:
                        itemProcessor.categorizedItems();
                        break;
                    case 6:
                        System.out.println("All data is now saved.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                        break;
                }
            } catch (Exception exception) {
                System.out.println("Invalid input. Choose an option from the menu.");
            }
        }
        itemProcessor.writeInventory();
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Create an order");
        System.out.println("2. View all items");
        System.out.println("3. Add an item");
        System.out.println("4. Delete an item");
        System.out.println("5. Categorize items");
        System.out.println("6. Exit and save data");
    }

    private static Object composeAbstractItem(String input) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String[] itemValues = input.split("\\s+");
        Class<?> className = Class.forName(String.format("Inventory.Items.%s",itemValues[0]));
        Constructor<?> constructor = className.getConstructor();
        return constructor.newInstance((Object[]) Arrays.copyOfRange(itemValues, 1, itemValues.length));
    }
}