package ua.com.dagget.sqlcmd;

public class Main {
    public static void main(String[] args) {

        DataBaseConnection dataBaseConnection = new DataBaseConnection(DataBaseContract.HOST,
                DataBaseContract.DB_NAME,
                DataBaseContract.USERNAME,
                DataBaseContract.PASSWORD);
        dataBaseConnection.dBConnect();
    }
}
