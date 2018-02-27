package ua.com.dagget.sqlcmd.view;

import java.util.Scanner;

public class Console implements View {
    @Override
    public void write(String messege) {
        System.out.println(messege);
    }

    @Override
    public String read() {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        return line;
    }
}
