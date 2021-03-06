/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
//import domen.Clan;
//import domen.IstorijatPaketa;
import domen.Korisnik;
//import domen.Paket;
//import domen.Termin;
import java.util.List;
import model.TblModelKorisnik;
import so.SOIzmeniClana;
//import so.SOIzmeniIstorijatPaketa;
import so.SOIzmeniPaket;
import so.SOObrisiClana;
//import so.SOObrisiIstorijatPaketa;
import so.SOObrisiKorisnika;
//import so.SOObrisiTermin;
import so.SOPretraziClanove;
import so.SOPretraziPakete;
import so.SOPretraziPretplate;
import so.SOPrijaviKorisnika;
//import so.SOVratiClanaPoPK;
import so.SOVratiListuClanova;
import so.SOVratiListuDolazaka;
import so.SOVratiListuIstorijatPaketa;
import so.SOVratiListuKorisnika;
import so.SOVratiListuMesta;
import so.SOVratiListuPaketa;
import so.SOVratiListuPretplata;
import so.SOVratiListuTermina;
import so.SOZapamtiClana;
import so.SOZapamtiDolazak;
//import so.SOZapamtiIstorijatPaketa;
import so.SOZapamtiKorisnika;
import so.SOZapamtiPaket;
import so.SOZapamtiPretplatu;
//import so.SOZapamtiTermin;

/**
 *
 * @author vujke
 */
public class Kontroler {

    private static Kontroler instance;
    private List<AbstractObjekat> listaKorisnika;
    private TblModelKorisnik tbl;
    
