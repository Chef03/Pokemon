package assignment2;

public class Item {

    private final String name;
    private final double weight;
    private final int healingPower;

    public Item(String name, int healingPower, double weight) {

        this.name = name;
        this.weight = weight;
        this.healingPower = healingPower;

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

    @Override
    public String toString() {

        return Formatter.printItem(this);

    }

    @Override
    public boolean equals(Object otherObject) {

        if (!(otherObject instanceof Item)) {
            return false;
        }

        Item otherItem = (Item) otherObject;
        return this.name.equals(otherItem.name)
                && this.healingPower == otherItem.healingPower
                && this.weight == otherItem.weight;

    }


}
