package assignment2;

import java.util.*;

public class TypeData {

    private final static EnumMap<PokeType, TypeData> PokemonTypes = new EnumMap<>(PokeType.class);
    public final EnumSet<PokeType> effectiveTypes;
    public final EnumSet<PokeType> ineffectiveTypes;

    private TypeData(EnumSet<PokeType> effectiveAgainst, EnumSet<PokeType> ineffectiveAgainst) {

        this.effectiveTypes = effectiveAgainst;
        this.ineffectiveTypes = ineffectiveAgainst;

    }

    public static TypeData getType(PokeType pokemonType) {

        if(PokemonTypes.size() < 1) {
            loadTypes();
        }
        return PokemonTypes.get(pokemonType);

    }

    private static void loadTypes() {


        PokemonTypes.put(
                PokeType.NORMAL,
                new TypeData(
                        EnumSet.noneOf(PokeType.class),
                        EnumSet.noneOf(PokeType.class)
                )
        );

        PokemonTypes.put(
                PokeType.FIRE,
                new TypeData(
                        EnumSet.of(PokeType.BUG, PokeType.GRASS, PokeType.ICE),
                        EnumSet.of(PokeType.DRAGON, PokeType.FIRE, PokeType.WATER)
                )
        );

        PokemonTypes.put(
                PokeType.WATER,
                new TypeData(
                        EnumSet.of(PokeType.FIRE),
                        EnumSet.of(PokeType.DRAGON, PokeType.GRASS, PokeType.WATER)
                )
        );

        PokemonTypes.put(
                PokeType.DRAGON,
                new TypeData(
                        EnumSet.of(PokeType.DRAGON),
                        EnumSet.noneOf(PokeType.class)
                )
        );

        PokemonTypes.put(
                PokeType.ELECTRIC,
                new TypeData(
                        EnumSet.of(PokeType.WATER),
                        EnumSet.of(PokeType.DRAGON, PokeType.GRASS, PokeType.ELECTRIC)
                )
        );

        PokemonTypes.put(
                PokeType.GRASS,
                new TypeData(
                        EnumSet.of(PokeType.WATER),
                        EnumSet.of(PokeType.DRAGON, PokeType.GRASS, PokeType.BUG, PokeType.FIRE)
                )
        );

        PokemonTypes.put(
                PokeType.ICE,
                new TypeData(
                        EnumSet.of(PokeType.DRAGON, PokeType.GRASS),
                        EnumSet.of(PokeType.ICE, PokeType.ICE, PokeType.FIRE)
                )
        );


        PokemonTypes.put(
                PokeType.BUG,
                new TypeData(
                        EnumSet.of(PokeType.GRASS),
                        EnumSet.of(PokeType.FIRE)
                )
        );


    }


}
