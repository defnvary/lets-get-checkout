public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("coyote", 50);
        TakeOutSimulator tos = new TakeOutSimulator(customer);
        tos.startTakeOutSimulator();
    }
}
