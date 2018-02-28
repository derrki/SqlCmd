package ua.com.dagget.sqlcmd.model;

import java.sql.SQLException;

public interface DataBaseHelper {
    //Зєднання з базою
    void сonnect(String dataBaseName, String userName, String password) throws SQLException, ClassNotFoundException;

    //Створення таблиці
    void dBCreateTable();

    //Вставка даних в таблицю
    void dBInsert();

    //Вибірка даних з таблиці
    void dBSelect();

    //Редагування даних в таблиці
    void dBUpdate();

    //Видалення даних з таблиці
    void dBDelete();
}
