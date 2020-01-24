package Grigilia;

import java.util.HashSet;

public class App {
        public static Account loggedAcc;
//    public static void main(String[] args) {
////            DB.init();
//            // Account acc = new Account("test", "psdd");
//            // Account acc2 = new Account("t2est", "psdd");
//            // DB.saveAccount(acc);
//            // DB.saveAccount(acc2);
////            System.out.println(login("test", "psdd"));
//            new Login();
//
//
////            DB.saveDb();
//    }


    public static void main(String[] args) {
        new Login(DB.init());
        DB.saveDb();

    }

    public static boolean login(String usr, String pwd) {
//        HashSet<Account> accounts = DB.getAccounts();
        Account acc = DB.getAccount(new Account(usr, pwd));
        if (acc != null){
            loggedAcc = acc;
            return true;
        }
        System.out.println("no accounts");
        return false;
    }

    public static void register(String usr, String pwd) {
        Account acc = new Account(usr, pwd);
        DB.saveAccount(acc);
        loggedAcc = acc;
    }
}
