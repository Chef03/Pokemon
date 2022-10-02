package assignment2;

public class Battle {

    private static final double NORMAL_MULTIPLIER = 1.00;
    private static final double EFFECTIVE_MULTIPLIER = 2.00;
    private static final double INEFFECTIVE_MULTIPLIER = 0.50;

    public static double getMultiplier(Pokemon attacker, Pokemon target) {

        PokeType targetType = PokeType.valueOf(target.getType().toUpperCase());
        PokeType attackerType = PokeType.valueOf(attacker.getType().toUpperCase());

        if (attackerType.isEffectiveAgainst(targetType)) {

            return Battle.EFFECTIVE_MULTIPLIER;

        } else if (attackerType.isIneffectiveAgainst(targetType)) {

            return Battle.INEFFECTIVE_MULTIPLIER;

        }

        return Battle.NORMAL_MULTIPLIER;

    }

    public static String warn(Pokemon attacker, Pokemon target) {

        if (attacker.hasFainted()) {

            return String.format("%s has fainted.", attacker.getName());

        }

        if (target.hasFainted()) {

            return String.format("%s has fainted.", target.getName());

        }

        if (!attacker.knowsSkill()) {

            return String.format("%s does not know a skill.", attacker.getName());

        }

        if (attacker.getEnergy() < attacker.getSkill().getEnergyCost()) {

            return String.format("%s lacks energy: %d/%d", attacker.getName(), attacker.getEnergy(), attacker.getSkill().getEnergyCost());

        }

        return null;

    }

    public static String getAttackMessage(Pokemon attacker, Pokemon target) {

        String alert = String.format("%s uses %s on %s.", attacker.getName(), attacker.getSkill().getName(), target.getName());
        String targetStatus = String.format("%s has %d HP left.", target.getName(), target.getCurrentHP());

        double multiplier = Battle.getMultiplier(attacker, target);

        if (multiplier == EFFECTIVE_MULTIPLIER) {

            alert += " It is super effective!";

        } else if (multiplier == INEFFECTIVE_MULTIPLIER) {

            alert += " It is not very effective...";

        }

        if (target.hasFainted()) {

            targetStatus += String.format(" %s faints.", target.getName());

        }

        return alert + System.lineSeparator() + targetStatus;

    }

    public static String getItemMessage(Pokemon pokemon, Item item, int healAmount) {

        if (healAmount < 1) {

            return String.format("%s could not use %s. HP is already full.", pokemon.getName(), item.getName());

        }

        return String.format("%s used %s. It healed %d HP.", pokemon.getName(), item.getName(), healAmount);

    }


}
