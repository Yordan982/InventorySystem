package Inventory;

import Inventory.Items.AbstractItem;
import Inventory.Utils.JsonUtil;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.IOException;
import java.util.*;

public class ItemProcessor {
    private final LinkedHashMap<Integer, AbstractItem> inventory;

    public ItemProcessor() {
        inventory = new LinkedHashMap<>();
    }

    public void addItem(AbstractItem item) {
        if (itemExists(item)) throw new KeyAlreadyExistsException("The item is already registered.");
        item.setId(generateId());
        inventory.put(item.getId(), item);
    }
    public void removeItem(String id) {
        if (!id.matches("\\d+")) throw new IllegalArgumentException("Input must be a valid number.");
        if (inventory.containsKey(Integer.parseInt(id))) {
            inventory.remove(Integer.parseInt(id));
            System.out.println("Successfully deleted item id " + id);
        } else {
            System.out.println("This id does not exist.");
        }
    }
    public void findItem(int id) {
        if (inventory.containsKey(id)) {
            System.out.println(inventory.get(id));
        } else {
            System.out.println("This id does not exist.");
        }
    }

    public AbstractItem getItem(int id) {
        if (!itemExistsById(id)) {
            System.out.println("The item does not exist.");
        }
        return inventory.get(id);
    }

    public void findAllItems() {
        for (Map.Entry<Integer, AbstractItem> entry: inventory.entrySet()) {
            System.out.println(entry.getValue());
        }
        if (inventory.isEmpty()) {
            System.out.println("The list is empty.");
        }
    }
    public void categorizedItems(){
        List<AbstractItem> items = this.inventory.values().stream().sorted(Comparator.comparing(AbstractItem::getCategory)).toList();
        for (AbstractItem item: items) {
            System.out.println(item.toString());
        }
    }

    public boolean itemExists(AbstractItem item) {
        return inventory.values().stream().anyMatch(x -> x.getName().equals(item.getName()));
    }
    public boolean itemExistsByName(String item) {
        return inventory.values().stream().anyMatch(x -> x.getName().equals(item));
    }
    public boolean itemExistsById(int id) {
        return inventory.values().stream().anyMatch(x -> x.getId() == id);
    }

    public int sellQuantity(int id, int quantity) {
        int soldQuantity = 0;
        if (inventory.containsKey(id)) {
            int currentQuantity = inventory.get(id).getQuantity();
            if (currentQuantity >= quantity) {
                inventory.get(id).setQuantity(currentQuantity - quantity);
                soldQuantity = quantity;
            } else {
                inventory.get(id).setQuantity(0);
                soldQuantity = currentQuantity;
            }
        }
        return soldQuantity;
    }

    public void fillInventory(AbstractItem[] items) {
        Arrays.stream(items).forEach(this::addItem);
    }

    public void writeInventory() throws IOException {
        AbstractItem[] items = this.inventory.values().toArray(AbstractItem[]::new);
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.write(items);
    }
    public int generateId() {
        int newIndex = 0;
        if (inventory.isEmpty()){
            newIndex++;
        } else {
            newIndex = this.inventory.keySet().stream().reduce((first, second) -> second).get() + 1;
        }
        return newIndex;
    }
}