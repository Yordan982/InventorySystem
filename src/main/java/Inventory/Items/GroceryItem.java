package Inventory.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Grocery")
public class GroceryItem extends AbstractItem {

    public GroceryItem() {
    }
    public GroceryItem(String name, String category, double price, int quantity) {
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