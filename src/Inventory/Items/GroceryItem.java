package Inventory.Items;

public class GroceryItem extends AbstractItem {


    public GroceryItem(String name, String category, double price, double quantity) {
        super(name, category, price, quantity);
        this.setBreakable(false);
        this.setPerishable(true);
    }

    @Override
    public void handleBreakage() {

    }

    @Override
    public void handleExpiration() {

    }
}