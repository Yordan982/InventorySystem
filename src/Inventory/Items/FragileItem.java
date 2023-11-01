package Inventory.Items;

import Inventory.Types.Breakable;

public class FragileItem extends AbstractItem {


    public FragileItem(String name, String category, double price, double quantity) {
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