import java.util.Date;
import java.util.*;

public class ExpiredProduct extends product {
    private String expirationDate;
    private double weightPerUnit;

    public ExpiredProduct(String name, double price, int quantity, String expirationDate, double weightPerUnit) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weightPerUnit = weightPerUnit;
    }

    @Override
    public boolean isExpired() {
        return true;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeightPerUnit() {
        return weightPerUnit;
    }
    
}
