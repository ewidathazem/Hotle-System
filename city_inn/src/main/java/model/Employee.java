package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private int e_id = 0;
    private String e_name = "";
    private int rating = 0;
    private String Email ="";
    private String tybe_of_employee ="";
    private int phone_num ;
    private int salry=0;

    public Employee(ResultSet rs) {
        try {
            this.e_id = rs.getInt("Employee_ID");
            this.e_name = rs.getString("Employee_Name");
            this.phone_num = rs.getInt("phoneNum");
            this.Email = rs.getString("Email");
            this.tybe_of_employee = rs.getString("type_of_employment");
            this.rating = rs.getInt("Rating");
            this.salry=rs.getInt("Salary");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Employee(int e_id, String e_name, int rating, String email, String tybe_of_employee, int phone_num, int salry) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.rating = rating;
        Email = email;
        this.tybe_of_employee = tybe_of_employee;
        this.phone_num = phone_num;
        this.salry = salry;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTybe_of_employee() {
        return tybe_of_employee;
    }

    public void setTybe_of_employee(String tybe_of_employee) {
        this.tybe_of_employee = tybe_of_employee;
    }

    public int getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(int phone_num) {
        this.phone_num = phone_num;
    }

    public int getSalry() {
        return salry;
    }

    public void setSalry(int salry) {
        this.salry = salry;
    }
}
