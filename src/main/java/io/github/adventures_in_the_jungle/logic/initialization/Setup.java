package io.github.adventures_in_the_jungle.logic.initialization;

import io.github.adventures_in_the_jungle.logic.game.Game;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

public abstract class Setup {

    private static Logger logger;

    public static void ClassicSetup(Game m_game) {


    }

    public static void JSONSetup(Game m_game) throws FileNotFoundException {

        FileReader storyFile = new FileReader(Setup.class.getResourceAsStream("storyline/east-storyline.json").toString());
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
