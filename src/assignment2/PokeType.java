package assignment2;

enum PokeType {
    Fire("Fire"),
    Water("Water"),
    Grass("Grass"),
    Normal("Normal");

    private final String type;

    PokeType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }


}
