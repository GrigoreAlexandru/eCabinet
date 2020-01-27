package Grigilia;

import Grigilia.Views.AvizeView;
import Grigilia.Views.ProgramariView;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    public Gui() {
        super("eCabinet");

        JButton progs = new JButton("Programari");
        JButton avize = new JButton("Avize");

        progs.addActionListener((e) -> new ProgramariView());
        avize.addActionListener((e) -> new AvizeView());

        Panel p = new Panel();
        p.setLayout(new GridLayout(3, 23, 100, 10));
        p.setBackground(Color.lightGray);
        p.add(progs);
        p.add(avize);
        add(p);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 300);
        setSize(400, 300);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        DB.saveDb();
    }
}
