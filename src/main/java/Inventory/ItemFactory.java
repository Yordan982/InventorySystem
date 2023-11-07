package Inventory;

import Inventory.Items.AbstractItem;
import Inventory.Items.ElectronicsItem;
import Inventory.Items.FragileItem;
import Inventory.Items.GroceryItem;

public class ItemFactory {

    public ItemFactory() {
    }

    public AbstractItem getInstance(String[] input) {
        String type = input[0];
        return switch (type) {
            case "Grocery" ->
                    new GroceryItem(input[1], input[2], Double.parseDouble(input[3]), Integer.parseInt(input[4]));
            case "Electronics" ->
                    new ElectronicsItem(input[1], input[2], Double.parseDouble(input[3]), Integer.parseInt(input[4]));
            case "Fragile" ->
                    new FragileItem(input[1], input[2], Double.parseDouble(input[3]), Integer.parseInt(input[4]));
            default -> null;
        };
    }
}