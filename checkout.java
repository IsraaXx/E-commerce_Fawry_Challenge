public class checkout { 

    // Method to checkout the cart
public static void checkout(customer cust , cart cart) throws Exception {
        if(cart.isEmpty()) {
            throw new Exception("Cart is empty!");
        }
        
        double subtotal = 0;
        double totalWeight = 0;

          for (cartItem item : cart.getItems()) {
            product product = item.product;

            if (product.isExpired()) {
                throw new Exception("Product expired: " + product.getName());
            }

            if (item.quantity > product.getQuantity()) {
                throw new Exception("Not enough stock for product: " + product.getName());
            }
            subtotal += item.totalPrice();
            totalWeight += item.totalWeight();
        }
        double shippingFee = totalWeight > 0 ? 30 : 0;
        double totalAmount = subtotal + shippingFee;

        if (totalAmount > cust.balance()) {
            throw new Exception("Insufficient balance.");
        }

         for (cartItem item : cart.getItems()) {
            item.product.redQuantity(item.quantity);
        }
        cust.reducebalance(totalAmount);

       if (totalWeight > 0) {
            System.out.println("** Shipment notice **");
            for (cartItem item : cart.getItems()) {
                if (item.product.requiresShipping()) {
                    System.out.printf("%dx %s %.0fg\n", item.quantity,item.product.getName(),item.product.getWeightPerUnit() * 1000);
                }
            }
            System.out.printf("Total package weight %.2fkg\n", totalWeight);
        }
        System.out.println("** Checkout receipt **");
        for (cartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.quantity,
                    item.product.getName(),
                    item.totalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n", totalAmount);
        System.out.printf("Customer balance %.0f\n", cust.balance());
    }

     public static void main(String[] args) throws Exception {
        NotExpired cheese = new NotExpired("Cheese", 100, 10,
                true, 0.2); 

        NotExpired tv = new NotExpired("TV", 3000, 5,
                true, 10.0);

        NotExpired scratchCard = new NotExpired("ScratchCard", 50, 50,false, 0.0);

        customer customer = new customer("Israa", 5000);

        cart cart = new cart();
        cart.addToCart(cheese, 2);
        cart.addToCart(scratchCard, 1);
        checkout.checkout(customer, cart);
    }

}
    

