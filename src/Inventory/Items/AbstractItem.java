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

    public static void setNextItemId(int nextItemId) {
        AbstractItem.nextItemId = nextItemId;
    }

    public AbstractItem setId(int id) {
        this.id = id;
        return this;
    }

    public AbstractItem setName(String name) {
        this.name = name;
        return this;
    }

    public AbstractItem setBreakable(boolean breakable) {
        this.breakable = breakable;
        return this;
    }

    public AbstractItem setPerishable(boolean perishable) {
        this.perishable = perishable;
        return this;
    }

    public AbstractItem setPrice(double price) {
        this.price = price;
        return this;
    }

    public AbstractItem setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    private double quantity;

    public AbstractItem(String name, String category, double price, double quantity) {
        this.id = nextItemId++;
        this.name = name;
        this.category = category;
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
    public void setCategory(String category) {

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

    @Override
    public void sell(String itemId) {

    }
}