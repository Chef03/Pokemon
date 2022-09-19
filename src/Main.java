public class Main {
    public static void main(String[] args) {

        Bag bag = new Bag(100);

        bag.addItem(new Item("Super Potion", 20, 15.6));
        for (int i = 0; i < bag.getItemCount(); i++) {
            System.out.println(bag.peek(i));
        }

        Pokemon pikachu = new Pokemon("Pikachu", 200, 100, PokeType.Fire);
        Pokemon charmander = new Pokemon("Charmander", 100, 200, PokeType.Grass);
        pikachu.learnSkill("fire ball", 100, 50);
        pikachu.attack(charmander);
        charmander.rest();



    }
}