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

    public String getName() {
        return this.name;
    }
    public int getAP() {
        return this.ap;
    }
    public int getEnergyCost() { return this.ec; }

    @Override
    public String toString() {

        return String.format("%s - AP: %d EC: %d", this.name, this.ap, this.ec);

    }

    @Override
    public boolean equals(Object otherObject) {

        if (!(otherObject instanceof Skill)) {
            return false;
        }

        Skill otherSkill = (Skill) otherObject;
        return this.name.equals(otherSkill.name)
                && this.ap == otherSkill.ap
                && this.ec == otherSkill.ec;

    }



}
