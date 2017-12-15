package ua.com.dagget.sqlcmd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;

public class DataBaseConnectionTest {

   private DataBaseConnection dataBaseConnection;

    @Before
    public void setup() {
        dataBaseConnection = new DataBaseConnection();
        dataBaseConnection.dBConnect();
    }

    @Test
    public void testDataBaseConnection() {

        Connection connectionActual = dataBaseConnection.getConnection();
        Assert.assertNotNull(connectionActual);

    }

}
