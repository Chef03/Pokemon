package assignment2;

enum PokeType {

    FIRE("Fire"),
    WATER("Water"),
    GRASS("Grass"),
    ELECTRIC("Electric"),
    ICE("Ice"),
    BUG("Bug"),
    DRAGON("Dragon"),
    NORMAL("Normal");

    private final String name;

    PokeType(String name) {

        this.name = name;

    }

    public boolean isIneffectiveAgainst(PokeType type) {

        return TypeData.getType(this).isIneffectiveAgainst(type);

    }

    public boolean isEffectiveAgainst(PokeType type) {

        return TypeData.getType(this).isEffectiveAgainst(type);

    }

    @Override
    public String toString() {
        return this.name;
    }

}
