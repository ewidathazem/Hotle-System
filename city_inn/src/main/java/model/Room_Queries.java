package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Room_Queries {
    private SQLCursor sqlCursor = null;

    public Room_Queries() {
        this.sqlCursor = SQLCursor.createSQLCursor();
    }

    public ArrayList<Room> getallRoom() {
        ArrayList room_list = new ArrayList<Room>();
        String query = "Select * from room r ";
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                room_list.add(new Room(rs));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens");
        }
        return room_list;
    }

    public Room SearchRoomID(int ID) {
        Room room = null;
        String query = "Select * from room r where r.Room_ID =" + ID;
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            if (rs.next())
                room = new Room(rs);
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return room;
    }

    public ArrayList<Integer> room_reseved() {
        ArrayList<Integer> rooms = new ArrayList<>();
        String query = "SELECT DISTINCT  ro.Room_ID\n" +
                "FROM  reservation r ,room ro\n" +
                "WHERE r.RoomRoom_ID=ro.Room_ID ;";
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                rooms.add(rs.getInt("room_id"));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return rooms;
    }

    public ArrayList<Integer> room_cost(int cost) {
        ArrayList<Integer> rooms = new ArrayList<>();
        String query = "SELECT DISTINCT  ro.Room_ID\n" +
                "FROM  room_rating r ,room ro\n" +
                "WHERE r.Rating_ID=ro.Room_Rating_ID and r.Cost < " + cost + " ;";
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                rooms.add(rs.getInt("room_id"));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return rooms;
    }

    public ArrayList<String> customer_room(int room_id) {
        ArrayList<String> name = new ArrayList<>();
        String query = "SELECT DISTINCT  c.Customer_Name\n" +
                "FROM customer c, reservation r ,room ro\n" +
                "WHERE c.Customer_ID = r.CustomerCustomer_ID and r.RoomRoom_ID=ro.Room_ID and ro.Room_ID=" + room_id + ";";
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                name.add(rs.getString("Customer_Name"));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return name;
    }
    public ArrayList<String> room_Capacity(int room_id) {
        ArrayList<String> name = new ArrayList<>();
        String query = "SELECT DISTINCT  r.Capacity\n" +
                "FROM  room_rating r ,room ro\n" +
                "WHERE r.Rating_ID=ro.Room_Rating_ID and ro.Room_ID="+room_id+" ;";
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                name.add("THE Capacity:"+rs.getInt("Capacity"));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return name;
    }

}
