package ua.com.dagget.sqlcmd.controler.comand;

import ua.com.dagget.sqlcmd.view.View;

public class Help implements Comand {
    private View viev;

    public Help(View view) {
        this.viev = view;
    }

    @Override
    public boolean canProcess(String comand) {
        return comand.equals("help");
    }

    @Override
    public void process() {
        viev.write("Існуючі команди:");
        viev.write("\thelp");
        viev.write("\t- для виводу цього списку на екран");
        viev.write("\texit");
        viev.write("\t- для виходу з програми");
    }
}
