package io.github.adventures_in_the_jungle.logic.database.objects;

import io.github.adventures_in_the_jungle.logic.game.Game;

/**
 * Represents an entity in the CHOICE table of the database.
 */
public class Choice implements IChoosable {

    /**
     * Represents the primary key of the choice.
     */
    private final Integer choiceID;

    /**
     * Represents the text of the choice to be prompted to the user.
     */
    private final String choiceText;

    /**
     * Represents the scenario which the choice will lead to (foreign key).
     */
    private final Integer choiceLeadsTo;

    /**
     * Represents a fetchable item within the choice (foreign key).
     */
    private final Integer choiceFetchableItem;

    /**
     * Represents a type of item that is required for the current choice to be taken.
     */
    private final Integer choiceUsableItemCategory;

    /**
     * Represents some optional text that will be displayed to the user after the successful completion of a choice.
     */
    private final String choiceFeedback;

    /**
     * Initializes a new instance of Choice.
     *
     * @param m_choiceID            The choiceID for the new Choice.
     * @param m_choiceText          The choiceText for the new Choice.
     * @param m_choiceLeadsTo       The choiceLeadsTo for the new Choice.
     * @param m_choiceFetchableItem The choiceFetchableItem for the new Choice.
     * @param m_choiceUsableItem    The choiceUsableItemCategory for the new Choice.
     * @param m_choiceFeedback      The choiceFeedback for the new Choice.
     */
    public Choice(int m_choiceID, String m_choiceText, int m_choiceLeadsTo, int m_choiceFetchableItem, int m_choiceUsableItem, String m_choiceFeedback) {
        this.choiceID = m_choiceID;
        this.choiceText = m_choiceText;
        this.choiceLeadsTo = m_choiceLeadsTo;
        this.choiceFetchableItem = m_choiceFetchableItem;
        this.choiceUsableItemCategory = m_choiceUsableItem;
        this.choiceFeedback = m_choiceFeedback;
    }

    /**
     * Gets the value contained in choiceID.
     *
     * @return The choiceID to be returned.
     */
    public Integer getChoiceID() {
        return choiceID;
    }

    /**
     * Gets the value contained in choiceText.
     *
     * @return The choiceText to be returned.
     */
    @Override
    public String getChoiceText() {
        return choiceText;
    }

    /**
     * Gets the value contained in choiceLeadsTo (foreign key).
     *
     * @return The choiceLeadsTo to be returned.
     */
    public Integer getChoiceLeadsTo() {
        return choiceLeadsTo;
    }

    /**
     * Gets the object that corresponds to the choiceLeadsTo (object relational mapper).
     *
     * @return The Scenario to be returned.
     */
    public Scenario getChoiceLeadsToObject() {
        Game game = Game.getInstance();
        Scenario scenario = game.scenarioHashMap.get(this.getChoiceID());

        return scenario;
    }

    /**
     * Gets the value contained in choiceFetchableItem (foreign key).
     *
     * @return The choiceFetchableItem to be returned.
     */
    public Integer getChoiceFetchableItem() {
        return choiceFetchableItem;
    }

    /**
     * Gets the object that corresponds to the choiceFetchableItem (object relational mapper).
     *
     * @return The Item to be returned.
     */
    public Item getChoiceFetchableItemObject() {
        Game game = Game.getInstance();
        Item item = game.itemHashMap.get(this.getChoiceFetchableItem());

        return item;
    }

    /**
     * Gets the value contained in choiceUsableItemCategory (foreign key).
     *
     * @return The choiceUsableItemCategory to be returned.
     */
    public Integer getChoiceUsableCategory() {
        return choiceUsableItemCategory;
    }

    /**
     * Gets the object that corresponds to the choiceUsableItemCategory (object relational mapper for choiceUsableItemCategory).
     *
     * @return The ItemCategory object to be returned.
     */
    public ItemCategory getChoiceUsableItemCategoryObject() {
        Game game = Game.getInstance();
        ItemCategory item = game.itemCategoryHashMap.get(this.getChoiceUsableCategory());

        return item;
    }

    /**
     * Gets the value contained in choiceFeedback.
     *
     * @return The choiceFeedback to be returned.
     */
    public String getChoiceFeedback() {
        return choiceFeedback;
    }

    /**
     * Queries the CSV data contained in the corresponding ITEM database table.
     *
     * @return A String object containing the CSV data.
     */
    @Override
    public String toString() {
        return this.choiceID + "," + this.choiceText + "," + this.choiceLeadsTo + "," + this.choiceFetchableItem + "," + this.choiceUsableItemCategory + "," + this.choiceFeedback;
    }

}
