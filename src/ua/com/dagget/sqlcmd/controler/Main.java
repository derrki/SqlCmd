package ua.com.dagget.sqlcmd.controler;
import ua.com.dagget.sqlcmd.model.DataBaseHelper;
import ua.com.dagget.sqlcmd.model.DataBaseManager;
import ua.com.dagget.sqlcmd.view.Console;
import ua.com.dagget.sqlcmd.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new Console();
        DataBaseHelper dataBaseManager = new DataBaseManager();
        MainController mainController = new MainController(view, dataBaseManager);
        mainController.run();
    }
}

