package io.github.adventures_in_the_jungle;

import io.github.adventures_in_the_jungle.logic.game.Choice;
import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.game.Scenario;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
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

            ArrayList<Choice> choices = currentScenario.getChoiceCollection();

            // Print the choices
            for(int i = 0; i < choices.size(); i++)
            {
                System.out.println("[" + (i + 1) + "] " + choices.get(i).getChoiceText());
            }

            // Get the player's choice
            System.out.print("> ");
            int choiceId = scanner.nextInt() - 1;

            Choice choiceObject = choices.get(choiceId);

            // Get the scenario that the chosen choice leads to
            int leadsTo = choiceObject.getChoiceLeadsTo();
            currentScenarioId = leadsTo;
        }

    }

}
