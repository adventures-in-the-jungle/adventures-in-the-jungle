package io.github.adventures_in_the_jungle;

/**
 * Class used to manage scenarios in the game and how they relate to each other on the cartesian plane.
 * Rooms will reference each other dynamically in memory as they are instantiated and connected together.
 */
public class Room {

    /**
     * The X-coordinate that identifies the location of the Room.
     */
    private final int x;

    /**
     * The X-coordinate that identifies the location of the Room.
     */
    private final int y;

    /**
     * A reference to the Room north (北) of the current instance of the room.
     */
    private Room north;

    /**
     * A reference to the Room south (南) of the current instance of the room.
     */
    private Room south;

    /**
     * A reference to the Room east (東) of the current instance of the room.
     */
    private Room east;

    /**
     * A reference to the Room west (西) of the current instance of the room.
     */
    private Room west;

    /**
     * Initializes a new instance of Room.
     *
     * @param x The coordinate that identifies the X location of the room on the cartelization plane.
     * @param y The coordinate that identifies the Y location of the room on the cartelization plane.
     */
    public Room(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Fetches the coordinates of the Room object as a cartesian coordinate.
     *
     * @param x
     * @param y
     * @return
     */
    public static String getId(int x, int y) {
        return x + "," + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public String getId() {
        return getId(x, y);
    }
}

