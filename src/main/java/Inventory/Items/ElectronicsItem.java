package Inventory.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Electronics")
public class ElectronicsItem extends AbstractItem {

    public ElectronicsItem() {
    }

    public ElectronicsItem(String name, String category, double price, int quantity) {
        super(name, category, price, quantity);
        this.setBreakable(true);
        this.setPerishable(false);
    }

    @Override
    public void handleBreakage() {

    }

    @Override
    public void handleExpiration() {

    }
}