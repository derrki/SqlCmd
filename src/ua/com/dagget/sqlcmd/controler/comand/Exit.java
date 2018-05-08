package ua.com.dagget.sqlcmd.controler.comand;

import ua.com.dagget.sqlcmd.view.View;

public class Exit implements Comand {

    private View viev;

    public Exit(View view){
        this.viev = view;
    }

    @Override
    public boolean canProcess(String comand) {
        return comand.equals("exit");
    }

    @Override
    public void process() {
        viev.write("До зустрічі !");
        System.exit(1);
    }
}
