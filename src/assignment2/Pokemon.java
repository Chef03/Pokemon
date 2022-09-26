package assignment2;


public class Pokemon {

    private String name;
    private final int maxHP;
    private int hp;
    private int ep = 100;
    private Skill skill;
    private final PokeType type;
    private boolean hasFainted = false;

    public Pokemon(String name, int maxHP, String type) {

        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.type = PokeType.valueOf(type);

    }


    public void setName(String name) {

        this.name = name;

    }

    public String getName() {
        return this.name;
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


        double multiplier = Battle.getMultiplier(this.type, defender.type);
        int damageDone = (int) Math.floor(this.skill.getAP() * multiplier);

        defender.decreaseHP(damageDone);
        this.decreaseEP(this.skill.getEnergyCost());

        String alert = this.name + " uses " + this.skill.getName() + " on " + defender.name + ".";
        String targetStatus = defender.name + " has " + defender.hp + " HP left.";

        if (multiplier == 0.5) {
            alert += " It is not very effective...";
        } else if (multiplier == 2) {
            alert += " It is super effective!";
        }

        if (defender.hasFainted) {

            targetStatus += String.format(" %s faints.", defender.name);

        }

        return alert + System.lineSeparator() + targetStatus;


    }

    public void decreaseHP(int damage) {

        int finalHp = this.hp - damage;
        if (finalHp < 0) {
            this.hp = 0;
            this.hasFainted = true;
        } else {
            this.hp = finalHp;
        }

    }

    public void decreaseEP(int consumedEP) {

        int finalEp = this.ep - consumedEP;
        if (Pokemon.isValidEP(finalEp)) {
            this.ep = finalEp;
        }

    }

    public void learnSkill(String name, int ap, int ec) {

        this.skill = new Skill(name, ap, ec);

    }


    public void recoverEnergy() {

        if (!this.hasFainted) {
            int finalEP = this.ep + 25;
            finalEP = Math.min(finalEP, 100);
            this.ep = finalEP;
        }

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

    public void rest() {

        if (!this.hasFainted) {
            this.heal(20);
        }

    }

    public void forgetSkill() {

        if (this.knowsSkill()) {
            this.skill = null;
        }

    }

    public boolean knowsSkill() {

        return this.skill != null;

    }

    public String useItem(Item item) {

        if (this.hp >= this.maxHP) {
            return String.format("%s could not use %s. HP is already full.", this.name, item.getName());
        }
        int healingAmount = this.heal(item.getHealingPower());
        return String.format("%s used %s. It healed %d HP.", this.name, item.getName(), healingAmount);

    }

    public static boolean isValidEP(int ep) {

        return ep <= 100 && ep > 0;

    }


    public String getType() { return this.type.toString(); }

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

        return otherPokemon.name.equals(this.name)
                && otherPokemon.type.equals(this.type)
                && otherPokemon.hp == this.hp
                && otherPokemon.maxHP == this.maxHP
                && otherPokemon.ep == this.ep;


    }


}
