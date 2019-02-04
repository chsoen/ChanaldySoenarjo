package Model;

public abstract class Item {
    protected String name;
    protected double price;
    protected boolean isDeluxe;

    public Item(String name, double price, boolean isDeluxe) {
        this.name = name;
        this.price = price;
        this.isDeluxe = isDeluxe;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getPrice();
}
