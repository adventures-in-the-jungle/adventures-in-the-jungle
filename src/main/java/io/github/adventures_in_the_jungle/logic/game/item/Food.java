package io.github.adventures_in_the_jungle.logic.game.item;

import io.github.adventures_in_the_jungle.logic.database.objects.Item;
import io.github.adventures_in_the_jungle.logic.game.item.properties.IStorable;

public class Food extends Item implements IStorable {

    public Food(int m_itemID, String m_itemName, int m_itemDescription) {
        super(m_itemID, m_itemName, m_itemDescription);
    }

}
