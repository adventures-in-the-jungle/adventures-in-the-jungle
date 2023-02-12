package io.github.adventures_in_the_jungle.logic.initialization;

import io.github.adventures_in_the_jungle.Main;
import io.github.adventures_in_the_jungle.logic.game.Game;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        Connection databaseConnection = null;

        try {
            databaseConnection = DriverManager.getConnection(AppStoragePaths.GetDBConnectionString());
        } catch (Exception e) {
            logger.error("The database connection failed!");
        } finally {
            if (databaseConnection != null) {
                try {
                    databaseConnection.close();
                } catch (SQLException e) {
                    logger.error("The database connection failed to close!");
                }
            }
        }
    }
}
