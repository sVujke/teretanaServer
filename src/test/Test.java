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
import domen.Korisnik;
import domen.Mesto;
public class Test {
    public static void main(String[] args) throws Exception {
       /* List<AbstractObjekat> korisnici =  Kontroler.vratiKontrolera().vratiListuKorisnika();
        
        for (AbstractObjekat ao : korisnici) {
            System.out.println(ao.vratiParametre());
        } */
       AbstractObjekat clan = new Clan("2", "Perah", "Peric", "p@p.rs", "adresa", "0644282784", new Mesto(null, null, "1"));
       clan = Kontroler.vratiKontrolera().zapamtiClana(clan);
        System.out.println(clan);
    }
}
