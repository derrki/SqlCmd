package ua.com.dagget.sqlcmd.model;
import ua.com.dagget.sqlcmd.view.Console;
import ua.com.dagget.sqlcmd.view.View;
import java.sql.Connection;

public class Main {
    public static void main(String[] args)  {

        View view = new Console();
        view.write("Привіт юзер!!!");
        view.write("Ведіть дані для з'єднання з базою в форматі dataBaceName|username|password");

        while (true) {
            String line = view.read();
            System.out.println(line);
            String[] connectData = line.split("[|]");
            String dataBaseName = connectData[0];
            String userName = connectData[1];
            String password = connectData[2];

            DataBaseManager dataBaseConnection = new DataBaseManager(DataBaseContract.HOST,
                    dataBaseName,
                    userName,
                    password);
            Connection connection = dataBaseConnection.getConnection();

            dataBaseConnection.dBConnect();
        }
    }
}
