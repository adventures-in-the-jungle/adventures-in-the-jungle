package io.github.adventures_in_the_jungle.logic.initialization;

import io.github.adventures_in_the_jungle.Main;
import io.github.adventures_in_the_jungle.logic.database.DatabaseConnection;
import io.github.adventures_in_the_jungle.logic.game.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that contains helper methods to get a game up and running.
 */
public abstract class Setup {

    /**
     * Represents the logger object associated with the class.
     */
    private static final Logger logger = LogManager.getLogger(Setup.class);

    /**
     * Utility function to set up the initial file structure for the program if it doesn't already exist.
     *
     * @throws Exception Thrown if either the default directory failed to create or the template database file failed to copy.
     */
    public static void FirstTimeSetup() throws Exception {
        // Checks if the user home directory exists. If not, create it.
        File appStorageDirectory = new File(AppStoragePaths.GetAppStorageDir());
        if (!appStorageDirectory.exists()) {
            appStorageDirectory.mkdir();
        }

        File databaseFile = new File(AppStoragePaths.GetDBFilePath());
        if (!databaseFile.exists()) {
            Files.copy(Main.class.getResourceAsStream("/default.db"), Paths.get(AppStoragePaths.GetDBFilePath()));
        }
    }

    /**
     * Utility function to populate the passed in game object with collections that correspond to the objects in the database.
     * This method represents the object-relational-mapper code and is called once soon after the application is started.
     *
     * @param m_game The passed-in singleton instance of Game.
     */
    public static void SQLSetup(Game m_game) {

        String connectionString = AppStoragePaths.GetDBConnectionString();
        logger.debug("DB Connection String: " + connectionString);

        DatabaseConnection databaseConnection = new DatabaseConnection();

        m_game.itemCategoryHashMap = getItemCategoryHashMap(databaseConnection);

        for (Map.Entry<Integer, ItemCategory> itemCategory : m_game.itemCategoryHashMap.entrySet()) {
            System.out.println("itemCategoryHashMap Key: " + itemCategory.getKey());
            System.out.println("itemCategoryHashMap Value: " + itemCategory.getValue());
        }

        m_game.itemHashMap = getItemHashMap(databaseConnection);

        for (Map.Entry<Integer, Item> item : m_game.itemHashMap.entrySet()) {
            System.out.println("itemHashMap Key: " + item.getKey());
            System.out.println("itemHashMap Value: " + item.getValue());
        }

        m_game.scenarioHashMap = getScenarioHashMap(databaseConnection);

        for (Map.Entry<Integer, Scenario> scenario : m_game.scenarioHashMap.entrySet()) {
            System.out.println("scenarioHashMap Key: " + scenario.getKey());
            System.out.println("scenarioHashMap Value: " + scenario.getValue());
        }

        m_game.choiceHashMap = getChoiceHashMap(databaseConnection);

        for (Map.Entry<Integer, Choice> choice : m_game.choiceHashMap.entrySet()) {
            System.out.println("choiceHashMap Key: " + choice.getKey());
            System.out.println("choiceHashMap Value: " + choice.getValue());
        }

        m_game.scenarioChoiceArrayList = getScenarioChoiceArrayList(databaseConnection);

        for (ScenarioChoice scenarioChoice : m_game.scenarioChoiceArrayList) {
            System.out.println(scenarioChoice.toString());
        }
    }

