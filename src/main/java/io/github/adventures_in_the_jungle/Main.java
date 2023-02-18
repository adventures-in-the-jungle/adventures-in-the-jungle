package io.github.adventures_in_the_jungle;

import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {

        Logger logger = LogManager.getRootLogger();
        Game game = Game.getInstance();

        try {
            Setup.FirstTimeSetup();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        Setup.SQLSetup(game);

    }

}
