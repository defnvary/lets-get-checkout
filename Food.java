public class Food implements PricedItem<Integer> {
    private String name;
    private String description;
    private int price;

    Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " : " + description + " : $" + price; 
    }

    public static void main(String[] args) {
        Food food1 = new Food("cake", "sweet sweet", 35);
        System.out.println(food1.toString());
    }
}
