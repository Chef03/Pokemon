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

    @Override
    public String toString() {
        return this.name;
    }

}
