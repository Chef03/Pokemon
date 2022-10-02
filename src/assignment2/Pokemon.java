package assignment2;

public class Pokemon {

    private final PokeType type;
    private final int maxHP;
    private final int maxEP;
    private final int energyRestoreAmount;
    private final int healAmount;
    private String name;
    private int hp;
    private int ep;
    private Skill skill;

    public Pokemon(String name, int maxHP, String type) {

        this.name = name;
        this.type = PokeType.valueOf(type.toUpperCase());
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.maxEP = 100;
        this.ep = this.maxEP;
        this.healAmount = 20;
        this.energyRestoreAmount = 25;
        this.skill = null;

    }

    public String attack(Pokemon target) {

        String warning = Battle.warn(this, target);
        if (warning != null) {
            return warning;
        }

        this.ep = Math.max(this.ep - this.skill.getEnergyCost(), 0);
        double multiplier = Battle.getMultiplier(this, target);
        int damageDone = (int) Math.floor(this.skill.getAP() * multiplier);
        target.hp = Math.max(target.hp - damageDone, 0);
        return Battle.getAttackMessage(this, target);


    }

    public void learnSkill(String name, int ap, int ec) {

        this.skill = new Skill(name, ap, ec);

    }

    public void recoverEnergy() {

        if (!this.hasFainted()) {
            this.ep = Math.min(this.ep + this.energyRestoreAmount, 100);
        }

    }

    public String useItem(Item item) {

        int expectedHP = Math.min(this.hp + item.getHealingPower(), this.maxHP);
        int healAmount = expectedHP - this.hp;
        this.hp = expectedHP;

        return Battle.getItemMessage(this, item, healAmount);

    }

    public void forgetSkill() {

        if (this.knowsSkill()) {

            this.skill = null;

        }

    }


    public boolean knowsSkill() {

        return this.skill != null;

    }

    public void rest() {

        if (!this.hasFainted()) {
            this.hp = Math.min(this.hp + this.healAmount, this.maxHP);
        }

    }

    public boolean hasFainted() {
        return this.hp <= 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {

        this.name = name;

    }

    public String getType() {
        return this.type.toString();
    }

    public Skill getSkill() {
        return this.skill;
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

        return Formatter.printPokemon(this);

    }

    @Override
    public boolean equals(Object otherObject) {

        if (!(otherObject instanceof Pokemon)) {
            return false;
        }

        Pokemon otherPokemon = (Pokemon) otherObject;
        return this.name.equals(otherPokemon.name)
                && this.type.equals(otherPokemon.type)
                && (this.skill == null && otherPokemon.skill == null || this.skill != null && this.skill.equals(otherPokemon.skill))
                && this.hp == otherPokemon.hp
                && this.ep == otherPokemon.ep
                && this.maxHP == otherPokemon.maxHP;

    }


}
