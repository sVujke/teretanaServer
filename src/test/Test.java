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
import domen.Korisnik;
import domen.Mesto;
import domen.Paket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Test {
    public static void main(String[] args) throws Exception {
        List<AbstractObjekat> korisnici =  Kontroler.vratiKontrolera().vratiListuKorisnika();
        
        for (AbstractObjekat ao : korisnici) {
            System.out.println(ao.vratiParametre());
        } 
      
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
       /*
       List<AbstractObjekat> paketi = Kontroler.vratiKontrolera().vratiListuPaketa();
        for (AbstractObjekat abstractObjekat : paketi) {
            System.out.println(abstractObjekat);
        }
        */
       /*
       AbstractObjekat a = new Paket("3", "srednji", "3010");
       AbstractObjekat r = Kontroler.vratiKontrolera().zapamtiPaket(a);
        System.out.println(r);
       */ 
       
       
       AbstractObjekat a = new Korisnik("piter", null, null, "petigru");
       AbstractObjekat r = Kontroler.vratiKontrolera().zapamtiPaket(a);
        System.out.println(r);
       
        
    }
}
