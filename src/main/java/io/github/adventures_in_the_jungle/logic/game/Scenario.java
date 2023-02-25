package io.github.adventures_in_the_jungle.logic.game;

import java.util.HashMap;

/**
 * Scenario Class is different from the Room Class this will hold the Scenario methods,
 * Create Scenario will allow us to set it by calling room points and doing a loop
 * to reiterate through the map and set Scenarios on the points.
 */
public class Scenario {

    /**
     * Represents the ID that corresponds to the scenario.
     */
    private final int scenarioID;

    /**
     * Represents the text that corresponds to the scenario.
     * Informs the user of the situation that they are in.
     */
    private final String scenarioText;

    /**
     * Represents whether or not the scenario is an ending scenario.
     */
    private final boolean scenarioIsEnd;

    /**
     * Assuming the scenario IS an ending scenario, this boolean represents
     * whether or not the ending scenario is a winning scenario.
     */
    private final boolean scenarioIsWon;

    public Scenario(int m_scenarioID, String m_scenarioText, boolean m_scenarioIsEnd, boolean m_scenarioIsWon) {
        this.scenarioID = m_scenarioID;
        this.scenarioText = m_scenarioText;
        this.scenarioIsEnd = m_scenarioIsEnd;
        this.scenarioIsWon = m_scenarioIsWon;
    }

    /**
     * Gets the value of scenarioID;
     *
     * @return The value that corresponds to the scenario's ID in the database.
     */
    public int getScenarioID() {
        return this.scenarioID;
    }

    /**
     * Gets the value of the scenario's text.
     *
     * @return The value that corresponds to the text of the scenario.
     */
    public String getScenarioText() {
        return this.scenarioText;
    }

    /**
     * Gets the value of the scenarioIsEnd boolean flag.
     *
     * @return The value that corresponds to whether or not the scenario is an ending scenario (dead end).
     */
    public boolean getScenarioIsEnd() {
        return this.scenarioIsEnd;
    }

    /**
     * Gets the value that corresponds to the scenarioIsWon boolean flag.
     *
     * @return The value that corresponds to whether or not the ending scenario is a winning scenario.
     */
    public boolean getScenarioIsWon() {
        return this.scenarioIsWon;
    }

    /**
     * Method that pulls in the Choice objects that correspond to the current object's scenarioID.
     *
     * @return A map containing the choices that correspond to the current ID of Scenario.
     */
    public HashMap<Integer, Choice> getChoiceCollection() {
        Game game = Game.getInstance();

        HashMap<Integer, Choice> choiceHashMap = new HashMap<Integer, Choice>();

        for (ScenarioChoice scenarioChoice : game.scenarioChoiceArrayList) {
            // Check to see if the object in the singleton set matches with the ID of the current object.
            if (scenarioChoice.getChoiceID() == this.getScenarioID()) {
                Choice choice = game.choiceHashMap.get(scenarioChoice.getChoiceID());
                choiceHashMap.put(this.getScenarioID(), choice);
            }
        }

        return choiceHashMap;
    }

    /**
     * Method to retrive the CSV-equivalent data of the Scenario class.
     *
     * @return A String containing the CSV data relevant to the current instance of Scenario.
     */
    @Override
    public String toString() {
        return this.scenarioID + "," + this.scenarioText + "," + this.scenarioIsEnd + "," + this.scenarioIsWon;
    }
}