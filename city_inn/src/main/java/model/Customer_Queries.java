package model;

import java.net.IDN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer_Queries {
    private SQLCursor sqlCursor = null;

    public Customer_Queries() {
        this.sqlCursor = SQLCursor.createSQLCursor();
    }

    public ArrayList<Customer> getallCustomer() {
        ArrayList customer = new ArrayList<Customer>();
        String query = "Select * from customer c ";
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                customer.add(new Customer(rs));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens");
        }
        return customer;
    }

    public Customer SearchCustomerByID(int ID) {
        Customer c = null;
        String query = "Select * from customer c where c.Customer_ID =" + ID;
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            if (rs.next())
                c = new Customer(rs);
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return c;
    }

    public String add_Customer( String name, int phoneNum, String Email, String adress, int emlpyee_id) {
        Employee_Queries eq = new Employee_Queries();

        if (eq.SearchEmployeeID(emlpyee_id) != null) {
            String query = "insert into customer (Customer_Name,PhoneNum,Email,Address,Guide_Employee_ID) values (" + "\'"+ name + "\', \'"
                    + phoneNum + "\', \'" + Email + "\', \'" + adress + "\', \'" + emlpyee_id + "\' )" ;
                 int rs = this.sqlCursor.executeUpdate(query);
                 return "Add Done";
        }
        else return "Try Again";
    }
    public String delete_Customer(int ID){
        if(SearchCustomerByID(ID)!=null){
            String query ="delete from  customer c where c.Customer_ID="+ID+ ";";
            int rs =this.sqlCursor.executeUpdate(query);
            return "delete done";
        }else return "Customer not in system";
    }

    public ArrayList<String> Customer_who_booked_room(){
          ArrayList<String> names =new ArrayList<>();
         String query ="SELECT DISTINCT  c.Customer_Name FROM customer c, reservation r  WHERE c.Customer_ID = r.CustomerCustomer_ID ;";
        ResultSet rs =this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                names.add(rs.getString("Customer_Name"));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return names;
    }

    public ArrayList<String> Customer_who_booked_room_in_Floor(int floor_num){
        ArrayList<String> names =new ArrayList<>();
        String query ="SELECT DISTINCT  c.Customer_Name\n" +
                "FROM customer c, reservation r ,room ro\n" +
                "WHERE c.Customer_ID = r.CustomerCustomer_ID and r.RoomRoom_ID=ro.Room_ID and ro.FloorNum="+floor_num+" ;";
        ResultSet rs =this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                names.add(rs.getString("Customer_Name"));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens ");
        }
        return names;
    }

}
