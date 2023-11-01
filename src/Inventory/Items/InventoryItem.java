package Inventory.Items;

public class InventoryItem extends AbstractItem {
    public InventoryItem(String name, String category, boolean breakable, boolean perishable, double price, double quantity) {
        super(name, category, breakable, perishable, price, quantity);
    }

    @Override
    public void handleBreakage() {

    }

    @Override
    public void setCategory(String category) {

    }

    @Override
    public void handleExpiration() {
    }
    @Override
    public void setPrice(double price) {
    }
}