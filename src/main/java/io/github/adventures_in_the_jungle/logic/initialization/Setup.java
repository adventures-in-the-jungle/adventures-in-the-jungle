package io.github.adventures_in_the_jungle.logic.initialization;

import io.github.adventures_in_the_jungle.Main;
import io.github.adventures_in_the_jungle.logic.database.DatabaseConnection;
import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.game.Item;
import io.github.adventures_in_the_jungle.logic.game.ItemCategory;
import io.github.adventures_in_the_jungle.logic.game.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Setup {

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

    public static void SQLSetup(Game m_game) {

        String connectionString = AppStoragePaths.GetDBConnectionString();
        logger.debug("DB Connection String: " + connectionString);

        DatabaseConnection databaseConnection = new DatabaseConnection();

        HashMap<Integer, ItemCategory> itemCategoryHashMap = getItemCategoryHashMap(databaseConnection);

        for(int i = 1; i <= itemCategoryHashMap.size(); i++)
        {
            System.out.println("itemCategoryHashMap Key: " + i);
            System.out.println("itemCategoryHashMap Value: " + itemCategoryHashMap.get(i).toString());
        }

        HashMap<Integer, Item> itemHashMap = getItemHashMap(databaseConnection);

        for(int i = 1; i <= itemHashMap.size(); i++)
        {
            System.out.println("itemHashMap Key: " + i);
            System.out.println("itemHashMap Value: " + itemHashMap.get(i).toString());
        }

        HashMap<Integer, Scenario> scenarioHashMap = getScenarioHashMap(databaseConnection);

        for(int i = 1; i <= itemHashMap.size(); i++)
        {
            System.out.println("scenarioHashMap Key: " + i);
            System.out.println("scenarioHashMap Value: " + scenarioHashMap.get(i).toString());
        }

    }

    private static HashMap<Integer, ItemCategory> getItemCategoryHashMap(DatabaseConnection m_databaseConnection)
    {
        if(m_databaseConnection == null)
            m_databaseConnection = new DatabaseConnection();

        HashMap<Integer, ItemCategory> itemCategoryHashMap = new HashMap<Integer, ItemCategory>();

        m_databaseConnection.setActiveQuery("SELECT * FROM ITEM_CATEGORY");
        ResultSet resultSet = m_databaseConnection.executeActiveQuery();

        try {
            while (resultSet.next())
            {
                int itemCategoryId = resultSet.getInt("ITEM_CATEGORY_ID");
                String itemCategoryName = resultSet.getString("CATEGORY_NAME");
                String itemCategoryDescription = resultSet.getString("CATEGORY_DESCRIPTION");

                ItemCategory itemCategory = new ItemCategory(itemCategoryId, itemCategoryName, itemCategoryDescription);
                itemCategoryHashMap.put(itemCategoryId, itemCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        m_databaseConnection.close();
        return itemCategoryHashMap;
    }

    private static HashMap<Integer, Item> getItemHashMap(DatabaseConnection m_databaseConnection)
    {
        if(m_databaseConnection == null)
            m_databaseConnection = new DatabaseConnection();

        HashMap<Integer, Item> itemHashMap = new HashMap<Integer, Item>();

        m_databaseConnection.setActiveQuery("SELECT * FROM ITEM");
        ResultSet resultSet = m_databaseConnection.executeActiveQuery();

        try {
            while (resultSet.next())
            {
                int itemID = resultSet.getInt("ITEM_ID");
                String itemName = resultSet.getString("ITEM_NAME");
                int itemDescription = resultSet.getInt("ITEM_DESCRIPTION");

                Item itemCategory = new Item(itemID, itemName, itemDescription);
                itemHashMap.put(itemID, itemCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        m_databaseConnection.close();
        return itemHashMap;
    }

    private static HashMap<Integer, Scenario> getScenarioHashMap(DatabaseConnection m_databaseConnection)
    {
        if(m_databaseConnection == null)
            m_databaseConnection = new DatabaseConnection();

        HashMap<Integer, Scenario> scenarioHashMap = new HashMap<Integer, Scenario>();

        m_databaseConnection.setActiveQuery("SELECT * FROM SCENARIO");
        ResultSet resultSet = m_databaseConnection.executeActiveQuery();

        try {
            while (resultSet.next())
            {
                // INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON)
                int scenarioID = resultSet.getInt("SCENARIO_ID");
                String scenarioText = resultSet.getString("SCENARIO_TEXT");
                boolean scenarioIsEnd = resultSet.getBoolean("SCENARIO_IS_END");
                boolean scenarioPlayerWon = resultSet.getBoolean("SCENARIO_PLAYER_WON");

                Scenario scenario = new Scenario(scenarioID, scenarioText, scenarioIsEnd, scenarioPlayerWon);
                scenarioHashMap.put(scenarioID, scenario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        m_databaseConnection.close();
        return scenarioHashMap;
    }
}
