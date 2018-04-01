package ua.com.dagget.sqlcmd.controler;

import ua.com.dagget.sqlcmd.model.DataBaseHelper;
import ua.com.dagget.sqlcmd.view.View;

import java.util.Arrays;

class MainController {

    private View view;
    private DataBaseHelper dataBaseHelper;

    MainController(View view, DataBaseHelper dataBaseHelper) {
        this.view = view;
        this.dataBaseHelper = dataBaseHelper;
    }

    void run() {

        view.write("Введи команду допомоги в форматі 'help', та обери подальші кроки для роботи з програмою.");
        connectToDB();
        String command;

        while (true){
            command = view.read();
            if (command.equals("help")){
                doHelp();
            } else if (command.equals("list")){
                commandList();
            }else if(command.equals("exit")){
                System.exit(1);
            }
        doHelp();

        createTable();
        }
    }

    private void doHelp() {
        commandList();
    }

    private String[]  commandList() {
        String [] commandList = new String[]{"connect - команда для приєднання до бази даних",
                                                "tables - команда для виводу списку всіх таблиць",
                                             "exit - вихід з програми"};
        return commandList;
    }

    private void createTable(){
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
                if(comand.equals("connect")){
                dataBaseHelper.connect(dataBaseName, userName, password);
                break;}
                else {
                    view.write("Невірний ввід команди. Ви ввели " + comand + " а потрібно 'command'. Спробуйте ввести коректну команду.");
                }
            } catch (RuntimeException e) {
                view.write(e.getMessage());
            }
        }
        view.write("Дані введені вірно!! Працюйте.");
    }
}
