package io.github.adventures_in_the_jungle;

import io.github.adventures_in_the_jungle.logic.database.objects.Choice;
import io.github.adventures_in_the_jungle.logic.database.objects.IChoosable;
import io.github.adventures_in_the_jungle.logic.database.objects.Item;
import io.github.adventures_in_the_jungle.logic.database.objects.Scenario;
import io.github.adventures_in_the_jungle.logic.game.Commands;
import io.github.adventures_in_the_jungle.logic.game.Game;
import io.github.adventures_in_the_jungle.logic.initialization.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class containing the main method of the program.
 */
public class Main {

    // The log4j object will be pulled in that corresponds to the Main class.
    private static Logger logger;

    // This is the first call to the Game.getInstance() method, which will instantiate the singleton instance of Game.
    private static Game game;

    // The scanner method will be used to collect system data about the user.
    private static Scanner scanner;

    /**
     * Method used to end the game and exit the program.
     *
     * @param isWinning Boolean representing whether nor not the game is winning.
     *                  Valid values: winning = true, losing = false, other = null
     */
    public static void Endgame(Boolean isWinning) {
        if (isWinning == null) {
            System.out.println("Thank you for playing! The system will now exit.");
            System.exit(0);
        } else if (isWinning) {
            System.out.println("Congratulations, you won!");
            System.exit(0);
        } else if (!isWinning) {
            System.out.println("Sorry, you lost.");
            System.exit(0);
        }
    }

    /**
     * Presents a universal way to prompt the user for a specific input.
     *
     * @param choices A set containing the choices presented to the user.
     * @return The index of the choice that was chosen.
     */
    public static Integer ChooseItem(ArrayList<? extends IChoosable> choices) {
        Integer chosenIndex = null;

        // Create a do-while loop to validate the user input for the choices.
        boolean userInputIsValid = false;

        do {
            // TODO Determine if the choices involve food (if the scenario has a usable item).
            // First, we will check whether or not any of the scenario's have a usable item.
            // In this instance, we will use a for-loop rather than a for-each-loop, since we will provide the options
            // to the user in an index-based format.
            for (int i = 0; i < choices.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + choices.get(i).getChoiceText());
            }

            // Get the player's choice and store it in the choiceID.
            System.out.print("> ");
            String userInput = Main.scanner.next();

            // First, we will test the user input to see if it contains a valid command.
            try {
                Commands inputCommand = null;
                inputCommand = Commands.valueOf(userInput.toUpperCase());

                // If the command is valid, we will query the corresponding command input.
                System.out.println(Commands.GetCommandFeedback(inputCommand));
            } catch (IllegalArgumentException invalidCommandException) {

                // Otherwise, we will test to see if the user input contains an integer
                try {
                    chosenIndex = Integer.parseInt(userInput) - 1;
                    userInputIsValid = true;
                } catch (NumberFormatException numberFormatException) {
                    logger.error("You did not type in a valid number! Please try again!");
                    userInputIsValid = false;
                } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    logger.error("You did not select a valid choice ID. Please try again.");
                    userInputIsValid = false;
                }
            }

        } while (!userInputIsValid);

        return chosenIndex;
    }

    /**
     * The main method that will be called when the program is launched.
     *
     * @param args The command-line arguments passed to the program when the application launches. In this application,
     *             the program is not expecting any arguments to be passed in.
     */
    public static void main(String[] args) {

        Main.logger = LogManager.getLogger(Main.class);
        Main.game = Game.getInstance();
        Main.scanner = new Scanner(System.in);

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

            // If the scenario is not a "dead end," then the scenario will have choices that correspond to it. We will
            // call the Scenario.getChoiceCollection() method to query the collection dynamically that corresponds to
            // the currentScenario object.
            ArrayList<Choice> choices = currentScenario.getChoiceCollection();

            // Then, we will check to see if the choice in question requires an item.
            // Then, we will fetch the object of the item type that corresponds to the item, and see if it equals "Food"
            Boolean choiceRequiresFood = false;

            // Then, I will declare a Choice object for later use to store the information about the choice which
            // required food (if any did require food).
            Choice choiceWhichRequiredFood = null;

            // We will then loop through all the choices to see if they require food.
            for (Choice choice : choices) {
                if (choice.getChoiceUsableItemCategoryObject() != null && choice.getChoiceUsableItemCategoryObject().getItemCategoryName().equals("Food")) {
                    choiceRequiresFood = true;
                    choiceWhichRequiredFood = choice;
                }
            }

            // If the choice requires food, we will present the user's lunchbox for consumption.
            if (choiceRequiresFood) {

                // Finally, we will test to see if there are any items in the inventory that correspond to the type of "Food"
                // To do this, we first need to filter out all edible items in the inventory into its own ArrayList.
                ArrayList<Item> lunchbox = new ArrayList<>();

                for (Item item : Main.game.inventory) {
                    if (item.getItemCategoryObject().getItemCategoryName().equals("Food")) {
                        lunchbox.add(item);
                    }
                }

                // Then, if the lunchbox is not empty, the user has food.
                Boolean userHasFood = !lunchbox.isEmpty();

                if (choiceRequiresFood && !userHasFood) {
                    gameIsOver = true;
                    Endgame(false);
                }

                // If the choice requires food, and the user has food, prompt the user for the food items to consume.
                else if (choiceRequiresFood && userHasFood) {
                    Integer chosenFoodItem = Main.ChooseItem(lunchbox);

                    // Display to the user that the food item was eaten.
                    System.out.println("You ate " + lunchbox.get(chosenFoodItem).getItemName());

                    // Then, remove the food item from the inventory after consumption.
                    Main.game.inventory.remove(lunchbox.get(chosenFoodItem));

                    // Then, query the scenario ID that corresponds to choice in which the food item was eaten,
                    // and go the corresponding direction.
                    currentScenarioId = choiceWhichRequiredFood.getChoiceLeadsTo();

                    gameIsOver = false;
                }
            }

            // Otherwise, we will present the different directions toward which the user could go.
            else {

                // Once the scenario has been queried from the Game singleton, we will print out the text within that object.
                System.out.println(currentScenario.getScenarioText());

                // Each scenario object will contain information about whether it is a "dead end." This information will be
                // queried to set the gameIsOver boolean flag accordingly to break the game loop.
                if (currentScenario.getScenarioIsEnd() && !currentScenario.getScenarioIsWon()) {
                    gameIsOver = true;
                    Endgame(false);
                } else if (currentScenario.getScenarioIsEnd() && currentScenario.getScenarioIsWon()) {
                    gameIsOver = true;
                    Endgame(true);
                }

                Integer choiceID = Main.ChooseItem(choices);
                Choice choiceObject = choices.get(choiceID);

                if(choiceObject.getChoiceFetchableItemObject() != null)
                {
                    Main.game.inventory.add(choiceObject.getChoiceFetchableItemObject());
                }

                // After the user has made the corresponding choice, query the object that it corresponds to in the collection.
                if (choiceObject.getChoiceFeedback() != null) System.out.println(choiceObject.getChoiceFeedback());

                // Get the scenario that the chosen choice leads to
                int leadsTo = choiceObject.getChoiceLeadsTo();
                currentScenarioId = leadsTo;
            }
        }
    }
}
