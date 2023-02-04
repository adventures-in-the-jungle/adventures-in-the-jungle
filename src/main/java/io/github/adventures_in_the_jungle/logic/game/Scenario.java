package io.github.adventures_in_the_jungle.logic.game;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Scenario Class is different from the Room Class this will hold the Scenario methods,
 * Create Scenario will allow us to set it by calling room points and doing a loop
 * to reiterate through the map and set Scenarios on the points.
 */
public class Scenario {

    private final String scenariotext1 = "You awake on a bed of banana leaves \n" + "All you can remember is you were sent out to check out a noise within the jungle\n" + "You stand up and begin to move.";
    //----D and # indicates DANGEROUS scenarios----
    private final String scenariotext_D1 = "You have fallen into a mud pit and are sinking in!";
    ArrayList<String> choicesScenario_D1 = new ArrayList<String>();
    /**
     * Represents a list of possible scenarios into which the user may enter.
     * Most scenarios will reference at-least two other possible scenarios.
     */
    private ArrayList<Scenario> scenarios;
    /**
     * Represents a list of possible items which the user may pick up/take/grab and/or interact with
     */
    private ArrayList<Item> items;
    /**
     * Represents a list of wild critters which the user may potentially butcher and roast into food.
     */
    private ArrayList<Animal> animals;
    /**
     * Represents the index of the scenario.
     */
    private int currentScenarioIndex;
    /**
     * The main text of the scenario.
     */
    private String scenarioText;
    /**
     * List of choices.
     */
    private ArrayList<String> choices;

    /**
     * Initializes a new instance of Scenario.
     */
    public Scenario() {
        this.scenarios = new ArrayList<Scenario>();
        this.currentScenarioIndex = -1;
    }

    /**
     * Initializes a new instance of Scenario
     *
     * @param scenarioText The main text of the scenario.
     * @param choices      The choices that the user may perform.
     */
    private Scenario(String scenarioText, ArrayList<String> choices) {

        // TODO: Possibly make array for scenario Texts

        this.scenarioText = scenarioText;
        this.choices = choices;
    }

    /**
     * Adds a child Scenario to the Scenario object.
     *
     * @param scenarioText The main text for the scenario.
     * @param choices      The directions in which the player can go throughout the course of the game.
     */
    public void addScenario(String scenarioText, ArrayList<String> choices) {

        Scenario newScenario = new Scenario();
        this.scenarios.add(newScenario);
    }

    /**
     * Removes the previous scenario the player clears.
     */
    public void clearScenario() {
        this.scenarios.clear();
        this.currentScenarioIndex = -1;
    }

    /**
     * Gets what the current scenario is.
     *
     * @return The current scenario to be returned.
     */
    public Scenario getCurrentScenario() {

        return this.scenarios.get(this.currentScenarioIndex);
    }

    /**
     * Sets what the current scenario the player is on.
     *
     * @param scenarioIndex The index to be returned.
     */
    public void setCurrentScenario(int scenarioIndex) {
        this.currentScenarioIndex = scenarioIndex;
    }

    // ------------------------- HOW TO USE -------------------------
//     ArrayList<String> choicesScenario1 = new ArrayList<String>();
//     choicesScenario1.add("WALK NORTH");
//
//    // if chosen creates Look up scenario
//
//     choicesScenario1.add("WALK SOUTH");
//    // if chosen creates Look down scenario
//
//     choicesScenario1.add("WALK EAST");
//    // if chosen creates look left scenario
//
//     choicesScenario1.add("WALK WEST");
    // if chosen creates look right scenario

    // scenarios.addScenario(scenarioText1, choicesScenario1);

    // ------------------------- Example of Scenario Look Left -------------------------
    // ArrayList<String> choicesScenario1Left = new ArrayList<String>();

    // choicesScenario1Left.add("You see path already carved out");  enum of Move
    // clears Scenario and creates new scenario

    // choicesScenario1Left.add("You decide to keep looking around");
    // creates Scenario1 again

    // scenarios.addScenario(scenarioText, choicesScenario1Left);

    /**
     * Grabs Scenario Text to hold.
     *
     * @return scenarioText
     */
    public String getScenarioText() {
        return scenarioText;
    }

    /**
     * Grabs choices to hold on to.
     *
     * @return choices
     */
    public ArrayList<String> getChoices() {

        return choices;
    }
    choicesScenario_D1.add("You throw your rope, it wraps around a tree. You pull yourself out and escape!");
    //removes rope from items and you lose points.
    choicesScenario_D1.add("You try to wiggle your way out");
    scenarios.addScenario(scenariotext_D1,choicesScenario_D1);

    // ArrayList<String> choicesScenario_D1 = new ArrayList<String>();
    //choicesScenario_D1.add("You throw your rope, it wraps around a tree. You pull yourself out and escape!"); enum of USE for ROPE
    //removes rope from items and you lose points.
    //choicesScenario_D1.add("You try to wiggle your way out"); enum of GIVE UP or Struggle
    // scenarios.addScenario(scenariotext_D1, choicesScenario_D1);

    // for logic use the enums for when we want to leave move etc....
    // Each choices text will use an enum command that will control the outcome

}