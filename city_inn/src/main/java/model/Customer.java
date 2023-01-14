package model;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Customer {
    private int c_id = 0;
    private String c_name = "";
    private int phone_num = 0;
    private String Email ="";
    private String address ="";
    private int Guide_emp=0 ;

    public Customer(ResultSet rs) {
        try {
            this.c_id = rs.getInt("Customer_ID");
            this.c_name = rs.getString("Customer_Name");
            this.phone_num = rs.getInt("PhoneNum");
            this.Email = rs.getString("Email");
            this.address = rs.getString("Address");
            this.Guide_emp = rs.getInt("Guide_Employee_ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(int phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGuide_emp() {
        return Guide_emp;
    }

    public void setGuide_emp(int guide_emp) {
        Guide_emp = guide_emp;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", phone_num=" + phone_num +
                ", Email='" + Email + '\'' +
                ", address='" + address + '\'' +
                ", Guide_emp=" + Guide_emp +
                '}';
    }
}

