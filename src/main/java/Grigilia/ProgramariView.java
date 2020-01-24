package Grigilia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class ProgramariView extends JFrame {

//    Programare deSters;

    public ProgramariView() {
        super("Programari");

        JButton sterge = new JButton("Sterge");




        Panel p = new Panel();
        JList<Programare> list = new JList(DB.getProgramari().toArray());
//        DefaultListModel<Programare> model = new DefaultListModel<>();
//        model.all
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
//        list.addListSelectionListener((item) -> deSters = item);
        sterge.addActionListener((e) -> {
            Programare value = list.getSelectedValue();
            if (value != null){
//                DefaultListModel listModel = (DefaultListModel) list.getModel();
//                listModel.removeElementAt(list.getSelectedIndex());
                DB.deleteProgramare(value);
                HashSet<Programare> programari = DB.getProgramari();
                Programare[] progs =  programari.toArray(new Programare[programari.size()]);
                list.setListData(progs);
            }
        });
        JScrollPane listScroller = new JScrollPane(list);
//        listScroller.setPreferredSize(new Dimension(250, 80));
        p.add(listScroller);
        p.add(sterge);
        add(p);
        pack();
        setVisible(true);
        setLocation(300, 300);
    }
}
