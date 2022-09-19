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


}
