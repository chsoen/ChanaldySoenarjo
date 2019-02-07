package Model;

public class Pizza extends Item {
    public Pizza(String name, double price, boolean isDeluxe) {
        super(name, price, isDeluxe);
        if (isDeluxe) this.price += 3;
    }
}