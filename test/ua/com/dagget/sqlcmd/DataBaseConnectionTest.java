package ua.com.dagget.sqlcmd;

import org.junit.Before;
import org.junit.Test;

public class DataBaseConnectionTest {

    DataBaseConnection dataBaseConnection;

    @Before
    public void setup(){
        dataBaseConnection = new DataBaseConnection();
    }

    @Test
    public void testDataBaseConnection(){
        dataBaseConnection.dBConnect();
    }

}
