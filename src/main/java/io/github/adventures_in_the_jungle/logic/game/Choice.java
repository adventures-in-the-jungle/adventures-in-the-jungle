package io.github.adventures_in_the_jungle.logic.game;

public class Choice {

    private int choiceID;

    private String choiceText;

    private int choiceLeadsTo;

    private int choiceFetchableItem;

    private int choiceUsableItem;

    private String choiceFeedback;

    // TODO: Add Object-Relational Mapping for the Scenario associated with a Choice.
    // TODO: Add Object-Relational Mapping for the Item associated with a Choice.

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

    public int getChoiceFetchableItem() {
        return choiceFetchableItem;
    }

    public int getChoiceUsableItem() {
        return choiceUsableItem;
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
