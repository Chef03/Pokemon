package assignment2;

public class Main {

    public static void main(String[] args) {

        new Pokemon("pikachu", 200, "Fire");

        ItemBag bag = new ItemBag(200);
        bag.addItem(new Item("test", 30, 10));
        bag.addItem(new Item("test2", 30, 10));


    }

}
