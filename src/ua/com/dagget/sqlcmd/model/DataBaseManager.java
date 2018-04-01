package ua.com.dagget.sqlcmd.model;
import java.io.IOException;
import java.sql.*;

public class DataBaseManager implements DataBaseHelper {

    private Connection connection;
    private Statement stmt = null;

    @Override
    public void connect(String dataBaseName, String userName, String password) {

        try {
            Class.forName(DataBaseContract.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Where is your PostgreSQL JDBC Driver? Include in your library path!", e);
        }

        try {
            connection = DriverManager.getConnection(DataBaseContract.HOST + dataBaseName, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException("Не вдалось приєднатись до бази даних. Введені невірні дані, спробуйте ще раз. Ви ввели: " + dataBaseName + " " + userName, e);
        }

        if (connection != null) {
            System.out.println("connection ne null");
        }
    }

    public void exit() throws SQLException {
        try {
            connection.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
            System.out.println("connect close");
        }
    }

    //повертає конект до бази
    public Connection getConnect() throws IOException, SQLException {
        return connection;
    }

    //Створення таблиці
    @Override
    public void dBCreateTable() {
        try {
            stmt = connection.createStatement();

            String sql = "CREATE TABLE CONTACT " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();

            System.out.println("Table created");
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    //Вставка даних в таблицю
    @Override
    public void dBInsert() {
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    //Вибірка даних з таблиці
    @Override
    public void dBSelect() {
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    //Редагування даних в таблиці
    @Override
    public void dBUpdate() {
        try {

            stmt = connection.createStatement();
            String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
            stmt.executeUpdate(sql);
            connection.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    //Видалення даних з таблиці
    @Override
    public void dBDelete() {
        try {

            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            String sql = "DELETE from COMPANY where ID=2;";
            stmt.executeUpdate(sql);
            connection.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
