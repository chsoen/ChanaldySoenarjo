package UI;

import Model.Item;
import Model.Pizza;
import Model.Sandwich;
import Tools.Order;
import Tools.Restaurant;
import Tools.Time;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Restaurant rest1 = new Restaurant("Plates and Cutlery");
        ArrayList<Item> order1 = new ArrayList<>();
        order1.add(new Sandwich("Grilled Ham & Cheese", Sandwich.Size.SMALL));
        order1.add(new Pizza("Cheese Pizza", 3.00, false));
        rest1.placeOrder("Bob", new Order(order1, new Time(10, 20 ,00)));
        rest1.getPriceOfOrder("Bob");
    }
}