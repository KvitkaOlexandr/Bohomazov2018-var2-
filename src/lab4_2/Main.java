package lab4_2;

public class Main {
    public static void main(String[] args){
        Payment payment = new Payment();
        payment.addItem("car", 25.5);
        payment.addItem("gasoline", 45);
        System.out.println("total cost " + payment.getTotalCost());
        System.out.println("items " + payment.getAllItems());
    }
}
