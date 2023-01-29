package io.github.adventures_in_the_jungle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press enter to create the map");
            scanner.nextLine(); // Wait for the user to press enter
            try {
                Map map = new Map();

            } catch (Exception e) {

                // TODO: handle exception
            }
        }
}