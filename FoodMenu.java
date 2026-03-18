import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    FoodMenu() {
        Food food1 = new Food("cake", "sweet", 34);
        Food food2 = new Food("ice-cream", "too sweet", 5);
        Food food3 = new Food("noodles", "spicy", 10);
        menu = new ArrayList<>();
        menu.add(food1);
        menu.add(food2);
        menu.add(food3);
    }

    public Food getFood(int sel) {
        int idx = sel - 1;
        if (idx >= menu.size() || idx < 0) return null;
        return menu.get(idx);
    }

    public Food getLowestCostFood() {
        return menu.stream().min((a, b) -> a.getPrice().compareTo(b.getPrice())).orElseThrow();
    }

    @Override
    public String toString() {
        String menuString = "";
        int i = 1;
        for (Food food : menu) menuString += i++ + ". " + food.toString() + "\n";
        return menuString;
    }

    public static void main(String[] args) {
        FoodMenu foodMenu = new FoodMenu();
        System.out.println(foodMenu.toString());
        System.out.println(foodMenu.getFood(9).toString());

        System.out.println(foodMenu.getLowestCostFood().toString());
    }
}
