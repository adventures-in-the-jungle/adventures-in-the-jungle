package io.github.adventures_in_the_jungle;

public class Item {
    private int item_id;
    private String item_name;
    private int room_id;
    private int item_points;
    private int item_type;




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
    //Getter for Itme R
    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getItem_points() {
        return item_points;
    }

    public void setItem_points(int item_points) {
        this.item_points = item_points;
    }

    public int getItem_type() {
        return item_type;
    }

    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }

}
