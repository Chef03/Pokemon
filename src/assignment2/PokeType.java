package assignment2;

import java.util.Arrays;

enum PokeType {

    Fire(new String[] {"Water"}),
    Water( new String[] {"Water"}),
    Grass(new String[] {"Water"}),
    Electric(new String[] {"Water"}),
    Normal(new String[] {"Water"});

    private final String[] effectiveAgainst;
    PokeType(String[] goodAgainst) {

        this.effectiveAgainst = goodAgainst;


    }

    public PokeType[] getEffectiveAgainst() {

        PokeType[] types = new PokeType[this.effectiveAgainst.length];
        for(int i = 0; i < this.effectiveAgainst.length; i++) {
            types[i] = PokeType.valueOf(this.effectiveAgainst[i]);
        }
        return types;

    }

    @Override
    public String toString() {
        return this.name();
    }


}
