package Model;

public class Pasta extends Item {
    public Pasta(String name, double price, boolean isDeluxe) {
        super(name, price, isDeluxe);
        if (isDeluxe) this.price += 2;
    }
}