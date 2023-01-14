package model;

import java.sql.*;

public class SQLCursor {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String db = "city_inn";
    private String localhost = "jdbc:mysql://127.0.0.1:3306/" + db;
    private String username = "root";
    private String password = "root123";
    private Connection conn = null;

    private static SQLCursor classObj = null;

    private SQLCursor() {
    }

    public static SQLCursor createSQLCursor() {
        if (classObj == null)
            classObj = new SQLCursor();
        return classObj;
    }

    private void establishConnection() {
        try {
            if (this.conn == null) {
                Class.forName(this.driver);
                this.conn = DriverManager.getConnection(this.localhost, this.username, this.password);
            }
        } catch (Exception e) {
            System.out.println("-E- An issue happens while establishing connection: " + e);
            this.conn = null;
        }
    }

    public void closeConnection() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {
                System.out.println("-E- An issue happens while closing connection: " + e);
                this.conn = null;
            }
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        this.establishConnection();
        if (this.conn != null) {
            try {
                Statement stmt = this.conn.createStatement();
                rs = stmt.executeQuery(query);
            } catch (Exception e) {
                System.out.println("-E- An issue happens while executing query \'" + query + "\': " + e);
                rs = null;
            }
        }
        return rs;
    }
    public int executeUpdate(String query) {
        int rs = 0;
        this.establishConnection();
        if (this.conn != null) {
            try {
                Statement stmt = this.conn.createStatement();
                rs = stmt.executeUpdate(query);
            } catch (Exception e) {
                System.out.println("-E- An issue happens while executing query \'" + query + "\': " + e);
                rs = 0;
            }
        }
        return rs;
    }
}