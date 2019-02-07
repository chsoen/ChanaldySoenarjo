package Tools;

import Model.Item;
import Model.Pasta;
import Model.Pizza;
import Model.Sandwich;

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
            foodPrepared:
            {
                for (Item stored : inventory) {
                    if ((stored instanceof Pizza || stored instanceof Pasta) && stored.equals(order)) {
                        inventory.remove(order);
                        break foodPrepared;
                    } else if (stored instanceof Sandwich && stored.equals(order)) {
                        inventory.remove(order);
                        break foodPrepared;
                    }
                }
                timeDone.addMin(10);
            }
        }
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
