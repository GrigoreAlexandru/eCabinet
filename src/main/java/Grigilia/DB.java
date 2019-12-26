package Grigilia;

import java.util.ArrayList;

class DB {

    private static ArrayList<Account> accounts;

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> accounts) {
        DB.accounts = accounts;
    }
}