package io.practise.myPractice;

import java.sql.*;

public class DataBaseConnectivity {

    public Connection conn = null;
    public Statement stmt;
    public ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "municipal_info_system";
    String driverClassName = "com.mysql.jdbc.Driver";

    public DataBaseConnectivity() {

        // TODO Auto-generated method stub
        String userName = "root";
        String password = "tiger";

        try {
            // 1. load the driver class
            Class.forName(driverClassName);
            // 2. Setup the connection url
            String connectionUrl = url + dbName;
            // 3. open a connection
            conn = DriverManager.getConnection(connectionUrl, userName, password);

            // 4. Open a statement
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "Select * from user";
            // 5. Create a result set
            rs = stmt.executeQuery(sqlQuery);
            // 6. Process the resultset

            System.out.println(" ----------- Database query result starts------------------ ");
            while (rs.next()) {

                System.out.print("     User Name :: " + rs.getString("userName"));
                System.out.println("   :: Age :: " + rs.getInt("age"));
            }

            System.out.println(" ----------- Database query result ends-------------------- ");

            // 7. Close the resultset,statement,connection

            // close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
