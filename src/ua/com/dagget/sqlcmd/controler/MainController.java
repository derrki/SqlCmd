package ua.com.dagget.sqlcmd.controler;

import ua.com.dagget.sqlcmd.model.DataBaseHelper;
import ua.com.dagget.sqlcmd.view.View;

import java.sql.SQLException;

class MainController {

    private View view;
    private DataBaseHelper dataBaseHelper;

     MainController (View view, DataBaseHelper dataBaseHelper) {
        this.view = view;
        this.dataBaseHelper = dataBaseHelper;
    }

    void run(){
        connectToDB();
    }

    private void connectToDB() {
        view.write("Привіт юзер!!!");
        view.write("Ведіть дані для з'єднання з базою в форматі connect | database | username | password");
        while (true) {
            String[] connectData;
            String comand;
            String dataBaseName;
            String userName;
            String password;
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
                dataBaseHelper.connect(dataBaseName, userName, password);
                break;
            } catch (RuntimeException e) {
                view.write(e.getMessage());
            }
        }
        view.write("Дані введені вірно!! Працюйте.");
    }

//    private void ex() {
//        while (true) {
//            String ex = "exit";
//            view.write("Ведіть команду для виходу з бази");
//            String line = view.read();
//            if (line.equals(ex)) {
//                try {
//                    dataBaseHelper.exit();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//    }
}
