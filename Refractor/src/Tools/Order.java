package Tools;

import Model.Item;
import Tools.Time.Time;

import java.util.ArrayList;

public class Order{
    private ArrayList<Item> customerOrders;
    public Time timeWaiting = new Time();
    Time start;
    boolean out;
    boolean complete;

    Order(ArrayList<Item> items, Time start){
        //if not in inventory add 10 minutes to order
        customerOrders = items;
        this.start = start;
        out = false;
        complete = false;
    }

    private void checkInInventory(ArrayList<Item> inventory){
        for(Item order:customerOrders){
            if(inventory.contains(order)) inventory.remove(order);
            else{
                timeWaiting.setMin(timeWaiting.getMin() + 10);
                break;
            }
        }
    }

    public void delivering(){
        out = true;
    }
    public void delivered(){
        complete = true;
    }
    public double getTotalPrice(){
        return customerOrders.;
    }
}
