package ua.com.dagget.sqlcmd.model;

import ua.com.dagget.sqlcmd.view.Console;
import ua.com.dagget.sqlcmd.view.View;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {

        View view = new Console();
        view.write("Привіт юзер!!!");
        view.write("Ведіть дані для з'єднання з базою в форматі DataBaceName | Username | Password");

        String line = view.read();
        String [] connectData = line.split("|");
        String dataBaseName = connectData[0];
        String userName = connectData[1];
        String password = connectData[2];


        System.out.println(dataBaseName);
        System.out.println(userName);
        System.out.println(password);

        DataBaseManager dataBaseConnection = new DataBaseManager(DataBaseContract.HOST,
                dataBaseName,
                userName,
                password);
        Connection connection = dataBaseConnection.getConnection();

        try {
           if (dataBaseConnection.dBConnect()){
               System.out.println("db connect");
           }
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
