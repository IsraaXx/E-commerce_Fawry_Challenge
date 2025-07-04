public class main {
       public static void main(String[] args) throws Exception {
        NotExpired cheese = new NotExpired("Cheese", 100, 10,
                true, 0.2); 

        NotExpired tv = new NotExpired("TV", 3000, 5,
                true, 10.0);

        NotExpired scratchCard = new NotExpired("ScratchCard", 50, 50,false, 0.0);

        customer customer = new customer("Israa", 5000);

        cart cart = new cart();
        cart.addToCart(cheese, 2);
        cart.addToCart(tv, 1);
        cart.addToCart(scratchCard, 1);
        checkout.checkout(customer, cart);
    }
}
