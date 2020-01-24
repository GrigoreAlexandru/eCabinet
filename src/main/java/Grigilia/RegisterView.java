package Grigilia;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {

    public RegisterView(Login login) {
        super("Inregistrare");

        JButton loginBtn = new JButton("Inregistrare");

        JPasswordField pw = new JPasswordField(20);
        TextField un = new TextField(20);
        loginBtn.addActionListener((e) -> {
            App.register(un.getText(), new String(pw.getPassword()));
            RegisterView.this.dispose();
            login.close();
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
