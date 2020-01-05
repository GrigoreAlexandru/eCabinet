package Grigilia;

public class App {
    public static void main(String[] args) {
            DB.init();
            // Account acc = new Account("test", "psdd");
            // Account acc2 = new Account("t2est", "psdd");
            // DB.saveAccount(acc);
            // DB.saveAccount(acc2);
            System.out.println(login("test", "psdd"));
            DB.saveDb();
    }

    private static boolean login(String usr, String pwd){
        return DB.getAccounts().contains(new Account(usr,pwd));
    }
}
