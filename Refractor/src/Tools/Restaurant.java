package Tools;

import Model.Item;
import Model.Pasta;
import Model.Pizza;
import Model.Sandwich;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<String> customers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Item> inventory = new ArrayList<>();

    public Restaurant(String name) {
        this.name = name;
        makePizza("Pepperoni Pizza", 5.00, false, 5);
        makePasta("Tortellini", 7.00, false, 5);
        makeSandwich("Grilled Ham & Cheese", Sandwich.Size.SMALL, 5);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    Requires: String name, double price, boolean isDeluxe, int amount
    Effects: adds a certain amount of pizzas to the inventory
     */
    public void makePizza(String name, double price, boolean isDeluxe, int amount) {
        for (int i = 0; i < amount; i++) inventory.add(new Pizza(name, price, isDeluxe));
    }

    /*
    Requires: String name, double price, boolean isDeluxe, int amount
    Effects: adds a certain amount of pastas to the inventory
     */
    public void makePasta(String name, double price, boolean isDeluxe, int amount) {
        for (int i = 0; i < amount; i++) inventory.add(new Pasta(name, price, isDeluxe));
    }

    /*
    Requires: String name, double price, boolean isDeluxe, int amount
    Effects: adds a certain amount of sandwiches to the inventory
     */
    public void makeSandwich(String name, Sandwich.Size size, int amount) {
        for (int i = 0; i < amount; i++) inventory.add(new Sandwich(name, size));
    }

    /*
    Requires: String name, Order order
    Modifies: This
    Effects: When someone makes an order, add that person's name to people arrayList and add their order to orders
    and remove prepared food from inventory
    */
    public void placeOrder(String name, Order order) {
        customers.add(name);
        orders.add(order);
        order.checkInInventory(inventory);
    }

    /*
    Requires: String name
    Effects: Prints the cost of a person's order
    */
    public void getPriceOfOrder(String name) {
        System.out.print("The cost of " + name + "\'s order is $");
        System.out.printf("%.2f", orders.get(customers.indexOf(name)).getTotalPrice());
        System.out.println();
    }

    /*
    Requires: String name
    Effects: Prints out the time the order is finished
     */
    public void getTimeOrderDone(String name) {
        System.out.print("The time " + name + "\'s order is done: ");
        System.out.print(orders.get(customers.indexOf(name)).getTimeDone());
        System.out.println();
    }
}
