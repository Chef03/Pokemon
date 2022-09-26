package assignment2;

public class Skill {

    private final String name;
    private final int ap;
    private final int ec;

    public Skill(String name, int ap, int ec) {

        this.name = name;
        this.ap = ap;
        this.ec = ec;

    }

    public int getAP() {
        return this.ap;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergyCost() {

        return this.ec;

    }

    @Override
    public String toString() {

        return this.name + " - AP: " + this.ap + " EC: " + this.ec;

    }


}
