package ua.com.dagget.sqlcmd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class DataBaseConnectionTest {

   private DataBaseManager dataBaseConnection;


    @Before
    public void setup() throws SQLException, ClassNotFoundException {
        dataBaseConnection = new DataBaseManager(DataBaseContract.HOST,
                DataBaseContract.DB_NAME,
                DataBaseContract.USERNAME,
                DataBaseContract.PASSWORD
        );
    }

    @Test
    public void testDataBaseConnection() {
        Boolean connectionActual = null;
        try {
            connectionActual = dataBaseConnection.dBConnect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(true, connectionActual);
    }

}
