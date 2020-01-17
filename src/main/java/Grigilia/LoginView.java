package Grigilia;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public LoginView(){
        super ("Inscrierea unui candidat nou");
        Panel p=new Panel();
        p.setLayout(new GridLayout(3,23,10,10));
        p.setBackground(Color.lightGray);
        JButton login = new JButton("Login");
        p.add(new Label("Username"));
        TextField un=new TextField(20);

        p.add(un);

        p.add(new Label("Parola"));

        TextField pw=new TextField(20);
        p.add(pw);
        p.add(login);
        add(p);
        pack();
        setVisible(true);
    }
}
