package assignment2;

import java.util.Objects;

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
        return String.format(
                "%s heals %d HP. (%s)",
                this.name,
                this.healingPower,
                formattedWeight);

    }

    @Override
    public boolean equals(Object otherObject) {

        if (!(otherObject instanceof Item otherItem)) {
            return false;
        }

        return this.hashCode() == otherItem.hashCode();

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, healingPower, weight);
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
