package Grigilia.Views;

import Grigilia.DB;
import Grigilia.Models.Programare;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class ProgramariView extends JFrame {

    private JList<Programare> list;

    public ProgramariView() {
        super("Programari");

        JButton sterge = new JButton("Sterge");
        JButton progNoua = new JButton("Programare noua");


        Panel p = new Panel();
        list = new JList(DB.getProgramari().toArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        progNoua.addActionListener((e) -> new ProgramareNouaView(this));
        sterge.addActionListener((e) -> {
            Programare value = list.getSelectedValue();
            if (value != null) {
                DB.deleteProgramare(value);
                refresh();
            }
        });
        JScrollPane listScroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p.add(listScroller);
        Panel p2 = new Panel(new FlowLayout());
        p2.add(sterge);
        p2.add(progNoua);
        p.add(p2);
        add(p);
        setVisible(true);
        setLocation(300, 300);
        setSize(400, 600);
    }

    void refresh() {
        HashSet<Programare> programari = DB.getProgramari();
        list.setListData(programari.toArray(new Programare[programari.size()]));
    }
}
