package Inventory.Items;

import Inventory.Types.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    private static int nextItemId = 1;
    private int id;
    private String name;
    private String category;
    private boolean breakable;
    private boolean perishable;
    private double price;
    private double quantity;

    public AbstractItem(String name, String category, boolean breakable, boolean perishable, double price, double quantity) {
        this.id = nextItemId++;
        this.name = name;
        this.category = category;
        this.breakable = breakable;
        this.perishable = perishable;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return String.format("%s, %s, %s, %s, %.2f", this.name, this.category, this.breakable, this.perishable, this.price);
    }

    public double calculateValue() {
        return price;
    }

    public String getItemDescription() {
        return "This is a " + name + " in the " + category + " category.";
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public double getQuantity() {
        return quantity;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Name: " + getName() + ", Category: " + getCategory() + ", Price: " + getPrice() + ", Quantity: " + getQuantity();
    }
}