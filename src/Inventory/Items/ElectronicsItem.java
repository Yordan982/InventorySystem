package Inventory.Items;

public class ElectronicsItem extends InventoryItem {


    public ElectronicsItem(String name, String category, double price, double quantity) {
        super(name, category, true, false, price, quantity);
    }
}