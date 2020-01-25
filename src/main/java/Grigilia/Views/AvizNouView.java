package Grigilia.Views;

import Grigilia.DB;
import Grigilia.Models.Aviz;
import Grigilia.Models.Programare;

import javax.swing.*;
import java.awt.*;

public class AvizNouView extends JFrame {

    public AvizNouView(AvizeView avizeView) {
        super("StartView");

        JButton save = new JButton("Salveaza");

        String[] tipuri = {
                "Permis auto", "Agent Securitate", "Lucru la inaltime", "Lucru in tura de noapte", "Port arma"
        };
        JComboBox<String> dropdown = new JComboBox<>(tipuri);
        TextField numeDoctor = new TextField(20);
        TextField numePacient = new TextField(20);
        TextField cnp = new TextField(20);
        save.addActionListener((e) -> {

            try {
                int cst = Integer.parseInt(cnp.getText());
                DB.saveAviz(
                        new Aviz(numeDoctor.getText(), numePacient.getText(), String.valueOf(dropdown.getSelectedItem()), cst));
                avizeView.refresh();
                AvizNouView.this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "CNP introdus nu este numar");
            }
        });
        Panel p = new Panel();
        p.setLayout(new GridLayout(5, 23, 10, 10));
        p.setBackground(Color.lightGray);
        p.add(new Label("Tip aviz"));
        p.add(dropdown);
        p.add(new Label("Nume pacient"));
        p.add(numePacient);
        p.add(new Label("CNP"));
        p.add(cnp);
        p.add(new Label("Nume Doctor emitent"));
        p.add(numeDoctor);
        p.add(save);
        add(p);
        pack();
        setVisible(true);
        setLocation(300, 300);
    }
}
