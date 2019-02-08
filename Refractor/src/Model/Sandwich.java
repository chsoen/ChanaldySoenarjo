package Model;

public class Sandwich extends Item {
    private Size size;

    public enum Size {
        SMALL(6.5), MEDIUM(8.0), LARGE(10.5);

        private double price;

        Size(double price) {
            this.price = price;
        }

        double getPrice() {
            return price;
        }
    }

    public Sandwich(String name, Size size) {
        super(name, size.getPrice());
        this.size = size;
    }

    /*
    Effects: Gets the price depending on size of sandwich.
     */
    @Override
    public double getPrice() {
        return size.getPrice();
    }
}
