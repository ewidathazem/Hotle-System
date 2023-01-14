package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation {
    private int RoomRoom_ID = 0;
    private int CustomerCustomer_ID = 0;
    private String start_date;
    private String end_date;


    public Reservation(ResultSet rs) {
        try {
            this.CustomerCustomer_ID = rs.getInt("CustomerCustomer_ID");
            this.RoomRoom_ID = rs.getInt("RoomRoom_ID");
            this.end_date = rs.getString("Finish_date");
            this.start_date = rs.getString("Start_date");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reservation(int roomRoom_ID, int customerCustomer_ID, String start_date, String end_date) {
        RoomRoom_ID = roomRoom_ID;
        CustomerCustomer_ID = customerCustomer_ID;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getRoomRoom_ID() {
        return RoomRoom_ID;
    }

    public void setRoomRoom_ID(int roomRoom_ID) {
        RoomRoom_ID = roomRoom_ID;
    }

    public int getCustomerCustomer_ID() {
        return CustomerCustomer_ID;
    }

    public void setCustomerCustomer_ID(int customerCustomer_ID) {
        CustomerCustomer_ID = customerCustomer_ID;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }


}
