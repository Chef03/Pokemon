package assignment2;


public class Pokemon {

    private String name;
    public final PokeType type;
    private final TypeData typeData;
    private final int maxHP;
    private int hp;
    private final int healAmount;
    private final int maxEP;
    private int ep;
    private Skill skill;

    public Pokemon(String name, int maxHP, String type) {

        this.name = name;
        this.type = PokeType.valueOf(type.toUpperCase());
        this.typeData = TypeData.getType(this.type);
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.healAmount = 20;
        this.maxEP = 100;
        this.ep = this.maxEP;
        this.skill = null;

    }


    public void setName(String name) {

        this.name = name;

    }

    public String getName() {
        return this.name;
    }

    public double getMultiplier(PokeType defenderType) {

        boolean isEffective = this.typeData.effectiveTypes.contains(defenderType);
        boolean isNotEffective = this.typeData.ineffectiveTypes.contains(defenderType);

        if (isEffective) {
            return 2;
        } else if (isNotEffective) {
            return 0.5;
        }
        return 1;

    }

    public String attack(Pokemon defender) {

//        if (this.hasFainted) {
//
//            return this.name + " has fainted.";
//
//        }
//
        if (defender.hasFainted()) {

            return defender.name + " has fainted.";

        }
//
//        if (!this.knowsSkill()) {
//
//            return this.name + " does not know a skill.";
//
//        }
//
//        if (this.ep < this.skill.getEnergyCost()) {
//
//            return this.name + " lacks energy: " + this.ep + "/" + this.skill.getEnergyCost();
//
//        }


        this.useSkill();
        double multiplier = this.doDamage(defender);

        String alert = String.format("%s uses %s on %s.", this.name, this.skill.getName(), defender.name);
        String targetStatus = String.format("%s has %d HP left.", defender.name, defender.hp);

        if (multiplier == 0.5) {
            alert += " It is not very effective...";
        }

        else if (multiplier == 2) {
            alert += " It is super effective!";
        }

        if (defender.hasFainted()) {
            targetStatus += String.format(" %s faints.", defender.name);
        }

        return alert + System.lineSeparator() + targetStatus;


    }

    public double doDamage(Pokemon defender) {

        double multiplier = this.getMultiplier(defender.type);
        int damageDone = (int) Math.floor(this.skill.getAP() * multiplier);
        defender.hp = Math.max(defender.hp - damageDone, 0);
        return multiplier;

    }

    public void learnSkill(String name, int ap, int ec) {

        this.skill = new Skill(name, ap, ec);

    }


    public void recoverEnergy() {

        if (this.hasFainted()) return;
        this.ep = Math.min(this.ep + 25, 100);

    }

    public void heal() {

        this.hp = Math.min(this.hp + this.healAmount, this.maxHP);

    }

    private int itemHeal(Item item) {

        int initialHP = this.hp;
        this.hp = Math.min(this.hp + item.getHealingPower(), this.maxHP);
        return this.hp - initialHP;

    }

    public String useItem(Item item) {

        if (this.hp >= this.maxHP) {
            return String.format("%s could not use %s. HP is already full.", this.name, item.getName());
        }
        int healAmount = this.itemHeal(item);
        return String.format("%s used %s. It healed %d HP.", this.name, item.getName(), healAmount);

    }


    public void useSkill() {
        this.ep = Math.max(this.ep - this.skill.getEnergyCost(), 0);
    }

    public void forgetSkill() {

        if (!this.knowsSkill()) return;
        this.skill = null;

    }

    public boolean knowsSkill() {

        return this.skill != null;

    }


    public void rest() {

        if (this.hasFainted()) return;
        this.heal();


    }

    private boolean hasFainted() {
        return this.hp <= 0;
    }

    public String getType() {
        return this.type.toString();
    }

    public int getCurrentHP() {
        return this.hp;
    }

    public int getEnergy() {
        return this.ep;
    }

    public int getMAX_HP() {
        return this.maxHP;
    }

    @Override
    public String toString() {


        if (!this.knowsSkill()) {

            return String.format("%s (%s)", this.name, this.type);

        }

        return String.format(
                "%s (%s). Knows %s - AP: %d EC: %d",
                this.name,
                this.type,
                this.skill.getName(),
                this.skill.getAP(),
                this.skill.getEnergyCost()
        );


    }


    @Override
    public boolean equals(Object otherObject) {

        if (!(otherObject instanceof Pokemon)) {
            return false;
        }

        Pokemon otherPokemon = (Pokemon) otherObject;

        return this.name.equals(otherPokemon.name)
                && this.type.equals(otherPokemon.type)
                && (this.skill == null && otherPokemon.skill == null || this.skill.equals(otherPokemon.skill))
                && this.hp == otherPokemon.hp
                && this.ep == otherPokemon.ep
                && this.maxHP == otherPokemon.maxHP;

    }




}
