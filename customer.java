public class customer {
    public String name;
    public double balance;


    public customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }


    public double balance() {
        return balance;
    }

 public void reducebalance(double amount) {
    balance-=amount;
 }
    

}
