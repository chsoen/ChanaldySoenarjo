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

    public double getPrice() {
        return price;
    }

    /*
    Requires: Object obj
    Effects: Returns true if object is the same name and price.
     */
    @Override
    public boolean equals(Object obj) {
        Item item = (Item) obj;
        return this.name.equals(item.name) && this.price == item.price;
    }
}
