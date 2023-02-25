package io.github.adventures_in_the_jungle;

import io.github.adventures_in_the_jungle.logic.database.objects.Choice;
import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.database.objects.Scenario;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class containing the main method of the program.
 */
public class Main {

    /**
     * The main method that will be called when the program is launched.
     *
     * @param args The command-line arguments passed to the program when the application launches. In this application,
     *             the program is not expecting any arguments to be passed in.
     */
    public static void main(String[] args) {

        // The log4j object will be pulled in that corresponds to the Main class.
        Logger logger = LogManager.getLogger(Main.class);

        // This is the first call to the Game.getInstance() method, which will instantiate the singleton instance of Game.
        Game game = Game.getInstance();

        // The scanner method will be used to collect system data about the user.
        Scanner scanner = new Scanner(System.in);

        // When the application is first started, a script will be run to copy the SQLite database over to the user's
        // home directory if it doesn't already exist. This will be carried out by the Setup.FirstTimeSetup() method.
        try {
            Setup.FirstTimeSetup();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        // The Setup.SQLSetup() method will populate the Game singleton class with collections that correspond to the
        // objects that exist in the database. From there,
        Setup.SQLSetup(game);

        // The main game loop will function by referencing the scenario ID (or index) that corresponds to the primary
        // key of the scenario in the database table. This will then be queried from the map within Game singleton
        // by specifying the correct ID. The first scenario index is, by default, 1.
        int currentScenarioId = 1;

        // The main game loop will repeat continuously until the game ends. Our team decided that the best way to do
        // this is by using a simple while loop, with a supplied boolean flag.
        boolean gameIsOver = false;

        while (!gameIsOver) {

            // At the beginning of the game loop, we will query the scenario object based on the ID that was set during
            // the previous iteration. If the loop is in its first iteration, it will reference the first scenario.
            Scenario currentScenario = game.scenarioHashMap.get(currentScenarioId);

            // Once the scenario has been queried from the Game singleton, we will print out the text within that object.
            System.out.println(currentScenario.getScenarioText());

            // Each scenario object will contain information about whether it is a "dead end." This information will be
            // queried to set the gameIsOver boolean flag accordingly to break the game loop.
            if (currentScenario.getScenarioIsEnd()) {
                gameIsOver = true;

                if (currentScenario.getScenarioIsWon()) {
                    System.out.println("Congratulations, you won!");
                } else {
                    System.out.println("Sorry, you lost.");
                }

                break;
            }

            // If the scenario is not a "dead end," then the scenario will have choices that correspond to it. We will
            // call the Scenario.getChoiceCollection() method to query the collection dynamically that corresponds to
            // the currentScenario object.
            ArrayList<Choice> choices = currentScenario.getChoiceCollection();

            // TODO Determine if the choices involve food (if the scenario has a usable item).

            // Create a do-while loop to validate the user input for the choices.

            boolean userInputIsValid = false;

            do {
                try {

                    // In this instance, we will use a for-loop rather than a for-each-loop, since we will provide the options
                    // to the user in an index-based format.
                    for (int i = 0; i < choices.size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + choices.get(i).getChoiceText());
                    }

                    // Get the player's choice and store it in the choiceID.
                    System.out.print("> ");
                    String userInput = scanner.next();
                    Integer choiceID = Integer.parseInt(userInput) - 1;

                    Choice choiceObject = choices.get(choiceID);

                    // After the user has made the corresponding choice, query the object that it corresponds to in the collection.
                    if (choiceObject.getChoiceFeedback() != null) System.out.println(choiceObject.getChoiceFeedback());

                    // Get the scenario that the chosen choice leads to
                    int leadsTo = choiceObject.getChoiceLeadsTo();
                    currentScenarioId = leadsTo;
                    userInputIsValid = true;

                } catch (IndexOutOfBoundsException e) {
                    logger.error("The index was out of bounds for the selection! Please try again.");
                    userInputIsValid = false;
                } catch (NumberFormatException e) {
                    logger.error("The input was invalid! Please type in a number corresponding to your selection.");
                    userInputIsValid = false;
                } catch (Error e) {
                    logger.error("There was an unusual error! Please contact your nearest software developer for assistance.");
                    userInputIsValid = false;
                }
            } while (!userInputIsValid);

        }

    }

}