    /**
     * Helper method to create a map of ItemCategory objects based on the values contained in the ITEM_CATEGORY table.
     *
     * @param m_databaseConnection The active connection called from the {@link #SQLSetup(Game) SQLSetup} method.
     * @return The populated map of ItemCategory objects.
     */
    private static HashMap<Integer, ItemCategory> getItemCategoryHashMap(DatabaseConnection m_databaseConnection) {
        if (m_databaseConnection == null) m_databaseConnection = new DatabaseConnection();

        HashMap<Integer, ItemCategory> hashMap = new HashMap<Integer, ItemCategory>();

        m_databaseConnection.setActiveQuery("SELECT * FROM ITEM_CATEGORY");
        ResultSet resultSet = m_databaseConnection.executeActiveQuery();

        try {
            while (resultSet.next()) {
                int itemCategoryId = resultSet.getInt("ITEM_CATEGORY_ID");
                String itemCategoryName = resultSet.getString("CATEGORY_NAME");
                String itemCategoryDescription = resultSet.getString("CATEGORY_DESCRIPTION");

                ItemCategory itemCategory = new ItemCategory(itemCategoryId, itemCategoryName, itemCategoryDescription);
                hashMap.put(itemCategoryId, itemCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        m_databaseConnection.close();
        return hashMap;
    }

    /**
     * Helper method to create a map of Item objects based on the values contained in the ITEM table.
     *
     * @param m_databaseConnection The active connection called from the {@link #SQLSetup(Game) SQLSetup} method.
     * @return The populated map of Item objects.
     */
    private static HashMap<Integer, Item> getItemHashMap(DatabaseConnection m_databaseConnection) {
        if (m_databaseConnection == null) m_databaseConnection = new DatabaseConnection();

        HashMap<Integer, Item> hashMap = new HashMap<Integer, Item>();

        m_databaseConnection.setActiveQuery("SELECT * FROM ITEM");
        ResultSet resultSet = m_databaseConnection.executeActiveQuery();

        try {
            while (resultSet.next()) {
                int itemID = resultSet.getInt("ITEM_ID");
                String itemName = resultSet.getString("ITEM_NAME");
                int itemDescription = resultSet.getInt("ITEM_DESCRIPTION");

                Item itemCategory = new Item(itemID, itemName, itemDescription);
                hashMap.put(itemID, itemCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        m_databaseConnection.close();
        return hashMap;
    }

    /**
     * Helper method to create a map of Scenario objects based on the values contained in the SCENARIO table.
     *
     * @param m_databaseConnection The active connection called from the {@link #SQLSetup(Game) SQLSetup} method.
     * @return The populated map of Scenario objects.
     */
    private static HashMap<Integer, Scenario> getScenarioHashMap(DatabaseConnection m_databaseConnection) {
        if (m_databaseConnection == null) m_databaseConnection = new DatabaseConnection();

        HashMap<Integer, Scenario> hashMap = new HashMap<Integer, Scenario>();

        m_databaseConnection.setActiveQuery("SELECT * FROM SCENARIO");
        ResultSet resultSet = m_databaseConnection.executeActiveQuery();

        try {
            while (resultSet.next()) {
                // INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON)
                int scenarioID = resultSet.getInt("SCENARIO_ID");
                String scenarioText = resultSet.getString("SCENARIO_TEXT");
                boolean scenarioIsEnd = resultSet.getBoolean("SCENARIO_IS_END");
                boolean scenarioPlayerWon = resultSet.getBoolean("SCENARIO_PLAYER_WON");

                Scenario scenario = new Scenario(scenarioID, scenarioText, scenarioIsEnd, scenarioPlayerWon);
                hashMap.put(scenarioID, scenario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        m_databaseConnection.close();
        return hashMap;
    }

    /**
     * Helper method to create a map of Choice objects based on the values contained in the CHOICE table.
     *
     * @param m_databaseConnection The active connection called from the {@link #SQLSetup(Game) SQLSetup} method.
     * @return The populated map of Choice objects.
     */
    private static HashMap<Integer, Choice> getChoiceHashMap(DatabaseConnection m_databaseConnection) {
        if (m_databaseConnection == null) m_databaseConnection = new DatabaseConnection();

        HashMap<Integer, Choice> hashMap = new HashMap<Integer, Choice>();

        m_databaseConnection.setActiveQuery("SELECT * FROM CHOICE");
        ResultSet resultSet = m_databaseConnection.executeActiveQuery();

        try {
            while (resultSet.next()) {
                // INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK)
                int choiceID = resultSet.getInt("CHOICE_ID");
                String choiceText = resultSet.getString("CHOICE_TEXT");
                int choiceLeadsTo = resultSet.getInt("CHOICE_LEADS_TO");
                int choiceFetchableItem = resultSet.getInt("CHOICE_FETCHABLE_ITEM");
                int choiceUsableItem = resultSet.getInt("CHOICE_USABLE_ITEM");
                String choiceFeedback = resultSet.getString("CHOICE_FEEDBACK");

                Choice choice = new Choice(choiceID, choiceText, choiceLeadsTo, choiceFetchableItem, choiceUsableItem, choiceFeedback);
                hashMap.put(choiceID, choice);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        m_databaseConnection.close();
        return hashMap;
    }

    /**
     * Helper method to create a set of ScenarioChoice objects based on the values contained in the SCENARIO_CHOICE table.
     *
     * @param m_databaseConnection The active connection called from the {@link #SQLSetup(Game) SQLSetup} method.
     * @return The populated set of ScenarioChoice objects.
     */
    private static ArrayList<ScenarioChoice> getScenarioChoiceArrayList(DatabaseConnection m_databaseConnection) {
        if (m_databaseConnection == null) m_databaseConnection = new DatabaseConnection();

        ArrayList<ScenarioChoice> arrayList = new ArrayList<ScenarioChoice>();

        m_databaseConnection.setActiveQuery("SELECT * FROM SCENARIO_CHOICE");
        ResultSet resultSet = m_databaseConnection.executeActiveQuery();

        try {
            while (resultSet.next()) {
                int scenarioID = resultSet.getInt("SCENARIO_ID");
                int choiceID = resultSet.getInt("CHOICE_ID");

                ScenarioChoice scenarioChoice = new ScenarioChoice(scenarioID, choiceID);
                arrayList.add(scenarioChoice);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        m_databaseConnection.close();
        return arrayList;
    }
}
