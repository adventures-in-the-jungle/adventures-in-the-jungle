package io.github.adventures_in_the_jungle.logic.game;

public class Item {
    //Verifies one instance.
    private static final Item INSTANCE = new Item();

    //Count for the items.
    private int itemCount;

    //Inventory limit.
    private String[] items = new String[25];

    //The private constructor for single instance.
    private Item() {
        this.itemCount = 0;
    }

    //Gets the instance for items.
    public static Item getInstance() {
        return INSTANCE;
    }

    // Method to add an item to the array of items.
    public void addItem(String item) {
        String[] newItems = new String[itemCount + 1];
        System.arraycopy(items, 0, newItems, 0, itemCount);
        newItems[itemCount] = item;
        items = newItems;
        itemCount++;
    }

    //Method to remove an item from the array.
    public void removeItem(String item) {
        int index = -1;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equals(item)) {
                index = i;
                //Displays in the console what item was removed.
                System.out.println("You lost: " + item);
                break;
            }
        }
        //This method removes the item from the array and subtracts the item count.
        if (index != -1) {
            String[] newItems = new String[itemCount - 1];
            System.arraycopy(items, 0, newItems, 0, index);
            System.arraycopy(items, index + 1, newItems, index, itemCount - index - 1);
            items = newItems;
            itemCount--;
        }
    }

    //Method to get the ItemCount.
    public int getItemCount() {
        return itemCount;
    }

    //Method to get the items in the array.
    public String[] getItems() {
        return items;
    }
}