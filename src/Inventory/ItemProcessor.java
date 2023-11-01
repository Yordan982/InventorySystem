package Inventory;

import Inventory.Items.AbstractItem;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ItemProcessor {
    private LinkedHashMap<Integer, AbstractItem> inventory;

    public ItemProcessor() {
        inventory = new LinkedHashMap<>();
    }

    public void addItem(AbstractItem item) {
        boolean itemNameExists = inventory.values().stream().anyMatch(x -> x.getName().equals(item.getName()));
        if (itemNameExists) throw new KeyAlreadyExistsException("The item is already registered");
        inventory.put(item.getId(), item);
        System.out.println("Successfully registered item");
    }
    public void removeItem(String id) {
        if (!id.matches("\\d+")) throw new IllegalArgumentException("Input must be a valid number.");

        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Successfully deleted item id " + id);
        } else {
            System.out.println("This id does not exist");
        }
    }
    public void findItem(int id) {
        if (inventory.containsKey(id)) {
            System.out.println(inventory.get(id));
        } else {
            System.out.println("This id does not exist");
        }
    }

    public void findAllItems() {
        for (Map.Entry<Integer, AbstractItem> entry: inventory.entrySet()) {
            System.out.println(entry.getValue());
        }
        if (inventory.isEmpty()) {
            System.out.println("The list is empty");
        }
    }
    public Map<String, List<AbstractItem>> categorizedItems(){
        return null;
    }
}