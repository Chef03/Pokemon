public class Battle {

    public static double getMultiplier(PokeType attackerType, PokeType defenderType) {

        double multiplier = 1;

        switch (attackerType) {

            case Fire:
                if (defenderType == PokeType.Grass) {

                    multiplier = 2;

                } else if (defenderType == PokeType.Water || defenderType == PokeType.Fire) {

                    multiplier = 0.5;

                }
                break;

            case Water:
                if (defenderType == PokeType.Fire) {
                    multiplier = 2;
                } else if (defenderType == PokeType.Grass || defenderType == PokeType.Water) {
                    multiplier = 0.5;
                }

                break;

            case Grass:
                if (defenderType == PokeType.Water) {
                    multiplier = 2;
                } else if (defenderType == PokeType.Fire || defenderType == PokeType.Grass) {
                    multiplier = 0.5;
                }
                break;

            default:
                multiplier = 1;
                break;


        }

        return multiplier;


    }

}
