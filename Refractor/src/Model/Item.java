package Model;

public abstract class Item {
    private String name;
    double price;
    boolean isDeluxe;

    Item(String name, double price, boolean isDeluxe) {
        this.name = name;
        this.price = price;
        this.isDeluxe = isDeluxe;
    }

    Item(String name, double price) {
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
