package io.github.adventures_in_the_jungle.logic.database.objects;

import io.github.adventures_in_the_jungle.logic.game.Game;

/**
 * Represents the ITEM table in the database.
 */
public class Item implements IChoosable {

    /**
     * Represents the primary key of the object.
     */
    private final Integer itemID;

    /**
     * Represents the name of the given item.
     */
    private final String itemName;

    /**
     * Represents the type (or category) of the item in question (foreign key).
     */
    private final Integer itemCategory;

    /**
     * Initializes a new instance of Item.
     *
     * @param m_itemID       The primary key of the object.
     * @param m_itemName     The name of the item.
     * @param m_itemCategory The type (or category) of the new item to be created.
     */
    public Item(int m_itemID, String m_itemName, int m_itemCategory) {
        this.itemID = m_itemID;
        this.itemName = m_itemName;
        this.itemCategory = m_itemCategory;
    }

    /**
     * Gets the value of the item's ID.
     *
     * @return The ID of the item.
     */
    public Integer getItemID() {
        return itemID;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Gets the name of the item (implementation of the IChoosable interface).
     *
     * @return The name of the item.
     */
    @Override
    public String getChoiceText() {
        return this.getItemName();
    }

    /**
     * Gets the category of the item (foreign key).
     *
     * @return The category of the item (foreign key).
     */
    public Integer getItemCategory() {
        return itemCategory;
    }

    /**
     * Gets the category of the item (Java object).
     *
     * @return The category of the item (Java object).
     */
    public ItemCategory getItemCategoryObject() {
        Game game = Game.getInstance();
        ItemCategory result = game.itemCategoryHashMap.get(this.itemCategory);

        return result;
    }

    /**
     * Queries the CSV data contained in the corresponding ITEM database table.
     *
     * @return A String object containing the CSV data.
     */
    @Override
    public String toString() {
        return this.itemID + "," + this.itemName + "," + this.itemCategory;
    }
}