package assignment2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TypeData {

    private final static HashMap<String, TypeData> PokemonTypes = loadTypes();
    private final HashSet<String> EffectiveTypes;
    private final HashSet<String> IneffectiveTypes;

    private TypeData(HashSet<String> goodAgainst, HashSet<String> badAgainst) {

        this.EffectiveTypes = goodAgainst;
        this.IneffectiveTypes = badAgainst;

    }

    public static TypeData getType(String name) {

        return PokemonTypes.get(name);

    }

    public boolean isEffectiveAgainst(String defenderType) {

        return this.EffectiveTypes.contains(defenderType);

    }

    public boolean isIneffectiveAgainst(String defenderType) {

        return this.IneffectiveTypes.contains(defenderType);

    }

    private static HashMap<String, TypeData> loadTypes() {

        HashMap<String, TypeData> set = new HashMap<>();

        set.put("Normal", new TypeData(
                new HashSet<>(),
                new HashSet<>()
        ));

        set.put(
                "Fire",
                new TypeData(
                        new HashSet<>(Arrays.asList("Bug", "Grass", "Ice")),
                        new HashSet<>(Arrays.asList("Dragon", "Fire", "Water"))
                )
        );

        set.put(
                "Water",
                new TypeData(
                        new HashSet<>(Arrays.asList("Fire")),
                        new HashSet<>(Arrays.asList("Dragon", "Grass", "Water"))
                )
        );

        set.put(
                "Dragon",
                new TypeData(
                        new HashSet<>(Arrays.asList("Dragon")),
                        new HashSet<>()
                )
        );

        set.put(
                "Electric",
                new TypeData(
                        new HashSet<>(Arrays.asList("Water")),
                        new HashSet<>(Arrays.asList("Dragon", "Electric", "Grass"))
                )
        );

        set.put(
                "Grass",
                new TypeData(
                        new HashSet<>(Arrays.asList("Water")),
                        new HashSet<>(Arrays.asList("Dragon","Bug", "Fire", "Grass" ))
                )
        );

        set.put(
                "Ice",
                new TypeData(
                        new HashSet<>(Arrays.asList("Dragon", "Grass")),
                        new HashSet<>(Arrays.asList("Fire", "Ice", "Water"))
                )
        );


        set.put(
                "Bug",
                new TypeData(
                        new HashSet<>(Arrays.asList("Grass")),
                        new HashSet<>(Arrays.asList("Fire"))
                )
        );
        return set;


    }


}
