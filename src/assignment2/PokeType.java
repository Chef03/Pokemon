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

        TypeData data = TypeData.getType(this);
        return data.ineffectiveTypes.contains(type);

    }

    public boolean isEffectiveAgainst(PokeType type) {

        TypeData data = TypeData.getType(this);
        return data.effectiveTypes.contains(type);

    }

    @Override
    public String toString() {
        return this.name;
    }


}
