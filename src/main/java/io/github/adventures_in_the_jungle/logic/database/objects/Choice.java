package io.github.adventures_in_the_jungle.logic.database.objects;

import io.github.adventures_in_the_jungle.logic.game.Game;

public class Choice implements IChoosable {

    private final Integer choiceID;

    private final String choiceText;

    private final Integer choiceLeadsTo;

    private final Integer choiceFetchableItem;

    private final Integer choiceUsableItemCategory;

    private final String choiceFeedback;

    public Choice(int m_choiceID, String m_choiceText, int m_choiceLeadsTo, int m_choiceFetchableItem, int m_choiceUsableItem, String m_choiceFeedback) {
        this.choiceID = m_choiceID;
        this.choiceText = m_choiceText;
        this.choiceLeadsTo = m_choiceLeadsTo;
        this.choiceFetchableItem = m_choiceFetchableItem;
        this.choiceUsableItemCategory = m_choiceUsableItem;
        this.choiceFeedback = m_choiceFeedback;
    }

    public Integer getChoiceID() {
        return choiceID;
    }

    @Override
    public String getChoiceText() {
        return choiceText;
    }

    public Integer getChoiceLeadsTo() {
        return choiceLeadsTo;
    }

    public Scenario getChoiceLeadsToObject() {
        Game game = Game.getInstance();
        Scenario scenario = game.scenarioHashMap.get(this.getChoiceID());

        return scenario;
    }

    public Integer getChoiceFetchableItem() {
        return choiceFetchableItem;
    }

    public Item getChoiceFetchableItemObject() {
        Game game = Game.getInstance();
        Item item = game.itemHashMap.get(this.getChoiceFetchableItem());

        return item;
    }

    public Integer getChoiceUsableCategory() {
        return choiceUsableItemCategory;
    }

    public ItemCategory getChoiceUsableItemCategoryObject() {
        Game game = Game.getInstance();
        ItemCategory item = game.itemCategoryHashMap.get(this.getChoiceUsableCategory());

        return item;
    }

    public String getChoiceFeedback() {
        return choiceFeedback;
    }

    @Override
    public String toString() {
        return this.choiceID + "," + this.choiceText + "," + this.choiceLeadsTo + "," + this.choiceFetchableItem + "," + this.choiceUsableItemCategory + "," + this.choiceFeedback;
    }

}
