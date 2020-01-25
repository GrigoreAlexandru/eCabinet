package Grigilia.Views;

import Grigilia.App;
import Grigilia.DB;
import Grigilia.Models.Aviz;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
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

//        pdf.addActionListener(e -> {
//            Document document = new Document();
//            try {
//                PdfWriter.getInstance(document, new FileOutputStream(App.PDF_PATH));
//            } catch (DocumentException e1) {
//                e1.printStackTrace();
//            } catch (FileNotFoundException e1) {
//                e1.printStackTrace();
//            }
//            document.open();
//            BufferedReader br = new BufferedReader(new FileReader(TEXT));
//            String line;
//            Paragraph p;
//            Font normal = new Font(FontFamily.TIMES_ROMAN, 12);
//            Font bold = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
//            boolean title = true;
//            while ((line = br.readLine()) != null) {
//                p = new Paragraph(line, title ? bold : normal);
//                p.setAlignment(Element.ALIGN_JUSTIFIED);
//                title = line.isEmpty();
//                document.add(p);
//            }
//            document.close();
//        });



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
        listScroller.getVerticalScrollBar().setPreferredSize(new Dimension(300,300));
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

    void refresh(){
        HashSet<Aviz> avize = DB.getAvize();
        list.setListData(avize.toArray(new Aviz[avize.size()]));
    }
}
