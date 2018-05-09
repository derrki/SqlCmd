package ua.com.dagget.sqlcmd.controler;

import ua.com.dagget.sqlcmd.controler.comand.Comand;
import ua.com.dagget.sqlcmd.view.View;

public class Unsupported implements Comand {
    private final View viev;

    public Unsupported(View view) {
        this.viev = view;
    }

    @Override
    public boolean canProcess(String comand) {
        return true;
    }

    @Override
    public void process() {
        viev.write("Такої команди не існує");
    }
}
