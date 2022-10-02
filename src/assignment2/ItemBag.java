package assignment2;

import java.util.ArrayList;

public class ItemBag {

    private final double maximumWeight;
    private final ArrayList<Item> items;
    private double weight;

    public ItemBag(double maximumWeight) {

        this.weight = 0;
        this.maximumWeight = maximumWeight;
        this.items = new ArrayList<>();

    }

    public int addItem(Item item) {

        if (item.getWeight() + this.weight > this.maximumWeight) {
            return -1;
        }

        if (this.items.size() < 1 || this.items.get(this.items.size() - 1).getWeight() > item.getWeight()) {

            items.add(item);

        } else {

            int i = 0;
            int itemAmount = this.getNumOfItems();

            do {
                if (this.items.get(i).getWeight() <= item.getWeight()) {
                    this.items.add(i, item);
                } else {
                    i++;
                }

            }
            while (this.items.size() <= itemAmount);

        }

        this.weight += item.getWeight();
        return items.indexOf(item);

    }

    public Item removeItemAt(int index) {

        if (!this.itemExistsAt(index)) {
            return null;
        }
        Item item = this.items.get(index);
        this.weight -= item.getWeight();
        this.items.remove(index);
        return item;

    }

    public String peekItemAt(int index) {

        if (!this.itemExistsAt(index)) {
            return "";
        }
        Item item = this.items.get(index);
        return item.toString();

    }

    public Item popItem() {

        if (this.items.size() < 1) {
            return null;
        }
        this.weight -= this.items.get(0).getWeight();
        return this.items.remove(0);

    }

    private boolean itemExistsAt(int index) {
        return index >= 0 && index <= this.items.size() - 1;
    }

    public double getCurrentWeight() {
        return this.weight;
    }

    public double getMaxWeight() {
        return this.maximumWeight;
    }

    public int getNumOfItems() {
        return this.items.size();
    }

}
