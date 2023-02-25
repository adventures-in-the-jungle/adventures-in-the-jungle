package io.github.adventures_in_the_jungle.logic.game;

import io.github.adventures_in_the_jungle.logic.database.objects.*;
import io.github.adventures_in_the_jungle.logic.game.item.properties.IStorable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Singleton class to manage the current state of the game.
 */
public class Game {

    /**
     * Singleton instance of the game object.
     */
    private static Game instance = null;

    /**
     * Relational mapper for the ITEM_CATEGORY table in the SQLite database.
     */
    public HashMap<Integer, ItemCategory> itemCategoryHashMap;

    /**
     * Relational mapper for the ITEM table in the SQLite database.
     */
    public HashMap<Integer, Item> itemHashMap;

    /**
     * Relational mapper for the SCENARIO table in the SQLite database.
     */
    public HashMap<Integer, Scenario> scenarioHashMap;

    /**
     * Relational mapper for the CHOICE table in the SQLite database.
     */
    public HashMap<Integer, Choice> choiceHashMap;

    /**
     * Relational mapper for the SCENARIO_CHOICE table in the SQLite database.
     */
    public ArrayList<ScenarioChoice> scenarioChoiceArrayList;

    /**
     * Collection to store the current inventory of the player.
     */
    public ArrayList<IStorable> inventory;

    /**
     * Represents the current scenario in which the player is positioned.
     */
    private Scenario currentScenario;

    private Inventory userInventory;

    /**
     * Private constructor to initialize the singleton instance of Game.
     */
    private Game() {

    }

    /**
     * Retrieves the singleton instance of Game.
     *
     * @return The Singleton instance of Game.
     */
    public static Game getInstance() {
        if (instance == null) instance = new Game();
        return instance;
    }
}
