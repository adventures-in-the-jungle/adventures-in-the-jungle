package io.github.adventures_in_the_jungle;

// Map needs to have its own class, if we say Game that is too broad of a class name when this class is creating the map and setting room points
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that encapsulates the entire map of the game -- including all the rooms.
 */
public class Map {

    //size of map
    public static final int SIZE = 4;

    private HashMap<String, Room> rooms;

    private ArrayList<ArrayList<Room>> hotel;

    //Creates a map using a HashMap utility in Java
    public Map() {
//        rooms = new HashMap<>();
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//
//                Room room = new Room(i, j);
//                rooms.put(room.getId(), room);
//                connectedRoom(room);
//            }
//        }

        this.hotel = new ArrayList<ArrayList<Room>>();

        // For every Y (or floor) that we want, we can create a new array list containing its children.
        for(int i = 0; i < 10; i++)
        {
            ArrayList<Room> floor = new ArrayList<Room>();
            this.hotel.add(floor);
        }
    }

    //Connect the rooms together
    private void connectedRoom(Room room) {
        int x = room.getX();
        int y = room.getY();

        // connect to room above
        if (y > 0) {
            Room above = rooms.get(Room.getId(x, y - 1));
            room.setNorth(above);
            above.setSouth(room);
        }

        // connect to room below
        if (y < SIZE - 1) {
            Room below = rooms.get(Room.getId(x, y + 1));
            room.setSouth(below);
            below.setNorth(room);
        }

        // connect to room to the left
        if (x > 0) {
            Room left = rooms.get(Room.getId(x - 1, y));
            room.setWest(left);
            left.setEast(room);
        }

        // connect to room to the right
        if (x < SIZE - 1) {
            Room right = rooms.get(Room.getId(x + 1, y));
            room.setEast(right);
            right.setWest(room);
        }
    }
}
