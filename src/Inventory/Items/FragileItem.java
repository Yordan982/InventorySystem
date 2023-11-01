package Inventory.Items;

import Inventory.Types.Breakable;

public class FragileItem extends InventoryItem {

    public FragileItem(String name, String category, double price, double quantity) {
        super(name, category, true, false, price, quantity);
    }
}