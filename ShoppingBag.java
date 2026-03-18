import java.util.HashMap;
import java.util.Map;

public class ShoppingBag <T extends PricedItem<Integer>> {

    private Map<T, Integer> shoppingBag;

    ShoppingBag() {
        shoppingBag = new HashMap<>();
    }
    
    public void addItem(T item) {
        shoppingBag.put(item, shoppingBag.getOrDefault(item, 0) + 1);
    }

    public int getTotalPrice() {
        int total = 0;
        for (T item : shoppingBag.keySet()) {
            total += item.getPrice() * shoppingBag.get(item);
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        Food food1 = new Food("cake", "sweet", 34);
        Food food2 = new Food("ice-cream", "too sweet", 10);
        shoppingBag.addItem(food1);
        shoppingBag.addItem(food2);

        System.out.println(shoppingBag.getTotalPrice());
    }
}
