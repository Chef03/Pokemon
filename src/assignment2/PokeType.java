package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum PokeType {

    Fire(
            Arrays.asList("Bug", "Ice", "Grass"),
            Arrays.asList("Dragon", "Fire", "Water")
    ),
    Water(
            Arrays.asList("Fire"),
            Arrays.asList("Dragon", "Grass", "Water")
    ),
    Grass(
            Arrays.asList("Water"),
            Arrays.asList("Bug", "Dragon", "Fire", "Grass")
    ),
    Electric(
            Arrays.asList("Water"),
            Arrays.asList("Dragon", "Electric", "Grass")
    ),
    Ice(
            Arrays.asList("Dragon", "Grass"),
            Arrays.asList("Fire", "Ice", "Water")
    ),

    Bug(
            Arrays.asList("Grass"),
            Arrays.asList("Fire")
    ),

    Dragon(
            Arrays.asList("Dragon"),
            new ArrayList()
    ),

    Normal(new ArrayList(), new ArrayList());


    private final List<String> effectiveAgainst;
    private final List<String> ineffectiveAgainst;


    PokeType(List<String> goodAgainst, List<String> badAgainst) {

        this.effectiveAgainst = goodAgainst;
        this.ineffectiveAgainst = badAgainst;

    }

    public boolean isEffectiveAgainst(PokeType type) {

        return this.effectiveAgainst.contains(type.name());

    }

    public boolean isInEffectiveAgainst(PokeType type) {

        return this.ineffectiveAgainst.contains(type.name());

    }

    @Override
    public String toString() {
        return this.name();
    }


}
