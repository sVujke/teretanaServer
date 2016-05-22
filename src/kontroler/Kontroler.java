/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import domen.Korisnik;
import java.util.List;
import so.SOObrisiClana;
import so.SOObrisiKorisnika;
import so.SOPretraziClanove;
import so.SOPretraziPretplate;
import so.SOPrijaviKorisnika;
import so.SOVratiListuKorisnika;
import so.SOVratiListuMesta;
import so.SOVratiListuPaketa;
import so.SOZapamtiClana;
import so.SOZapamtiDolazak;
import so.SOZapamtiKorisnika;
import so.SOZapamtiPaket;
import so.SOZapamtiPretplatu;

/**
 *
 * @author vujke
 */
public class Kontroler {
    
    private static Kontroler instance;
    
    public static Kontroler vratiKontrolera(){
        if(instance == null){
            instance = new Kontroler();
        }
        return instance;
    }
    
    public static List<AbstractObjekat> vratiListuMesta() throws Exception {
        SOVratiListuMesta som = new SOVratiListuMesta();

        som.izvrsiOperaciju();
        return som.getListaMesta();
     //   return 
    }
    
    public static List<AbstractObjekat> vratiListuKorisnika(){
        SOVratiListuKorisnika som = new SOVratiListuKorisnika();
        
        som.izvrsiOperaciju();
        return som.getListaKorisnika();
    }
    
    public static AbstractObjekat prijaviKorisnika(Korisnik k) throws Exception{
        SOPrijaviKorisnika som = new SOPrijaviKorisnika((AbstractObjekat) k);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getKorisnik();
    } 
    
    public static AbstractObjekat zapamtiClana(AbstractObjekat clan) throws Exception {
        SOZapamtiClana som = new SOZapamtiClana(clan);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getClan();
    }
    
    public static  AbstractObjekat obrisiClana(AbstractObjekat clan){
        SOObrisiClana som = new SOObrisiClana(clan);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getClan();
    }
    
    public static  List<AbstractObjekat> pretraziClanove(AbstractObjekat clan){
        SOPretraziClanove som = new SOPretraziClanove(clan);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getClanovi();
    }
    
    public static AbstractObjekat zapamtiDolazak(AbstractObjekat dolazak){
        SOZapamtiDolazak som = new SOZapamtiDolazak(dolazak);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getDolazak();
    }
    
    public static List<AbstractObjekat> vratiListuPaketa(){
        SOVratiListuPaketa som = new SOVratiListuPaketa();
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getPaketi();
    }
    
    public static AbstractObjekat zapamtiPaket(AbstractObjekat paket){
        SOZapamtiPaket som = new SOZapamtiPaket(paket);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getPaket();
    }
    
    public static AbstractObjekat zapamtiKorisnika(AbstractObjekat korisnik){
        SOZapamtiKorisnika som = new SOZapamtiKorisnika(korisnik);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getKorisnik();
    }
    
    public static  AbstractObjekat obrisiKorisnika(AbstractObjekat korisnik){
        SOObrisiKorisnika som = new SOObrisiKorisnika(korisnik);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getKorisnik();
    }
    
    public static AbstractObjekat zapamtiPretplatu(AbstractObjekat pretplata){
        SOZapamtiPretplatu som = new SOZapamtiPretplatu(pretplata);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getPretplata();
    }
    
    public static List<AbstractObjekat> pretraziPretplate(AbstractObjekat pretplata){
        SOPretraziPretplate som = new SOPretraziPretplate(pretplata);
        
        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getPretplate();
    }
    
}
