package assignment2;

enum PokeType {

//    PokeType x[]  = {PokeType.Water};

    Fire("Fire"),
    Water("Water"),
    Grass("Grass"),

    Electric("Electric"),
    Normal("Normal");

    private final String type;
//    private final PokeType[] effectiveAgainst;
//
//    private final PokeType[] badAgainst;

    PokeType(String type) {

        this.type = type;
//        this.effectiveAgainst = effectiveAgainst;
//        this.badAgainst = badAgainst;


    }

    @Override
    public String toString() {
        return this.type;
    }


}
