package ua.com.dagget.sqlcmd.controler;

import ua.com.dagget.sqlcmd.controler.comand.Comand;
import ua.com.dagget.sqlcmd.controler.comand.Exit;
import ua.com.dagget.sqlcmd.controler.comand.Help;
import ua.com.dagget.sqlcmd.model.DataBaseHelper;
import ua.com.dagget.sqlcmd.view.View;

import java.util.Arrays;

class MainController {

    private Comand[] commands;
    private View view;
    private DataBaseHelper dataBaseHelper;

    MainController(View view, DataBaseHelper dataBaseHelper) {
        this.view = view;
        this.dataBaseHelper = dataBaseHelper;
        this.commands = new Comand[]{new Exit(view), new Help(view)};
    }

    void run() {
        connectToDB();
        view.write("Введи команду допомоги в форматі 'help', та обери подальші кроки для роботи з програмою.");

        String command;

        while (true) {
            command = view.read();
            if (commands[1].canProcess(command)) {
                commands[1].process();
            } else if (commands[0].canProcess(command)) {
                commands[0].process();
            }
        }
    }


    private void createTable() {
        dataBaseHelper.dBCreateTable();
    }

    private void connectToDB() {
        view.write("Привіт користувач!!!");
        view.write("Веди дані для з'єднання з базою в форматі connect | database | username | password");
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
                if (comand.equals("connect")) {
                    dataBaseHelper.connect(dataBaseName, userName, password);
                    break;
                } else {
                    view.write("Невірний ввід команди. Ви ввели " + comand + " а потрібно 'command'. Спробуйте ввести коректну команду.");
                }
            } catch (RuntimeException e) {
                view.write(e.getMessage());
            }
        }
        view.write("Дані введені вірно!! Працюйте.");
    }
}
