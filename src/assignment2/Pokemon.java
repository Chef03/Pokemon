package assignment2;

import java.util.Objects;

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

        if (this.typeData.effectiveTypes.contains(defenderType)) {
            return 2;
        } else if (this.typeData.ineffectiveTypes.contains(defenderType)) {
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
//        if (defender.hasFainted) {
//
//            return defender.name + " has fainted.";
//
//        }
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


        double multiplier = this.getMultiplier(defender.type);

//        System.out.println(String.format("Attacker: %s attacked %s multiplier: %f", this.type, defender.type,  multiplier));

        int damageDone = (int) Math.floor(this.skill.getAP() * multiplier);

        defender.decreaseHP(damageDone);
        this.decreaseEP(this.skill.getEnergyCost());

        String alert = String.format("%s uses %s on %s.", this.name, this.skill.getName(), defender.name);
        String targetStatus = String.format("%s has %d HP left.", defender.name, defender.hp);

        if (multiplier == 0.5) {
            alert += " It is not very effective...";
        } else if (multiplier == 2) {
            alert += " It is super effective!";
        }

        if (defender.hasFainted()) {

            targetStatus += String.format(" %s faints.", defender.name);

        }

        return alert + System.lineSeparator() + targetStatus;


    }

    public void decreaseHP(int damage) {

        int finalHp = this.hp - damage;
        this.hp = Math.max(finalHp, 0);

    }

    public void decreaseEP(int consumedEP) {

        int finalEp = this.ep - consumedEP;
        if (this.isValidEP(finalEp)) {
            this.ep = finalEp;
        }

    }

    public void learnSkill(String name, int ap, int ec) {

        this.skill = new Skill(name, ap, ec);

    }


    public void recoverEnergy() {

        if (this.hasFainted()) return;

        int finalEP = this.ep + 25;
        finalEP = Math.min(finalEP, 100);
        this.ep = finalEP;


    }

    public int heal(int amount) {

        int amountHealed = amount;
        int finalHealth = this.hp + amount;

        if (finalHealth > this.maxHP) {
            amountHealed = this.maxHP - this.hp;
            this.hp = this.maxHP;
        } else {
            this.hp = finalHealth;
        }

        return amountHealed;

    }


    public String useItem(Item item) {

        if (this.hp >= this.maxHP) {
            return String.format("%s could not use %s. HP is already full.", this.name, item.getName());
        }
        int healingAmount = this.heal(item.getHealingPower());
        return String.format("%s used %s. It healed %d HP.", this.name, item.getName(), healingAmount);

    }

    public void forgetSkill() {


        if (!this.knowsSkill()) return;
        this.skill = null;


    }

    public boolean knowsSkill() {

        return this.skill != null;

    }

    public boolean isValidEP(int ep) {

        return ep <= this.maxEP && ep > 0;

    }

    public void rest() {

        if (this.hasFainted()) return;
        this.heal(this.healAmount);


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

        if (!(otherObject instanceof Pokemon otherPokemon)) {
            return false;
        }

        return otherPokemon.hashCode() == this.hashCode();

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, maxHP, skill);
    }


}
