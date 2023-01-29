package io.github.adventures_in_the_jungle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logger logger = LogManager.getRootLogger();
        logger.info("Game Started!");

        System.out.println("Press enter to create the map");
        scanner.nextLine();

        Random rand = new Random();
        int SIZE = 5;
        int randomNum = rand.nextInt(SIZE);

        HashMap<String, Room> rooms;

        rooms = new HashMap<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Room room = new Room(i, j);
            }
        }

        try {

            Room endRoom = new Room(randomNum, randomNum);

        } catch (Exception e) {
            logger.fatal("There was a fatal exception thrown in the rooms! Abort!");
        }

    }
}
