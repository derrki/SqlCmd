package ua.com.dagget.sqlcmd;

import java.sql.SQLException;

public interface DataBaseHelper {
    //Зєднання з базою
    boolean dBConnect() throws SQLException, ClassNotFoundException;

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
