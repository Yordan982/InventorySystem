package Inventory.Items;

public class ElectronicsItem extends AbstractItem {


    public ElectronicsItem(String name, String category, double price, double quantity) {
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