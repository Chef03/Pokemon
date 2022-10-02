package assignment2;

public class Skill {

    private final String name;
    private final int ec;
    private final int ap;

    public Skill(String name, int ap, int ec) {

        this.name = name;
        this.ec = ec;
        this.ap = ap;

    }

    public String getName() {
        return this.name;
    }

    public int getAP() {
        return this.ap;
    }

    public int getEnergyCost() {
        return this.ec;
    }

    @Override
    public String toString() {

        return Formatter.printSkill(this);

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
