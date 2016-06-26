/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import jdk.nashorn.api.scripting.AbstractJSObject;
import kontroler.Kontroler;
import java.util.List;

/**
 *
 * @author vujke
 */
import domen.AbstractObjekat;
import domen.Clan;
import domen.Dolazak;
import domen.IstorijatPaketa;
import domen.Korisnik;
import domen.Mesto;
import domen.Paket;
import domen.Pretplata;
import domen.Termin;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws Exception {
        /*
        List<AbstractObjekat> korisnici =  Kontroler.vratiKontrolera().vratiListuKorisnika();
        
        for (AbstractObjekat ao : korisnici) {
            System.out.println(ao.vratiParametre());
        } 
         */

 /*AbstractObjekat clan = new Clan("2", "Perah", "Peric", "p@p.rs", "adresa", "0644282784", new Mesto(null, null, "1"));
       clan = Kontroler.vratiKontrolera().zapamtiClana(clan);
        System.out.println(clan);
         */
 /*
       AbstractObjekat clan = new Clan("2", "Perah", "Peric", "p@p.rs", "adresa", "0644282784", new Mesto(null, null, "1"));
       clan = Kontroler.vratiKontrolera().obrisiClana(clan);
       System.out.println(clan);
         */
 /*AbstractObjekat clan = new Clan("", "Pera", "Peric", "p@p.rs", "adresa", "0644282784", new Mesto(null, null, "1"));
       
       List<AbstractObjekat> clanovi = Kontroler.vratiKontrolera().pretraziClanove(clan);
        for (AbstractObjekat abstractObjekat : clanovi) {
                System.out.println(abstractObjekat);
        }
         */
 /*
       String string = "01.11.2011.";
       DateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
       Date date = format.parse(string);
       AbstractObjekat d = new Dolazak("2", date, "random", true, new Clan("1", null, null, null, null, null, null));
       AbstractObjekat dolazakBack = Kontroler.vratiKontrolera().zapamtiDolazak(d);
        System.out.println(dolazakBack);
         */
//       List<AbstractObjekat> paketi = Kontroler.vratiKontrolera().vratiListuPaketa();
//        for (AbstractObjekat abstractObjekat : paketi) {
//            System.out.println(abstractObjekat);
//        }
        /*
        List<AbstractObjekat> isp = Kontroler.vratiKontrolera().vratiListuIP();
        for (AbstractObjekat abstractObjekat : isp) {
            System.out.println(abstractObjekat);
        }
         */

 /*
       List<AbstractObjekat> abs = Kontroler.vratiKontrolera().vratiListuPretplata();
        for (AbstractObjekat abstractObjekat : abs) {
            System.out.println(abstractObjekat);
        }
         */
 /*
       AbstractObjekat a = new Paket("3", "srednji", "3010");
       AbstractObjekat r = Kontroler.vratiKontrolera().zapamtiPaket(a);
        System.out.println(r);
         */
 /*
       AbstractObjekat a = new Korisnik("piter", null, null, "petigru");
       AbstractObjekat r = Kontroler.vratiKontrolera().zapamtiPaket(a);
        System.out.println(r);
         */
 /*
       String string = "01.11.2011.";
       DateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
       Date date = format.parse(string);
        AbstractObjekat abs = new IstorijatPaketa(true, date, 
                new Clan("1", null, null, null, null, null, null), 
                new Paket("1", null, null), "0");
       AbstractObjekat r = Kontroler.vratiKontrolera().zapamtiIP(abs);
        System.out.println(r);
         */
 /*
       String string = "01.11.2011.";
       DateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
       Date date = format.parse(string);
       AbstractObjekat p = new Pretplata("1", date,new Clan("1", null,
               null, null, null, null, null), new Paket("1", null, null));
       AbstractObjekat pp = Kontroler.vratiKontrolera().zapamtiPretplatu(p);
        System.out.println(pp);
         */
 /*  String string = "01.11.2011.";
       DateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
       Date date = format.parse(string);
        AbstractObjekat p = new Pretplata("1", date,new Clan("1", null,
               null, null, null, null, null), new Paket(null, null, null));
        List<AbstractObjekat> k = 
                Kontroler.vratiKontrolera().pretraziPretplate(p);
        
        for (AbstractObjekat abstractObjekat : k) {
            System.out.println(abstractObjekat);
        } */
        //System.out.println(new File(".").getAbsolutePath());
//      
//      DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
//        Date date = new Date();
//        System.out.println(dateFormat.format(date));
//        System.out.println(date);

        /* 
        Date date = new Date();
        IstorijatPaketa ip = new IstorijatPaketa(true, date,
                new Clan("1", "Pera", "Peric", "p@p.rs", "adresa", 
                        "0644282784",new Mesto(null, null, "1")), new Paket("1", "jeftin", "2000z"), "0");
        Kontroler.vratiKontrolera().izmeniIP(ip);
         */
 /*
List<AbstractObjekat> lip = Kontroler.vratiKontrolera().vratiListuIP();
        
        for (AbstractObjekat abs : lip) {
            IstorijatPaketa ip = (IstorijatPaketa) abs;
            if(ip.getClan().getClanId().equals("4")){
                Kontroler.vratiKontrolera().obrisiIP(abs);
                System.out.println("BRISANJE IP");
            }
            
        }
        
        Clan c = new Clan("4",  null,
               null, null, null, null, null);
        Kontroler.vratiKontrolera().obrisiClana(c);
        System.out.println("BRISANJE CLANA");
        //System.out.println("");
    } 
         */
        Termin t = new Termin(null, true, new Paket("3", null, null), "8");

        Kontroler.vratiKontrolera().obrisiTermin(t);
        System.out.println("Obrisan");
    }
}
