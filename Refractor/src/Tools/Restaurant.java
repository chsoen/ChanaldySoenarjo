package Tools;

import Model.Item;
import Model.Pasta;
import Model.Pizza;
import Model.Sandwich;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<Customer> people = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Item> inventory = new ArrayList<>();

    public Restaurant(String name){
        this.name = name;
        for(int i = 0 ; i< 5;i++){
            makePizza();
            makePasta();
            makeSandwich();
        }
    }

    private void makePizza() {
        inventory.add(new Pizza("Pepperoni Pizza", 5.00, false));
    }

    private void makePasta(){
        inventory.add(new Pasta("Tortellini", 7.00, false));
    }

    private void makeSandwich(){
        inventory.add(new Sandwich("Grilled Ham & Cheese", Sandwich.Size.SMALL));
    }
}
