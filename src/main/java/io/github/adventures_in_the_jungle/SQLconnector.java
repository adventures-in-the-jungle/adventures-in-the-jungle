package io.github.adventures_in_the_jungle;
import java.sql.*;

public class SQLconnector {

    private final String DbConnstring = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5529266";
    private final String UsernameConn = "sql5529266";
    private final String Password = "PHyQtnVLMk";
    private Connection conn;
    private ResultSet products;

    public int getTotalRows() {
        return totalRows;
    }

    private int totalRows;

    public SQLconnector(){
        try {
            conn = DriverManager.getConnection(DbConnstring,UsernameConn,Password);
            String sql = "SELECT * FROM myproduct";
            Statement stmt = conn.createStatement();
            this.products = stmt.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("no connection established");
            throw new RuntimeException(e);
        }
    }

    public ResultSet getProducts(){
        return this.products;
    }

    public void closedata(){
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
