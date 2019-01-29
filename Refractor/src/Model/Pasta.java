package Model;

public class Pasta extends Items {
    private boolean isDeluxe;

    public Pasta(String name, double price, boolean deluxe){
        super(name, price);
        isDeluxe = deluxe;
    }

    @Override
    public double getPrice() {
        if(isDeluxe) return price + 2;
        else return price;
    }
}
