package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum PokeType {

    FIRE(
            "Fire",
            Arrays.asList("Bug", "Ice", "Grass"),
            Arrays.asList("Dragon", "Fire", "Water")
    ),
    WATER(
            "Water",
            Arrays.asList("Fire"),
            Arrays.asList("Dragon", "Grass", "Water")
    ),
    GRASS(
            "Grass",
            Arrays.asList("Water"),
            Arrays.asList("Bug", "Dragon", "Fire", "Grass")
    ),
    ELECTRIC(
            "Electric",
            Arrays.asList("Water"),
            Arrays.asList("Dragon", "Electric", "Grass")
    ),
    ICE(
            "Ice",
            Arrays.asList("Dragon", "Grass"),
            Arrays.asList("Fire", "Ice", "Water")
    ),

    BUG(
            "Bug",
            Arrays.asList("Grass"),
            Arrays.asList("Fire")
    ),

    DRAGON(
            "Dragon",
            Arrays.asList("Dragon"),
            new ArrayList()
    ),

    NORMAL("Normal", new ArrayList(), new ArrayList());

    private final String name;
    private final List<String> effectiveAgainst;
    private final List<String> ineffectiveAgainst;


    PokeType(String name, List<String> goodAgainst, List<String> badAgainst) {

        this.name = name;
        this.effectiveAgainst = goodAgainst;
        this.ineffectiveAgainst = badAgainst;

    }

    public boolean isEffectiveAgainst(PokeType type) {

        return this.effectiveAgainst.contains(type.name);

    }

    public boolean isIneffectiveAgainst(PokeType type) {

        return this.ineffectiveAgainst.contains(type.name);

    }

    @Override
    public String toString() {
        return this.name;
    }


}
