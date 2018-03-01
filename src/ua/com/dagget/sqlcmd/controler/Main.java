package ua.com.dagget.sqlcmd.controler;

import ua.com.dagget.sqlcmd.model.DataBaseManager;
import ua.com.dagget.sqlcmd.view.Console;
import ua.com.dagget.sqlcmd.view.View;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String[] connectData;
        String comand;
        String dataBaseName;
        String userName;
        String password;

        View view = new Console();
        view.write("Привіт юзер!!!");
        DataBaseManager dataBaseManager = new DataBaseManager();

        while (true) {
            view.write("Ведіть дані для з'єднання з базою в форматі connect | database | username | password");
            String line = view.read();
            try {
                connectData = line.split("[ | ]");
                comand = connectData[0];
                dataBaseName = connectData[1];
                userName = connectData[2];
                password = connectData[3];
            } catch (ArrayIndexOutOfBoundsException e) {
                view.write("Некоректний формат вводу, будьте уважні!!");
                continue;
            }
            try {
                dataBaseManager.connect(dataBaseName, userName, password);
                break;
            } catch (RuntimeException e) {
                view.write(e.getMessage());
            }
        }
        view.write("Дані введені вірно!! Працюйте.");
        while (true){
            String ex = "exit";
            view.write("Ведіть команду для виходу з бази");
            String line = view.read();
            if(line.equals(ex)){
                try {
                    dataBaseManager.exit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
