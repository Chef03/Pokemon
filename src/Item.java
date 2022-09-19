public class Item {

    private final String name;
    private final int healingPower;
    private final double weight;

    public Item(String name, int healingPower, double weight) {

        this.name = name;
        this.healingPower = healingPower;
        this.weight = weight;

    }

    public String usageMessage() {

        String formattedWeight = String.format("%.2f", this.weight);
        String message = this.name + " heals " + this.healingPower + "HP.(" + formattedWeight + ")";
        return message;

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
