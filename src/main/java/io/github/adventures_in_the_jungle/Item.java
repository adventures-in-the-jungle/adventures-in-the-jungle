package io.github.adventures_in_the_jungle;

public class Item {
    //Item ID
    private int item_id;
    //Item name
    private String item_name;
    //ItemRoomID
    private int room_id;
    //Item points
    private int item_points;
    //Item type
    private int item_type;

    //Create Constructor For Item in here
    public Item() {

    }

    //Getter for item ID
    public int getItem_id() {
        return item_id;
    }

    //Setter for item ID
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    //Getter for tem Name
    public String getItem_name() {
        return item_name;
    }

    //Setter for item name
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    //Getter for Item Room ID
    public int getRoom_id() {
        return room_id;
    }

    //Setter for Item Room ID
    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    //Getter for Item Points
    public int getItem_points() {
        return item_points;
    }

    //Setter for Item Points
    public void setItem_points(int item_points) {
        this.item_points = item_points;
    }

    //Getter for Item Type
    public int getItem_type() {
        return item_type;
    }

    //Setter for Item Type
    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }

}
