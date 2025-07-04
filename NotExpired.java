public class NotExpired extends product {
    private boolean shippable;
    private double weightPerUnit;

    public NotExpired(String name, double price, int quantity,
    boolean shippable, double weightPerUnit) {
        super(name, price, quantity);
        this.shippable = shippable;
        this.weightPerUnit = shippable ? weightPerUnit : 0;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return shippable;
    }

    @Override
    public double getWeightPerUnit() {
        return weightPerUnit;
    }
}

