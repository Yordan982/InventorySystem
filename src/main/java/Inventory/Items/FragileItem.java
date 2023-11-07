package Inventory.Items;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Fragile")
public class FragileItem extends AbstractItem {

    public FragileItem() {
    }

    public FragileItem(String name, String category, double price, int quantity) {
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