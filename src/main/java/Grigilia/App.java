package Grigilia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
//    public static void main(String[] args) {
////            DB.init();
//            // Account acc = new Account("test", "psdd");
//            // Account acc2 = new Account("t2est", "psdd");
//            // DB.saveAccount(acc);
//            // DB.saveAccount(acc2);
////            System.out.println(login("test", "psdd"));
//            new Gui();
//
//
////            DB.saveDb();
//    }


    public static void main(String[] args) {
       new Gui();


    }

    private static boolean login(String usr, String pwd) {
        return DB.getAccounts().contains(new Account(usr, pwd));
    }
}
