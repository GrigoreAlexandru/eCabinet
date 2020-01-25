package Grigilia.Views;

import Grigilia.DB;
import Grigilia.Models.Programare;

import javax.swing.*;
import java.awt.*;

public class ProgramareNouaView extends JFrame {

    public ProgramareNouaView(ProgramariView programariView) {
        super("StartView");

        JButton save = new JButton("Salveaza");

        String[] tipuri = {"psihoterapie", "terapie prin muzica tomatis", "terapie adhd"};
        JComboBox<String> dropdown = new JComboBox<>(tipuri);
        TextField nume = new TextField(20);
        TextField cost = new TextField(20);
        save.addActionListener((e) -> {

            try {
                int cst = Integer.parseInt(cost.getText());
                DB.saveProgramare(
                        new Programare(String.valueOf(dropdown.getSelectedItem()), nume.getText(), cst));
                programariView.refresh();
                ProgramareNouaView.this.dispose();
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Costul introdus nu este numar");
            }


        });
        Panel p = new Panel();
        p.setLayout(new GridLayout(4, 23, 10, 10));
        p.setBackground(Color.lightGray);
        p.add(new Label("Tip programare"));
        p.add(dropdown);
        p.add(new Label("Nume pacient"));
        p.add(nume);
        p.add(new Label("Cost"));
        p.add(cost);
        p.add(save);
        add(p);
        pack();
        setVisible(true);
        setLocation(300, 300);
    }
}
