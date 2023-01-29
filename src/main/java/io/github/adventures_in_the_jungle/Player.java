package io.github.adventures_in_the_jungle;

//Player class will allow us to call the current Room and point that the user is in. So when in the Scenario we can call a method that allows them to move up
// they can use the moveNorth method as an example.
public class Player {
    private Room currentRoom;

    public Player(Room startingRoom) {
        currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void moveNorth() {
        Room north = currentRoom.getNorth();
        if (north != null) {
            currentRoom = north;
        }
    }

    public void moveSouth() {
        Room south = currentRoom.getSouth();
        if (south != null) {
            currentRoom = south;
        }
    }

    public void moveEast() {
        Room east = currentRoom.getEast();
        if (east != null) {
            currentRoom = east;
        }
    }

    public void moveWest() {
        Room west = currentRoom.getWest();
        if (west != null) {
            currentRoom = west;
        }
    }
}