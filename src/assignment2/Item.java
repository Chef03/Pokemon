package assignment2;

public class Item {

    private final String name;
    private final int healingPower;
    private final double weight;

    public Item(String name, int healingPower, double weight) {

        this.name = name;
        this.healingPower = healingPower;
        this.weight = weight;

    }

    @Override
    public String toString() {

        String formattedWeight = String.format("%.2f", (Math.floor(this.weight * 100) / 100));
        return this.name + " heals " + this.healingPower + " HP. (" + formattedWeight + ")";

    }

    @Override
    public boolean equals(Object otherObject) {

        if (otherObject == null || !(otherObject instanceof Item otherItem)) {
            return false;
        }

        return this.name.equals(otherItem.name) && this.weight == otherItem.weight && this.healingPower == otherItem.healingPower;

    }

    public int getHealingPower() {
        return this.healingPower;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

}
