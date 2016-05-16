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
import domen.Korisnik;
public class Test {
    public static void main(String[] args) {
        List<AbstractObjekat> korisnici =  Kontroler.vratiKontrolera().vratiListuKorisnika();
        
        for (AbstractObjekat ao : korisnici) {
            System.out.println(ao.vratiParametre());
        }
    }
}
