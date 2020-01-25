package Grigilia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;

import Grigilia.Models.Account;
import Grigilia.Models.Aviz;
import Grigilia.Models.Programare;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class DB {

    private HashSet<Account> accounts;
    private HashSet<Programare> programari;
    private HashSet<Aviz> avize;
    private static Gson gson = new GsonBuilder().create();
    private static File dbFile = new File("db.json");
    private static DB instanta;


    public static boolean init() {
        if (dbFile.exists()) {
            if (dbFile.length() == 0)
                return false;
            Scanner sc;
            try {
                sc = new Scanner(dbFile);
                final String json = sc.nextLine();
                java.lang.reflect.Type founderSetType = new TypeToken<DB>() {
                }.getType();

                instanta = gson.fromJson(json, founderSetType);
                if (instanta == null) {
                    instanta = new DB();
                    instanta.accounts = new HashSet<Account>();
                    instanta.programari = new HashSet<Programare>();
                    instanta.avize = new HashSet<Aviz>();
                }
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            saveDb();
            init();
        }
        return true;
    }

    public static void saveAccount(final Account account) {
        instanta.accounts.add(account);
    }

    public static Account getAccount(Account account) {
        for (Account account1 : instanta.accounts) {
            if (account1.equals(account))
                return account1;
        }
        return null;
    }


    public static HashSet<Account> getAccounts() {
        return instanta.accounts;
    }


    public static void saveProgramare(final Programare programare) {
        instanta.programari.add(programare);
        saveDb();
    }


    public static HashSet<Programare> getProgramari() {
        return instanta.programari;
    }

    public static void saveAviz(Aviz aviz) {
        instanta.avize.add(aviz);
        saveDb();
    }

    public static HashSet<Aviz> getAvize() {
        return instanta.avize;
    }

    public static void deleteProgramare(Programare value) {
        instanta.programari.remove(value);
    }

    public static void deleteAviz(Aviz value) {
        instanta.avize.remove(value);
    }

    public static void saveDb() {
        try (Writer writer = new FileWriter(dbFile)) {
            gson.toJson(instanta, writer);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}