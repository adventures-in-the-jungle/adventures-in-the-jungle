package io.github.adventures_in_the_jungle;

import java.util.HashMap;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    public HashMap<String, Room> rooms;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logger logger = LogManager.getRootLogger();

        logger.log(Level.DEBUG, "Debug!");
        logger.log(Level.ERROR, "Error!");
        logger.log(Level.ERROR, "Error!");
        logger.log(Level.ERROR, "Error!");
        logger.log(Level.INFO, "Info!");

        int SIZE = 5;

        System.out.println("Press enter to create the map");
        scanner.nextLine();

        /*

        
        Random rand = new Random();
        int randomNum = rand.nextInt(SIZE);

        rooms = new HashMap<>();
          for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
              Room room = new Room(i, j); }   }

            try{

            Room endRoom = new Room(3,3);
            Room randomRoom = new Room(randomNum,randomNum);

        }catch (Exception e) {
                System.out.println("Not the End Room");
        }
        */
    }
}


//
//
//
//
