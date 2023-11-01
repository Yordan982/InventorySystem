package Inventory.Items;

public class GroceryItem extends InventoryItem {

    public GroceryItem(String name, String category, double price, double quantity) {
        super(name, category, false, true, price, quantity);
    }
}