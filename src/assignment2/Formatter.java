package assignment2;

public class Formatter {

    public static String printPokemon(Pokemon pokemon) {

        if (!pokemon.knowsSkill()) {

            return String.format("%s (%s)", pokemon.getName(), pokemon.getType());

        }

        return String.format(
                "%s (%s). Knows %s - AP: %d EC: %d",
                pokemon.getName(),
                pokemon.getType(),
                pokemon.getSkill().getName(),
                pokemon.getSkill().getAP(),
                pokemon.getSkill().getEnergyCost()
        );

    }

    public static String printSkill(Skill skill) {

        return String.format("%s - AP: %d EC: %d", skill.getName(), skill.getAP(), skill.getEnergyCost());

    }

    public static String printItem(Item item) {

        String formattedWeight = String.format("%.2f", (Math.floor(item.getWeight() * 100) / 100));
        return String.format(
                "%s heals %d HP. (%s)",
                item.getName(),
                item.getHealingPower(),
                formattedWeight);

    }


}
