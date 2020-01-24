package Grigilia;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    public Gui() {
        super("Login");

        JButton progNoua = new JButton("Programare noua");
        JButton progs = new JButton("Programari");

//        TextField pw = new TextField(20);
//        TextField un = new TextField(20);
        progNoua.addActionListener((e) -> new ProgramareNouaView());
        progs.addActionListener((e) -> new ProgramariView());

        Panel p = new Panel();
        p.setLayout(new GridLayout(3, 23, 10, 10));
        p.setBackground(Color.lightGray);
        p.add(progNoua);
        p.add(progs);
        add(p);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 300);
        setSize(500,700);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        DB.saveDb();
    }
}
