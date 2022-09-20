import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        Bag bag = new Bag(100);

        bag.addItem(new Item("Super Light Potion", 20, 15.6));
        bag.addItem(new Item("Super Middle Potion", 20, 20));
        bag.addItem(new Item("Super Heavy Potion", 20, 30.6));

        for (int i = 0; i < bag.getItemCount(); i++) {
            System.out.println(bag.peek(i));
        }

        System.out.println(bag.getWeight());

        Pokemon charmander = new Pokemon("Charmander", 200, 100, PokeType.Fire);
        charmander.learnSkill("Fire Ball", 100, 50);

        Pokemon tangela = new Pokemon("Tangela", 100, 200, PokeType.Grass);
        tangela.learnSkill("Giga drain", 20, 10);

        //dont put printing inside object classes
        charmander.attack(tangela);
        tangela.useItem(bag.pop());


    }
}