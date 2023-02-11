package io.github.adventures_in_the_jungle.logic.initialization;

import io.github.adventures_in_the_jungle.Main;
import io.github.adventures_in_the_jungle.logic.game.Game;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Setup {

    private static Logger logger;

    public static void ClassicSetup(Game m_game) {

    }

    public static void JSONSetup(Game m_game) {

        FileReader storyFile = null;

        try {
            storyFile = new FileReader(String.valueOf(Main.class.getResourceAsStream("east-storyline.json")));
        } catch (FileNotFoundException e) {
            Logger logger = LogManager.getLogger(Setup.class.getName());
            logger.log(Level.FATAL, "There was an error in accessing the story file for the database! The application will now terminate!");
            throw new RuntimeException();
        }

        Scanner storyFileReader = new Scanner(storyFile);

        String plot = "";

        while (storyFileReader.hasNextLine()) {
            plot = plot + storyFileReader.nextLine();
        }

        storyFileReader.close();

        JSONObject game = new JSONObject(plot);

        System.out.println(game.get("plot"));

    }

}
