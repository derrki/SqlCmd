package ua.com.dagget.sqlcmd;

import org.junit.After;
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
        dataBaseConnection = new DataBaseManager();
        System.out.println("Before");
    }

    @Test
    public void test_connection_to_the_database_with_input_parameters_null() {
        try {
            dataBaseConnection.connect(null, null, null);
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("OK");
        }
    }

    @Test
    public void test_database_connection_with_one_correct_input_databasename_parameter() {
        try {
            dataBaseConnection.connect("sqlcmd", null, null);
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("OK");
            //OK
        }
    }

    @Test
    public void test_database_connection_with_one_correct_input_username_parameter() {
        try {
            dataBaseConnection.connect(null, "postgres", null);
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("OK");
            //OK
        }
    }

    @Test
    public void test_database_connection_with_one_correct_input_password_parameter() {
        try {
            dataBaseConnection.connect(null, null, "postgres");
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("OK");
            //OK
        }
    }

    @Test
    public void test_connection_with_the_database_with_two_correct_input_parameters_databasename_and_username() {
        try {
            dataBaseConnection.connect("sqlcmd", "postgres", null);
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("OK");
            //OK
        }
    }

    @Test
    public void test_connection_with_the_database_with_two_correct_input_parameters_databasename_and_password() {
        try {
            dataBaseConnection.connect("sqlcmd", null, "postgres");
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("OK");
            //OK
        }
    }

    @Test
    public void test_connection_with_the_database_with_two_correct_input_parameters_username_and_password() {
        try {
            dataBaseConnection.connect(null, "postgres", "postgres");
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("OK");
            //OK
        }
    }

    @Test
    public void test_connection_with_the_database_with_all_the_correct_input_parameters() {
        try {
            dataBaseConnection.connect("sqlcmd", "postgres", "postgres");
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("OK");
            //OK
        }
    }

    @After
    public void tear_down_close_connect_to_db() {
        System.out.println("After");
    }

}
