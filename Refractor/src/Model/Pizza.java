package Model;

public class Pizza extends Item {
    public Pizza(String name, double price, boolean isDeluxe) {
        super(name, price, isDeluxe);
    }

    public double getPrice() {
        if(isDeluxe) return price + 3;
        else return price;
    }
}