package Tools;

import Model.Item;

import java.util.ArrayList;

public class Order {
    private ArrayList<Item> customerOrders;
    private Time timeFinished = new Time();
    private Time timeStarted;

    public Order(ArrayList<Item> items, Time timeStarted) {
        customerOrders = items;
        this.timeStarted = timeStarted;
    }

    void checkInInventory(ArrayList<Item> inventory) {
        for (Item order : customerOrders) {
            if (inventory.contains(order)) inventory.remove(order);
            else {
                if (timeFinished.equals(new Time())) {
                    timeFinished.setMin(timeStarted.getMin() + 10);
                }
            }
        }
    }

    public double getTotalPrice() {
        int price = 0;
        for (Item order : customerOrders) price += order.getPrice();
        return price;
    }
}
