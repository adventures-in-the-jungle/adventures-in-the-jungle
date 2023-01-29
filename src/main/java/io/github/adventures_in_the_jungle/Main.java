package io.github.adventures_in_the_jungle;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logger logger = LogManager.getRootLogger();
        logger.trace("Configuration File Defined To Be :: " + System.getProperty("log4j.configurationFile"));

        System.out.println("Press enter to create the map");
        scanner.nextLine();

        try {
            Map map = new Map();


        } catch (Exception e) {



        }
    }
}