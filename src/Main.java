public class Main {
    public static void main(String[] args) {

        Bag bag = new Bag(100);

        bag.addItem(new Item("Super Potion", 20, 15.6));
        for (int i = 0; i < bag.getItemCount(); i++) {
            System.out.println(bag.peek(i));
        }

        Pokemon charmander = new Pokemon("Charmander", 200, 100, PokeType.Fire);
        charmander.learnSkill("fire ball", 100, 50);
        charmander.useItem(bag.pop());

        Pokemon tangela = new Pokemon("Tangela", 100, 200, PokeType.Grass);
        charmander.attack(tangela);


    }
}