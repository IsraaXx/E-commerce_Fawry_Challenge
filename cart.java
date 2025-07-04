import java.util.*;
        
public class cart {
    private List<cartItem> items = new ArrayList<>();

    protected void addToCart(product product , int amount) throws Exception {
            if(product.getQuantity() < amount) {
                throw new Exception("Not enough stock for product: " + product.getName());
            
            }
            items.add(new cartItem(product, amount));
}

public List<cartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    double total = 0;
    public double getSubtotal() {
        for (cartItem item : items) {
            total += item.totalPrice();
        }
        return total;
    }

    double totalWeight = 0;
    public double getTotalWeight() {
        for (cartItem item : items) {
            if(item.product.requiresShipping()) {
                totalWeight += item.totalWeight();
            }
        }
        return totalWeight;
    

}
}
