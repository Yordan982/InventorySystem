package Inventory.Types;

public interface Perishable {
    boolean isPerishable();
    void handleExpiration();
}
