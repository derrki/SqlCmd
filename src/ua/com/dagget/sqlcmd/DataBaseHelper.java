package ua.com.dagget.sqlcmd;

public interface DataBaseHelper {
    //Зєднання з базою
    void dBConnect();

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