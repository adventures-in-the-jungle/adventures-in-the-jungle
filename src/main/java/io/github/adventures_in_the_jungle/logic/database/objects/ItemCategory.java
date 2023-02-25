package io.github.adventures_in_the_jungle.logic.game;

public class ItemCategory {

    /**
     * Represents the primary key of the item category in the database.
     */
    private final int itemCategoryID;

    /**
     * Represents the name of the item category.
     */
    private final String itemCategoryName;

    /**
     * Represents the description for the item category.
     * Provides a reason for existence for the item category in the database (like a database code comment, in a manner
     * of speaking).
     */
    private final String itemCategoryDescription;

    /**
     * Initializes a new instance of ItemCategory/
     *
     * @param m_itemCategoryID          The ID that corresponds to the primary key in the database.
     * @param m_itemCategoryName        The name for the item category (ie 'weapon', 'food', etc.)
     * @param m_itemCategoryDescription The reason the item category exists.
     */
    public ItemCategory(int m_itemCategoryID, String m_itemCategoryName, String m_itemCategoryDescription) {
        this.itemCategoryID = m_itemCategoryID;
        this.itemCategoryName = m_itemCategoryName;
        this.itemCategoryDescription = m_itemCategoryDescription;
    }

    /**
     * Gets the value contained in itemCategoryID.
     *
     * @return The value in itemCategoryID.
     */
    public int getItemCategoryID() {
        return itemCategoryID;
    }

    /**
     * Gets the value contained in itemCategoryName.
     *
     * @return The value in itemCategoryName.
     */
    public String getItemCategoryName() {
        return itemCategoryName;
    }

    /**
     * Gets the value contained in itemCategoryDescription.
     *
     * @return The value in itemCategoryDescription.
     */
    public String getItemCategoryDescription() {
        return itemCategoryDescription;
    }

    @Override
    public String toString()
    {
        return this.itemCategoryID + "," + this.itemCategoryName + "," + this.itemCategoryDescription;
    }
}
