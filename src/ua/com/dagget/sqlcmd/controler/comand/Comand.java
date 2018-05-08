package ua.com.dagget.sqlcmd.controler.comand;

public interface Comand {

    boolean canProcess (String comand);
    void process ();
}
