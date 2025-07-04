public abstract class product {
    protected String name;
    protected double price;
    protected int quantity;

    public product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { 
        return name; }
    public double getPrice() { 
        return price; }
    public int getQuantity() { 
        return quantity; }
    public void redQuantity(int qt) {
         quantity -= qt; }

    public abstract boolean isExpired();
    public abstract boolean requiresShipping();
    public abstract double getWeightPerUnit(); 
}

// Some products may expire like Cheese and Biscuits while
// others may not expire like TV and Mobile.****

//Some products may require shipping like Cheese and TV, other
//products like Mobile scratch cards may not require so. every
//shippable item should provide its weight.  ****


// Customers should be able to add a product to cart with
// specific quantity not more than the available product quantity

//Customers are able to do checkout with items in the cart