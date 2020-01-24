package Grigilia;

import javax.swing.*;
import java.awt.*;

public class ProgramareNouaView extends JFrame {

    public ProgramareNouaView() {
        super("Login");

        JButton save = new JButton("Salveaza");

        String[] tipuri = {"psihoterapie", "tomatis", "adhd"};
        JComboBox<String> dropdown = new JComboBox<>(tipuri);
        TextField nume = new TextField(20);
        save.addActionListener((e) -> {
            DB.saveProgramare(new Programare(String.valueOf(dropdown.getSelectedItem()), nume.getText()));
            ProgramareNouaView.this.dispose();
        });
        Panel p = new Panel();
        p.setLayout(new GridLayout(3, 23, 10, 10));
        p.setBackground(Color.lightGray);
        p.add(new Label("Tip programare"));
        p.add(dropdown);
        p.add(new Label("Nume pacient"));
        p.add(nume);
        p.add(save);
        add(p);
        pack();
        setVisible(true);
        setLocation(300, 300);
    }
}
