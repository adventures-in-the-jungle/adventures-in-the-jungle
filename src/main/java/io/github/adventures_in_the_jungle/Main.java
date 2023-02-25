package io.github.adventures_in_the_jungle;

import io.github.adventures_in_the_jungle.logic.game.Choice;
import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.game.Scenario;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Scanner;

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

        int currentScenarioId = 1; // Start at scenario 1
        Scanner scanner = new Scanner(System.in);

        boolean gameIsOver = false;

        while (!gameIsOver) {
            Scenario currentScenario = game.scenarioHashMap.get(currentScenarioId);

            // Print the scenario text
            System.out.println(currentScenario.getScenarioText());

            if (currentScenario.getScenarioIsEnd()) {
                gameIsOver = true;
                if (currentScenario.getScenarioIsWon()) {
                    System.out.println("Congratulations, you won!");
                } else {
                    System.out.println("Sorry, you lost.");
                }
                break;
            }

            // Print the choices
            for (Map.Entry<Integer, Choice> choice : currentScenario.getChoiceCollection().entrySet()) {
                System.out.println("[" + choice.getKey() + "] " + choice.getValue().getChoiceText());
            }

            // Get the player's choice
            System.out.print("> ");
            int choiceId = scanner.nextInt();

            Choice choiceObject = game.choiceHashMap.get(choiceId);

            // Get the scenario that the chosen choice leads to
            int leadsTo = choiceObject.getChoiceLeadsTo();
            currentScenarioId = leadsTo;
        }

    }

}
