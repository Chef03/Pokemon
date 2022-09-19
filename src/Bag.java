import java.util.ArrayList;

public class Bag {

    public final int maximumWeight;
    private int weight;
    private final ArrayList<Item> items;

    public Bag(int maximumWeight) {

        this.maximumWeight = maximumWeight;
        this.items = new ArrayList();

    }

    public int getWeight() {
        return this.weight;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public Item addItem(Item item) {

        if (item.getWeight() + this.weight > this.maximumWeight) {
            return null;
        }

        if (this.getItemCount() == 0) {
            items.add(item);
        } else {

            Item lastItem = this.items.get(this.getItemCount() - 1);

            if (lastItem.getWeight() > item.getWeight()) {

                this.items.add(item);

            } else {

                for (int i = 0; i < this.getItemCount(); i++) {

                    if (this.items.get(i).getWeight() <= item.getWeight()) {

                        this.items.add(i, item);
                        break;

                    }

                }

            }

        }

        this.weight += item.getWeight();
        return item;

    }

    public Item remove(int index) {

        if (!itemExistsAt(index)) {
            return null;
        }

        this.weight -= this.items.get(index).getWeight();
        return this.items.remove(index);


    }

    public String peek(int index) {

        Item item = this.items.get(index);
        return item.getName(); //for now

    }

    public Item pop() {

        if (this.items.size() == 0) {
            return null;
        }

        return this.items.remove(0);

    }

    private boolean itemExistsAt(int index) {

        return index > this.getItemCount() - 1;

    }


}
