package Inventory;

import Inventory.Items.AbstractItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    public Map<AbstractItem, Integer> items;

    public Order() {
        items = new LinkedHashMap<>();
    }

    public void addToCart(AbstractItem item, int quantity) {
        if (items.containsKey(item)) {
            int currentQuantity = items.get(item);
            int newQuantity = currentQuantity + quantity;
            items.put(item, newQuantity);
        } else if (quantity > 0) {
            items.put(item, quantity);
        }
        System.out.printf("Added %d x %s%n", quantity, item.getName());
    }
    public void showOrder() {
        if (orderIsEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Full order:");
            for (Map.Entry<AbstractItem, Integer> entry : items.entrySet()) {
                AbstractItem item = entry.getKey();
                int quantity = entry.getValue();
                System.out.printf("%d x %s = %.2f lv%n", quantity, item.getName(), item.getPrice() * quantity);
            }
            System.out.printf("Total price: %.2f lv.%n", calculateOrderTotal());
        }
    }
    public double calculateOrderTotal() {
        double totalPrice = 0;
        for (Map.Entry<AbstractItem, Integer> entry : items.entrySet()) {
            AbstractItem item = entry.getKey();
            int quantity = entry.getValue();
            double currentItemPrice = item.getPrice() * quantity;
            totalPrice += currentItemPrice;
        }
        return totalPrice;
    }
    private boolean orderIsEmpty() {
        return items.isEmpty();
    }
}