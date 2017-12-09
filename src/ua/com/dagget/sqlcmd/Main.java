package ua.com.dagget.sqlcmd;

public class Main {
    public static void main(String[] args) {

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.dBConnect();
        //dataBaseConnection.dBCreateTable();
        //dataBaseConnection.dBInsert();
        dataBaseConnection.dBSelect();

    }
}
