package Grigilia.Views;

import Grigilia.App;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public LoginView(StartView login) {
        super("Login");

        JButton loginBtn = new JButton("Login");

        JPasswordField pw = new JPasswordField(20);
        TextField un = new TextField(20);
        loginBtn.addActionListener((e) -> {
            if (App.login(un.getText(), pw.getText())) {
                LoginView.this.dispose();
                login.close();
            } else
                JOptionPane.showMessageDialog(LoginView.this, "Nu exista nici un cont inregistrat");
        });


        Panel p = new Panel();
        p.setLayout(new GridLayout(3, 23, 10, 10));
        p.setBackground(Color.lightGray);
        p.add(new Label("Username"));
        p.add(un);
        p.add(new Label("Parola"));
        p.add(pw);
        p.add(loginBtn);
        add(p);
        pack();
        setVisible(true);
        setLocation(300, 300);
    }
}
