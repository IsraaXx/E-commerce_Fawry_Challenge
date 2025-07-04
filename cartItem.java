public class cartItem {
    product product;
    int quantity;


    public cartItem(product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }



    public double totalPrice() {
        return product.getPrice() * quantity;
    
    }

    public double totalWeight() {
        return product.getWeightPerUnit() * quantity;
    }



}
