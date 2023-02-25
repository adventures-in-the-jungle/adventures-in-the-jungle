package io.github.adventures_in_the_jungle.logic.game;

public class Choice {

    private int choiceID;

    private String choiceText;

    private int choiceLeadsTo;

    private int choiceFetchableItem;

    private int choiceUsableItem;

    private String choiceFeedback;

    public Choice(int m_choiceID, String m_choiceText, int m_choiceLeadsTo, int m_choiceFetchableItem, int m_choiceUsableItem, String m_choiceFeedback)
    {
        this.choiceID = m_choiceID;
        this.choiceText = m_choiceText;
        this.choiceLeadsTo = m_choiceLeadsTo;
        this.choiceUsableItem = m_choiceFetchableItem;
        this.choiceUsableItem = m_choiceUsableItem;
        this.choiceFeedback = m_choiceFeedback;
    }

    public int getChoiceID() {
        return choiceID;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public int getChoiceLeadsTo() {
        return choiceLeadsTo;
    }

    public Scenario getChoiceLeadsToObject()
    {
        Game game = Game.getInstance();
        Scenario scenario = game.scenarioHashMap.get(this.getChoiceID());

        return scenario;
    }

    public int getChoiceFetchableItem() {
        return choiceFetchableItem;
    }

    public Item getChoiceFetchableItemObject()
    {
        Game game = Game.getInstance();
        Item item = game.itemHashMap.get(this.getChoiceFetchableItem());

        return item;
    }
    public int getChoiceUsableItem() {
        return choiceUsableItem;
    }

    public Item getChoiceUsableItemObject()
    {
        Game game = Game.getInstance();
        Item item = game.itemHashMap.get(this.getChoiceUsableItem());

        return item;
    }

    public String getChoiceFeedback() {
        return choiceFeedback;
    }

    @Override
    public String toString()
    {
        return this.choiceID + "," + this.choiceText + "," + this.choiceLeadsTo + "," + this.choiceFetchableItem + "," + this.choiceUsableItem + "," + this.choiceFeedback;
    }

}
