package Grigilia;

import Grigilia.Models.Account;
import Grigilia.Views.StartView;

public class App {

    public static void main(String[] args) {
        new StartView(DB.init());
        DB.saveDb();
    }

    public static boolean login(String usr, String pwd) {
        Account acc = DB.getAccount(new Account(usr, pwd));
        if (acc != null) {
            return true;
        }
        System.out.println("no accounts");
        return false;
    }

    public static void register(String usr, String pwd) {
        Account acc = new Account(usr, pwd);
        DB.saveAccount(acc);
    }
}
