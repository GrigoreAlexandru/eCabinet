package Grigilia;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    public Gui() {
        super("eCabinet");


//        JPanel panel = new JPanel(new FlowLayout());
////        setLayout(new FlowLayout());

//        panel.add(btn1);

//        setContentPane(panel);
//        setSize(200, 100);
        setSize(300, 150);
        setLocation(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Panel p = new Panel();
        p.setLayout(new GridLayout(2, 0, 40, 10));
        p.setBackground(Color.lightGray);
        JButton btn1 = new JButton("Login");
        JButton btn2 = new JButton("Register");
        btn1.addActionListener((e)-> new LoginView());
        btn2.addActionListener((e)-> new RegisterView());
        p.add(btn1);
        p.add(btn2);
        String[] s = {"Creaza fisa noua", "Cauta fisa"};
        Button[] b = new Button[5];
//        for (int i = 0; i < b.length; i++) {
//            b[i] = new Button(s[i]);
//            b[i].addActionListener((e) -> {
//                Frame f;
//                if (e.getSource() == b[0]) {
//                    f = new FisaNouaFrame();
//                    f.setSize(400, 300);
//                    f.setVisible(true);
//
//                } else if (e.getSource() == b[1]) {
//                    f = new CautaFisaFrame();
//                    f.setVisible(true);
//                } else if (e.getSource() == b[2]) {
//                    f = new StergeFisaFrame();
//                    f.setVisible(true);
//                } else if (e.getSource() == b[3]) {
//                    f = new FiseFrame();
//                    f.setVisible(true);
//
//                } else {
//                    AgendaTelefonica at = AgendaTelefonica.getInstanta();
//                    at.salveaza();
//                }
//            });
//            p.add(b[i]);
//        }
        add(p);
    }
}
