package Tools;

import Model.Items;
import Model.Pasta;
import Model.Pizza;
import Model.Sandwich;

import java.util.ArrayList;

public class mainthing {
    private String name;
    private ArrayList<Customer> people = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Items> invent = new ArrayList<>();

    public mainthing(String name){
        this.name = name;
        startStuff();
    }

    public void startStuff(){
        for(int i = 0 ; i< 5;i++){
            makePizza();
            makePasta();
            makeSandwich();
        }
    }

    private void makePizza() {
        invent.add(new Pizza());
    }

    private void makePasta(){
        invent.add(new Pasta());
    }

    private void makeSandwich(){
        invent.add(new Sandwich());
    }
}
