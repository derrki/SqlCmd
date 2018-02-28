package ua.com.dagget.sqlcmd.model;

public interface DataBaseContract {

    /*
    * зберігає дані по замовчуванню
    */

    String DRIVER =  "org.postgresql.Driver";
    String HOST = "jdbc:postgresql://127.0.0.1:5432/";
    String DB_NAME = "sqlcm";
    String USERNAME = "postgres";
    String PASSWORD = "postgres";

}
