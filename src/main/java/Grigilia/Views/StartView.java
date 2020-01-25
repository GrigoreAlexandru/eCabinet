package Grigilia.Views;

import Grigilia.DB;
import Grigilia.Gui;

import javax.swing.*;
import java.awt.*;

public class StartView extends JFrame {

    public StartView(boolean initSuccess) {
        super("eCabinet");
        if (!initSuccess) {
            JOptionPane.showMessageDialog(this, "Nu am putut citi din baza de date");
        }

        setSize(300, 150);
        setLocation(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Panel p = new Panel();
        p.setLayout(new GridLayout(2, 0, 40, 10));
        p.setBackground(Color.lightGray);
        JButton btn1 = new JButton("Login");
        JButton btn2 = new JButton("Register");
        btn1.addActionListener((e) -> new LoginView(this));
        btn2.addActionListener((e) -> new RegisterView(this));
        p.add(btn1);
        p.add(btn2);
        add(p);
        setLocation(300, 300);
    }

    public void close() {
        new Gui();
        StartView.this.dispose();
        DB.saveDb();
    }
}
