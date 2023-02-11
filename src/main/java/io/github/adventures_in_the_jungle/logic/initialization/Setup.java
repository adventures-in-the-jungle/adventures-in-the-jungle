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

    public static void SQLSetup(Game m_game)
    {

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

    public static String[][] GetScenarioData(){
        String[][] Messages = {
                {"1", "2", "3", "4"},//Room ID (Col 0)
                {"RoomOne", "RoomTwo", "RoomThree","RoomFour"},//Room name (Col 1)
                {"Cold-1", "Cold-2", "Cold-3", "Cold-4"},//north Route (Col 2)
                {"HOT-1", "HOT-2", "HOT-3", "HOT-4"},//South Route (Col 3)
                {"WEST-1", "WEST-2", "WEST-3", "WEST-4"},//WEST Route (Col 4)
                {"EAST-1", "EAST-2", "EAST-3", "EAST-4"},//EAST Route (Col 5)
        };

        return Messages;
    }
}
