package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    private int room_id =0;
    private int floor_num=0;
    private int room_ritng_id=0;

    public Room(ResultSet rs){
        try {
            this.room_id = rs.getInt("Room_ID");
            this.floor_num = rs.getInt("FloorNum");
            this.room_ritng_id = rs.getInt("Room_Rating_ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Room(int room_id, int floor_num, int room_ritng_id) {
        this.room_id = room_id;
        this.floor_num = floor_num;
        this.room_ritng_id = room_ritng_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getFloor_num() {
        return floor_num;
    }

    public void setFloor_num(int floor_num) {
        this.floor_num = floor_num;
    }

    public int getRoom_ritng_id() {
        return room_ritng_id;
    }

    public void setRoom_ritng_id(int room_ritng_id) {
        this.room_ritng_id = room_ritng_id;
    }


}

