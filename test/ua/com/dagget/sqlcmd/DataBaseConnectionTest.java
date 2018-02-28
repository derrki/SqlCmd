package ua.com.dagget.sqlcmd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.dagget.sqlcmd.model.DataBaseContract;
import ua.com.dagget.sqlcmd.model.DataBaseManager;

import java.sql.SQLException;

public class DataBaseConnectionTest {

   private DataBaseManager dataBaseConnection;


    @Before
    public void setup() throws SQLException, ClassNotFoundException {
        dataBaseConnection = new DataBaseManager(
        );
    }

    @Test
    public void testDataBaseConnection() {
        Boolean connectionActual = null;

            //connectionActual = dataBaseConnection.сonnect();

        //Assert.assertEquals(true, connectionActual);
    }

}
