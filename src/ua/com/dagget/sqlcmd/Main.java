package ua.com.dagget.sqlcmd;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {

        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseContract.HOST,
                DataBaseContract.DB_NAME,
                DataBaseContract.USERNAME,
                DataBaseContract.PASSWORD);
        try {
           if (dataBaseConnection.dBConnect()){
               System.out.println("db connect");
           }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
