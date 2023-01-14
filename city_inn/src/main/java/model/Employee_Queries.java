package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Employee_Queries {
    private SQLCursor sqlCursor = null;
    public Employee_Queries() {
        this.sqlCursor = SQLCursor.createSQLCursor();
    }
    public ArrayList<Employee> getallEmployee() {
        ArrayList employee_list = new ArrayList<Employee>() ;
        String query = "Select * from employee e " ;
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            while (rs.next())
                employee_list.add(new Employee(rs));
        } catch (SQLException e) {
            System.out.println("-E- Issue happens");
        }
        return employee_list;
    }
    public Employee SearchEmployeeID(int ID) {
        Employee employee = null;
        String query = "Select * from employee e where e.Employee_ID ="+ ID ;
        ResultSet rs = this.sqlCursor.executeQuery(query);
        try {
            if (rs.next())
                employee = new Employee(rs);
        } catch (SQLException e) {
            System.out.println("-E- Issue happens " );
        }
        return employee;
    }
}
