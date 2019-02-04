package Model;

public class Pasta extends Item {
    public Pasta(String name, double price, boolean isDeluxe) {
        super(name, price, isDeluxe);
    }

    public double getPrice() {
        if(isDeluxe) return price + 2;
        else return price;
    }
}