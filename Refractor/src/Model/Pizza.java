package Model;

public class Pizza extends Items {
    private boolean isDeluxe;

    public Pizza(String name, double price, boolean deluxe){
        super(name, price);
        isDeluxe = deluxe;
    }

    @Override
    public double getPrice() {
        if(isDeluxe) return price + 3;
        else return price;
    }
}