    public static Kontroler vratiKontrolera() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public static List<AbstractObjekat> vratiListuPretplata() {
        SOVratiListuPretplata som = new SOVratiListuPretplata();

        som.izvrsiOperaciju();
        return som.getPretplate();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<AbstractObjekat> pretraziPakete(String parametri) {
        System.out.println("U KONTROLERU: " + parametri);
        SOPretraziPakete som = new SOPretraziPakete(parametri);

        som.izvrsiOperaciju();
        return som.getPaketi();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<AbstractObjekat> vratiListuMesta() throws Exception {
        SOVratiListuMesta som = new SOVratiListuMesta();

        som.izvrsiOperaciju();
        return som.getListaMesta();
        //   return 
    }

    public static List<AbstractObjekat> vratiListuKorisnika() {
        SOVratiListuKorisnika som = new SOVratiListuKorisnika();

        som.izvrsiOperaciju();
        return som.getListaKorisnika();
    }

    public static List<AbstractObjekat> vratiListuIP() {
        SOVratiListuIstorijatPaketa som = new SOVratiListuIstorijatPaketa();

        som.izvrsiOperaciju();
        return som.getListaIstorijatPaketa();
    }

    public static List<AbstractObjekat> vratiListuDolazaka() {
        SOVratiListuDolazaka som = new SOVratiListuDolazaka();

        som.izvrsiOperaciju();
        return som.getListaDolazaka();
    }

    public static List<AbstractObjekat> vratiListuClanova() {
        SOVratiListuClanova som = new SOVratiListuClanova();

        som.izvrsiOperaciju();
        return som.getListaClanova();
    }

    public static AbstractObjekat prijaviKorisnika(Korisnik k) throws Exception {
        SOPrijaviKorisnika som = new SOPrijaviKorisnika((AbstractObjekat) k);

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getKorisnik();
    }

    public static AbstractObjekat zapamtiClana(List<Object> parametri) throws Exception {
        SOZapamtiClana som = new SOZapamtiClana(parametri);
        //SOZapamtiIstorijatPaketa som2 = new SOZapamtiIstorijatPaketa((AbstractObjekat) parametri.get(1));
        som.izvrsiOperaciju();
        //som2.izvrsiOperaciju();
        System.out.println("izvrsena operacija ZAPAMTI_CLANA");
        return som.getClan();

    }

    public static AbstractObjekat obrisiClana(AbstractObjekat clan) {
        SOObrisiClana som = new SOObrisiClana(clan);

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getClan();
    }

    public static List<AbstractObjekat> pretraziClanove(String pretraga) {
        SOPretraziClanove som = new SOPretraziClanove(pretraga);

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getClanovi();
    }

    public static AbstractObjekat zapamtiDolazak(AbstractObjekat dolazak) {
        SOZapamtiDolazak som = new SOZapamtiDolazak(dolazak);

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getDolazak();
    }

    public static List<AbstractObjekat> vratiListuPaketa() {
        SOVratiListuPaketa som = new SOVratiListuPaketa();

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getPaketi();
    }
    
    public static List<AbstractObjekat> vratiListuTermina() {
        SOVratiListuTermina som = new SOVratiListuTermina();

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getTermini();
    }

    public static AbstractObjekat zapamtiPaket(List<Object> lista) {
        SOZapamtiPaket som = new SOZapamtiPaket(lista);

        som.izvrsiOperaciju();

        System.out.println("izvrsena operacija ZAPAMTI PAKET");
        return som.getPaket();
    }

    public static AbstractObjekat izmeniPaket(List<Object> lista) {
        
        
        SOIzmeniPaket som = new SOIzmeniPaket(lista);
        som.izvrsiOperaciju();
        
        System.out.println("izvrsena operacija");
        return som.getPaket();
    }

    public static AbstractObjekat zapamtiKorisnika(AbstractObjekat korisnik) {
        SOZapamtiKorisnika som = new SOZapamtiKorisnika(korisnik);

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getKorisnik();
    }

    public static AbstractObjekat obrisiKorisnika(AbstractObjekat korisnik) {
        SOObrisiKorisnika som = new SOObrisiKorisnika(korisnik);

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getKorisnik();
    }

//    public static AbstractObjekat obrisiTermin(AbstractObjekat termin) {
//        SOObrisiTermin som = new SOObrisiTermin(termin);
//
//        som.izvrsiOperaciju();
//        System.out.println("izvrsena operacija");
//        return som.getTermin();
//    }
//
//    public static AbstractObjekat zapamtiTermin(AbstractObjekat termin) {
//        SOZapamtiTermin som = new SOZapamtiTermin(termin);
//
//        som.izvrsiOperaciju();
//        System.out.println("izvrsena operacija");
//        return som.getTermin();
//    }

    public static AbstractObjekat zapamtiPretplatu(AbstractObjekat pretplata) {
        SOZapamtiPretplatu som = new SOZapamtiPretplatu(pretplata);

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getPretplata();
    }

    public static List<AbstractObjekat> pretraziPretplate(List<AbstractObjekat> parametri) {
        SOPretraziPretplate som = new SOPretraziPretplate(parametri);

        som.izvrsiOperaciju();
        System.out.println("izvrsena operacija");
        return som.getPretplate();
    }

    public List<AbstractObjekat> getListaKorisnika() {
        if (listaKorisnika == null) {
            listaKorisnika = vratiListuKorisnika();
        }
        return listaKorisnika;
    }

    public void setListaKorisnika(List<AbstractObjekat> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }

//    public static AbstractObjekat vratiClanaPoPK(String id) {
//        SOVratiClanaPoPK som = new SOVratiClanaPoPK(id);
//
//        som.izvrsiOperaciju();
//        System.out.println("izvrsena operacija");
//        return som.getClan();
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    public static AbstractObjekat zapamtiIP(AbstractObjekat ip) {
//        SOZapamtiIstorijatPaketa som = new SOZapamtiIstorijatPaketa(ip);
//
//        som.izvrsiOperaciju();
//        System.out.println("izvrsena operacija");
//        return som.getIstorijatPaketa();
//    }

//    public static AbstractObjekat izmeniIP(AbstractObjekat ip) {
//        SOIzmeniIstorijatPaketa som = new SOIzmeniIstorijatPaketa(ip);
//
//        som.izvrsiOperaciju();
//        System.out.println("izvrsena operacija");
//        return som.getIstorijatPaketa();
//    }
    
    public static AbstractObjekat izmeniClana(List<Object> lista) {
        System.out.println("Izmeni clana kontroler");
        SOIzmeniClana som = new SOIzmeniClana(lista);

        som.izvrsiOperaciju();
        //izmeniIP((AbstractObjekat) lista.get(1));
        System.out.println("izvrsena operacija IZMENI_CLANA");
        return som.getClan();
    }

//    public static AbstractObjekat obrisiIP(AbstractObjekat ip) {
//        SOObrisiIstorijatPaketa som = new SOObrisiIstorijatPaketa(ip);
//
//        som.izvrsiOperaciju();
//        System.out.println("izvrsena operacija");
//        return som.getIstorijatPaketaBrisem();
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    public TblModelKorisnik getTbl() {
//        return tbl;
//    }

}
