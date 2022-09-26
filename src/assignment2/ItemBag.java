package assignment2;

import java.util.ArrayList;

public class ItemBag {

    public final double maximumWeight;
    private double weight;
    private final ArrayList<Item> items;

    public ItemBag(double maximumWeight) {

        this.maximumWeight = maximumWeight;
        this.items = new ArrayList<>();

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

    public int addItem(Item item) {

        if (Math.round(item.getWeight()) + this.weight > this.maximumWeight) {
            return -1;
        }

        if (this.getNumOfItems() == 0) {
            items.add(item);
        } else {

            Item lastItem = this.items.get(this.getNumOfItems() - 1);

            if (lastItem.getWeight() > item.getWeight()) {

                this.items.add(item);

            } else {

                for (int i = 0; i < this.getNumOfItems(); i++) {

                    if (this.items.get(i).getWeight() <= item.getWeight()) {

                        this.items.add(i, item);
                        break;

                    }

                }

            }

        }

        this.weight += item.getWeight();
        return this.items.indexOf(item);

    }

    public Item removeItemAt(int index) {

        if (!this.itemDoesExist(index)) {
            return null;
        }
        Item item = this.items.get(index);
        this.weight -= item.getWeight();
        this.items.remove(index);
        return item;

    }

    public String peekItemAt(int index) {

        if (!this.itemDoesExist(index)) {
            return "";
        }
        Item item = this.items.get(index);
        return item.toString(); //for now

    }

    public Item popItem() {

        if (this.items.size() == 0) {
            return null;
        }
        this.weight -= this.items.get(0).getWeight();
        return this.items.remove(0);

    }


    private boolean itemDoesExist(int index) {
        return index <= this.items.size() - 1 && index >= 0;
    }


}
