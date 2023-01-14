package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Room_rating {
    private int rating_id = 0;
    private int Capacity = 0;
    private int Num_of_Wc = 0;
    private int cost = 0;
    private String view_room = "";
    private String Color = "";
    private String Suits = "";

    public Room_rating(int rating_id, int capacity, int num_of_Wc, int cost, String view_room, String color, String suits) {
        this.rating_id = rating_id;
        Capacity = capacity;
        Num_of_Wc = num_of_Wc;
        this.cost = cost;
        this.view_room = view_room;
        Color = color;
        Suits = suits;
    }
    public Room_rating(ResultSet rs) {
        try {
            this.rating_id = rs.getInt("Rating_ID");
            this.Capacity = rs.getInt("Capacity");
            this.Num_of_Wc = rs.getInt("Num_of_Wc");
            this.view_room = rs.getString("view_room");
            this.Color = rs.getString("Color");
            this.cost = rs.getInt("cost");
            this.Suits = rs.getString("Suits");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getNum_of_Wc() {
        return Num_of_Wc;
    }

    public void setNum_of_Wc(int num_of_Wc) {
        Num_of_Wc = num_of_Wc;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getView_room() {
        return view_room;
    }

    public void setView_room(String view_room) {
        this.view_room = view_room;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getSuits() {
        return Suits;
    }

    public void setSuits(String suits) {
        Suits = suits;
    }


}