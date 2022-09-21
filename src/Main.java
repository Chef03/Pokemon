import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        Bag bag = new Bag(100);

        bag.addItem(new Item("Cool potion", 20, 10));
        bag.addItem(new Item("Super Middle Potion", 20, 20));
        bag.addItem(new Item("Super Heavy Potion", 20, 30.6));


        for (int i = 0; i < bag.getItemCount(); i++) {
            System.out.println(bag.peek(i));
        }


        Pokemon charmander = new Pokemon("Charmander", 200, 100, PokeType.Fire);
        Skill fireball = new Skill("Fire Ball", 10, 10);
        charmander.learnSkill(fireball);

        Pokemon tangela = new Pokemon("Tangela", 50, 200, PokeType.Grass);
        Skill gigaDrain = new Skill("Giga drain", 20, 10);
        tangela.learnSkill(gigaDrain);

        charmander.attack(tangela);
        tangela.useItem(bag.pop());


    }
}