package io.github.adventures_in_the_jungle;

import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logger logger = LogManager.getRootLogger();

        System.out.println("Press enter to create the map");
        scanner.nextLine();

        Game game = Game.getInstance();
        Setup.JSONSetup(game);

    }

}
