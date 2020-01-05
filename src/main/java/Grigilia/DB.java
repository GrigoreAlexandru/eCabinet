package Grigilia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

class DB {

    private static HashSet<Account> accounts;
    private static Gson gson = new GsonBuilder().create();
    private static File accountsFile = new File("accounts");
         

    public static void init() {
        if (accountsFile.exists()) {
            Scanner sc;
            try {
                sc = new Scanner(accountsFile);
                final String json = sc.nextLine();
                java.lang.reflect.Type founderSetType = new TypeToken<HashSet<Account>>(){}.getType();

                accounts = gson.fromJson(json, founderSetType);  
                // accounts = gson.fromJson(json, HashSet.class);
                if (accounts == null) {
                    accounts = new HashSet<Account>();
                }
                System.out.println(accounts);
                System.out.println(accounts.size());
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            saveDb();
            init();
        }
    }

    public static void saveAccount(final Account account) {
        accounts.add(account);
    }

    public static HashSet<Account> getAccounts() {
        return accounts;
    }

    public static void saveDb() {
        try (Writer writer = new FileWriter(accountsFile)) {
            gson.toJson(accounts, writer);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    
}