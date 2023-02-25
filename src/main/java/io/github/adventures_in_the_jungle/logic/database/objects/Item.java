package io.github.adventures_in_the_jungle.logic.database.objects;

import io.github.adventures_in_the_jungle.logic.game.item.properties.INamable;

public class Item implements INamable {

    private int itemID;

    private String itemName;

    private int itemDescription;

    private ItemCategory itemDescriptionObject;

    public int getItemID() {
        return itemID;
    }

    public Item(int m_itemID, String m_itemName, int m_itemDescription)
    {
        this.itemID = m_itemID;
        this.itemName = m_itemName;
        this.itemDescription = m_itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemDescription() {
        return itemDescription;
    }

    public ItemCategory getItemDescriptionObject() {
        return itemDescriptionObject;
    }

    public void setItemDescriptionObject(ItemCategory itemDescriptionObject) {
        this.itemDescriptionObject = itemDescriptionObject;
    }

    @Override
    public String toString()
    {
        return this.itemID + "," + this.itemName + "," + this.itemDescription;
    }

    @Override
    public String getName() {
        return this.getItemName();
    }
}