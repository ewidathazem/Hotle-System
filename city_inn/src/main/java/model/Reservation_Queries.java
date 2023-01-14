package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reservation_Queries {
    private SQLCursor sqlCursor = null;

    public Reservation_Queries() {
        this.sqlCursor = SQLCursor.createSQLCursor();
    }

    public Reservation Search_by_customerID(int ID) {
        Reservation reservation = null;
        String query = "Select * from reservation r where r.CustomerCustomer_ID =" + ID;
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            if (rs.next())
                reservation = new Reservation(rs);
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return reservation;
    }
    public Reservation Search_by_roomID(int room_id) {
        Reservation reservation = null;
        String query = "Select * from reservation r where r.RoomRoom_ID =" + room_id;
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            if (rs.next())
                reservation = new Reservation(rs);
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return reservation;
    }

    public String add_Reservation(int room_id, int customer_id, String start_date, String end_date) {
        Room_Queries r_q = new Room_Queries();
        Customer_Queries c_q = new Customer_Queries();
        if (r_q.SearchRoomID(room_id) != null && c_q.SearchCustomerByID(customer_id) != null) {
            String query = "insert into reservation (RoomRoom_ID,CustomerCustomer_ID,Start_date,Finish_date) values (" + "\'" + room_id + "\', \'"
                    + customer_id + "\', \'" + start_date + "\', \'" + end_date + "\' )";
            int rs = this.sqlCursor.executeUpdate(query);
            return "Add Done";
        } else return "Try Again";
    }

    public ArrayList<Reservation> getallReservation() {
        ArrayList Reservation_list = new ArrayList<Reservation>();
        String query = "Select * from reservation r ";
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                Reservation_list.add(new Reservation(rs));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens");
        }
        return Reservation_list;
    }

    public String delete_Reservation(int room_id,int customer_id) {
        if (Search_by_customerID(customer_id).getCustomerCustomer_ID()==customer_id &&Search_by_customerID(customer_id).getRoomRoom_ID()==room_id) {
            String query = "delete from reservation r where r.CustomerCustomer_ID="+customer_id+" and r.RoomRoom_ID="+room_id;
            int rs = this.sqlCursor.executeUpdate(query);
            return "delete done";
        } else return "Customer or Room not in table system";
    }
    public String update_end_date_Reservation(int room_id,int customer_id,String end_date) {
        if (Search_by_customerID(customer_id).getCustomerCustomer_ID()==customer_id &&Search_by_customerID(customer_id).getRoomRoom_ID()==room_id) {
            String query = "UPDATE reservation r\n" +
                    "SET Finish_date =\'"+ end_date + "\' WHERE r.CustomerCustomer_ID="+customer_id+" and r.RoomRoom_ID="+room_id;
            int rs = this.sqlCursor.executeUpdate(query);
            return "update Done";
        } else return "Customer or Room not in table system";
    }
}