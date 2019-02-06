package Tools;

import Model.Item;

import java.util.ArrayList;

public class Order {
    private ArrayList<Item> customerOrders;
    private Time timeDone;
    private Time timeStarted;

    public Order(ArrayList<Item> items, Time timeStarted) {
        customerOrders = items;
        this.timeStarted = timeStarted;
        this.timeDone = new Time(timeStarted);
    }

    /*
    Requires: ArrayList<Item> inventory
    Modifies: This
    Effects: If an item is missing, add 10 minutes to timeDone
     */
    void checkInInventory(ArrayList<Item> inventory) {
        for (Item order : customerOrders) {
            if (inventory.contains(order)) inventory.remove(order);
            else if (timeDone.equals(timeStarted)) timeDone.addMin(10);
        }
        if (timeDone.equals(timeStarted)) timeDone = new Time(timeStarted);
    }

    Time getTimeDone() {
        return timeDone;
    }

    public double getTotalPrice() {
        int price = 0;
        for (Item order : customerOrders) price += order.getPrice();
        return price;
    }
}
