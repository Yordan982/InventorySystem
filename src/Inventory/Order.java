package Inventory;

import Inventory.Items.AbstractItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    public Map<AbstractItem, Integer> items;

    public Order() {
        items = new LinkedHashMap<>();
    }

    public Map<AbstractItem, Integer> getItems() {
        return items;
    }

    public void addToCart(AbstractItem item, int quantity) {
        items.put(item, quantity);
    }
    public void showOrder() {
        System.out.println("Full order:");

        for (Map.Entry<AbstractItem, Integer> entry : items.entrySet()) {
            AbstractItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%d x %s = %.2f lv%n", quantity, item.getName(), item.getPrice() * quantity);
        }
    }
}