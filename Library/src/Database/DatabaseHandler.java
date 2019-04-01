package Database;

import java.sql.*;

public class DatabaseHandler {
    private final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler() {
        createConnection();
        createMemberTable();
    }

    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createMemberTable() {
        String TABLE_NAME = "MEMBER";
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, TABLE_NAME, null);
            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " already exists");
            } else {
                String statement = "CREATE TABLE " + TABLE_NAME + "("
                        + "id varchar(200) primary key, \n"
                        + "name varchar (200), \n"
                        + "email varchar (200), \n"
                        + "nickName varchar (200))";
                System.out.println(statement);
                stmt.execute(statement);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "setting up database");
        }
    }
}
