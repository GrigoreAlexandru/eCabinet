package Grigilia.Views;

import Grigilia.App;
import Grigilia.DB;
import Grigilia.Models.Aviz;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.HashSet;

public class AvizeView extends JFrame {

    private JList<Aviz> list;

    public AvizeView() {
        super("Avize");

        JButton sterge = new JButton("Sterge");
        JButton progNoua = new JButton("Aviz nou");
        JButton print = new JButton("Printeaza");
        JButton pdf = new JButton("PDF");
        print.addActionListener( e -> {
            Aviz aviz = list.getSelectedValue();
            JTextPane pane = new JTextPane();
            String par1 =
                    "Acest aviz se acorda subsemnatului " + aviz.getNumePacient() + " pentru " + aviz.getTip() + "." +
                            "\nDoctor: \n" + aviz.getNumeDoctor();
            pane.setText(par1);
            try {
                pane.print();
            } catch (PrinterException e1) {
                e1.printStackTrace();
            }

        });
        pdf.addActionListener(e -> {
            try {
                Document document = new Document();
                Aviz aviz = list.getSelectedValue();
                PdfWriter.getInstance(document, new FileOutputStream("Aviz - " + aviz.getNumePacient() + ".pdf"));

                document.open();

                Paragraph par = new Paragraph("Aviz", new Font(Font.FontFamily.COURIER, 20, Font.BOLD));
                par.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(par);
                String par1 =
                        "Acest aviz se acorda subsemnatului " + aviz.getNumePacient() + " pentru " + aviz.getTip() + "." +
                                "\nDoctor: \n" + aviz.getNumeDoctor();
                document.add(new Paragraph(par1));


                document.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (DocumentException ex) {
                ex.printStackTrace();
            }
        });


        Panel p = new Panel();
        list = new JList(DB.getAvize().toArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        progNoua.addActionListener((e) -> new AvizNouView(this));
        sterge.addActionListener((e) -> {
            Aviz value = list.getSelectedValue();
            if (value != null) {
                DB.deleteAviz(value);
                refresh();
            }
        });
        JScrollPane listScroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        listScroller.getVerticalScrollBar().setPreferredSize(new Dimension(300, 300));
        p.add(listScroller);
        Panel p2 = new Panel(new GridLayout(1, 3, 0, 0));
        p2.add(sterge);
        p2.add(progNoua);
        p2.add(print);
        p2.add(pdf);
        p.add(p2);
        add(p);
        setVisible(true);
        setLocation(300, 300);
        setSize(400, 600);
    }

    void refresh() {
        HashSet<Aviz> avize = DB.getAvize();
        list.setListData(avize.toArray(new Aviz[avize.size()]));
    }
}
