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

        return String.format("%s - AP: %d EC: %d", this.name, this.ap, this.ec);

    }
    @Override
    public boolean equals(Object otherObject) {


        if(!(otherObject instanceof Skill)) {
            return false;
        }

        Skill otherSkill = (Skill) otherObject;
        return otherSkill.name.equals(this.name) && otherSkill.ec == this.ec && otherSkill.ap == this.ap;


    }

//    @Override
//    public int hashCode() {
////        return this.
//    }



}
