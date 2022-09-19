public class Pokemon {

    private String name;
    private final int maxHP;
    private int hp;
    private int ep;

    private Skill skill;

    private final PokeType type;

    private boolean hasFainted;

    public Pokemon(String name, int maxHP, int ep, PokeType type) {

        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.ep = ep;
        this.type = type;

    }


    public void setName(String name) {

        this.name = name;

    }

    public static void alertAttackFailed(String reason) {

        System.out.println("Attack failed. " + reason);


    }

    public void attack(Pokemon defender) {

        if (this.hasFainted) {

            Pokemon.alertAttackFailed(this.name + " has fainted.");

        }

        if (defender.hasFainted) {

            Pokemon.alertAttackFailed(defender.name + " has fainted.");

        }

        if (!this.hasSkill()) {

            Pokemon.alertAttackFailed(this.name + " does not know a skill.");

        }

        if (this.ep < this.skill.getEnergyCost()) {

            Pokemon.alertAttackFailed(this.name + " lacks energy: " + this.ep + "/" + this.skill.getEnergyCost());

        }


        double multiplier = Battle.getMultiplier(this.type, defender.type);

        int damageDone = (int) Math.floor(this.skill.getAP() * multiplier);

        defender.decreaseHP(damageDone);
        this.decreaseEP(this.skill.getEnergyCost());


        String alert = this.name + " uses " + this.skill.getName() + " on " + defender.name + ". ";
        String targetStatus = defender.name + " has " + defender.hp + " HP left. ";

        if (multiplier == 0.5) {
            alert += "It’s not very effective...";
        } else if (multiplier == 2) {
            alert += "It’s super effective!";
        }

        if (defender.hasFainted) {

            targetStatus += defender.name + " faints.";

        }

        System.out.println(alert);
        System.out.println(targetStatus);


    }

    public void decreaseHP(int damage) {

        int finalHp = this.hp - damage;
        if (finalHp < 0) {
            this.hp = 0;
            this.hasFainted = true;
        } else if (isValidHP(finalHp, maxHP)) {
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

    public void useEP(int amount) {

        int finalEP = this.ep - amount;
        if (finalEP >= 0) {

            this.ep = finalEP;

        }

    }

    public void restoreEP() {

        if (!this.hasFainted) {
            int finalEP = this.ep + 25;
            finalEP = finalEP > 100 ? 100 : finalEP;
            this.ep = finalEP;
        }

    }

    public void heal(int amount) {

        int finalHealth = this.hp + amount;
        finalHealth = finalHealth > this.maxHP ? this.maxHP : finalHealth;

        if (isValidHP(finalHealth, this.maxHP)) {
            this.hp = finalHealth;
        }

    }

    public void rest() {

        if (!this.hasFainted) {
            this.heal(20);
        }

    }

    public void forgetSkill() {

        if (this.hasSkill()) {
            this.skill = null;
        }

    }

    public boolean hasSkill() {

        return this.skill != null;

    }

    public void useItem(Item item) {

        this.heal(item.getHealingPower());
        System.out.println(item.usageMessage());

    }

    public static boolean isValidEP(int ep) {

        return ep <= 100 && ep > 0;

    }


    public PokeType getType() {
        return this.type;
    }

    public int getHP() {
        return this.hp;
    }

    public static boolean isValidHP(int hp, int maxHP) {
        return hp <= maxHP && hp > 0;
    }


}
