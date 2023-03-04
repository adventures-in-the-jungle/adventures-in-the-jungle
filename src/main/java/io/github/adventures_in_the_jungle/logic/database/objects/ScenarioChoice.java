package io.github.adventures_in_the_jungle.logic.database.objects;

public class ScenarioChoice {

    private final Integer scenarioID;

    private final Integer choiceID;

    public ScenarioChoice(int m_scenarioID, int m_choiceID) {
        this.scenarioID = m_scenarioID;
        this.choiceID = m_choiceID;
    }

    public int getScenarioID() {
        return scenarioID;
    }

    public int getChoiceID() {
        return choiceID;
    }

    @Override
    public String toString() {
        return this.scenarioID + "," + this.choiceID;
    }
}
