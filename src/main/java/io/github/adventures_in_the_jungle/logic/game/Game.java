package io.github.adventures_in_the_jungle.logic.game;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

    /**
     * Singleton instance of the game object.
     */
    private static Game instance = null;

    private Game() {

    }

    public static Game getInstance() {
        if (instance == null) instance = new Game();
        return instance;
    }

    private ArrayList<Scenario> scenarios;
    private ArrayList<Item> inventory;
    private Scenario currentScenario;

}
