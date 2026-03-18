import java.util.Scanner;

public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    TakeOutSimulator() {
        customer = new Customer("Coyote", 50);
        menu = new FoodMenu();
        input = new Scanner(System.in);
    }

    TakeOutSimulator(Customer customer) {
        this.customer = customer;
        menu = new FoodMenu();
        input = new Scanner(System.in);
    }

    // uip = userInputPrompt
    // uir = userInputRetriever
    private <T> T getResponse(String uip, UserInputRetriever<T> uir) {
        System.out.println(uip);

        while (true) {
            if (input.hasNextInt()) {
                int userInput = input.nextInt();
                try {
                    return uir.produceOutput(userInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Selection: " + userInput);
                }
            } else {
                System.out.println("Input must be a integer.");
                input.next();
            }
        }
    }

    public Boolean shouldSimulate() {
        String userPrompt = "input 1 to continue or 0 to stop.";
        //System.out.println(userPrompt);

        UserInputRetriever<Boolean> uir = new UserInputRetriever<>() {
            @Override
            public Boolean produceOutput(int sel) throws IllegalArgumentException {
                if (sel == 1) {
                    if (menu.getLowestCostFood().getPrice() <= customer.getMoney()) return true;
                    else {
                        System.out.println("not enough money");
                        return false;
                    }
                }
                else if (sel == 0) return false;
                else throw new IllegalArgumentException("only 0 or 1 allowed");
            }
        };

        return getResponse(userPrompt, uir);
    }

    public Food getMenuSelection() {
        String userPrompt = "choose one: \n" + menu.toString();
        UserInputRetriever<Food> uir = new UserInputRetriever<>() {
            @Override
            public Food produceOutput(int sel) {
                if (menu.getFood(sel) == null) {
                    throw new IllegalArgumentException();
                }

                else return menu.getFood(sel);
            }
        };

        return getResponse(userPrompt, uir);
    }

    public Boolean isStillOrderingFood() {
        String userPrompt = "1 for continue shopping 0 for checkout";
        UserInputRetriever<Boolean> uir = new UserInputRetriever<Boolean>() {
            @Override
            public Boolean produceOutput(int sel) {
                if (sel != 1 && sel != 0) throw new IllegalArgumentException();
                return sel == 1 ? true : false;
            }
        };

        return getResponse(userPrompt, uir);
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
        System.out.println("Payment is being processed...");
        int remMoney = customer.getMoney() - shoppingBag.getTotalPrice();
        customer.setMoney(remMoney);
        System.out.println("Money left: $" + remMoney);
        System.out.println("Enjoy!!");
    }

    public void takeOutSimulator() {
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoneyLeft = customer.getMoney();

        while (isStillOrderingFood()) {
            System.out.println("Money left: $" + customerMoneyLeft);
            Food selected = getMenuSelection();
            if (selected.getPrice() <= customerMoneyLeft) {
                shoppingBag.addItem(selected);
                customerMoneyLeft -= selected.getPrice();
                //customer.setMoney(customerMoneyLeft);
            } else {
                System.out.println("Not enough money\n pick another item or checkout");
            }
        }

        checkoutCustomer(shoppingBag);
    }

    public void startTakeOutSimulator() {
        while (shouldSimulate()) {
            System.out.println("Hello " + customer.getName());
            takeOutSimulator();
        }
    }

    public static void main(String[] args) {
        TakeOutSimulator tos = new TakeOutSimulator();
        String uip = "Welcome Jack!";
        /*UserInputRetriever<Integer> uir = new UserInputRetriever<Integer>() {
            @Override
            public Integer produceOutput(int sel) {
                return sel;
            }
        };
        int res = tos.getResponse(uip, uir);
        System.out.println(res);
        */
        //tos.shouldSimulate();
        //tos.getMenuSelection();
        //tos.isStillOrderingFood();
        //tos.takeOutSimulator();
        tos.startTakeOutSimulator();

    }

}
