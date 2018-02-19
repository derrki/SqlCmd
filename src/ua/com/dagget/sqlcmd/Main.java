package ua.com.dagget.sqlcmd;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {

        DataBaseManager dataBaseConnection = new DataBaseManager(DataBaseContract.HOST,
                DataBaseContract.DB_NAME,
                DataBaseContract.USERNAME,
                DataBaseContract.PASSWORD);
        Connection connection = dataBaseConnection.getConnection();

        try {
           if (dataBaseConnection.dBConnect()){
               System.out.println("db connect");
           }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                    System.out.println("closse");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
