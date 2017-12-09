package ua.com.dagget.sqlcmd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DataBaseConnection {

    Connection connection = null;

    void dBConnect() {

        //десь тут сховано роботу з JDBC !
        try {

            //З'єднання з БД

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/sqlcmd", "postgres",
                    "postgres");
            System.out.println("DB connected");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    // Створення таблиці
    void dBCreateTable(){

        Statement stmt = null;
        try {
            stmt = connection.createStatement();

            String sql = "CREATE TABLE COMP " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();

            System.out.println("Table created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
