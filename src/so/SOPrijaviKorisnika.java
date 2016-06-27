/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Korisnik;
import java.util.List;
import kontroler.Kontroler;

/**
 *
 * @author vujke
 */
public class SOPrijaviKorisnika extends AbstractSO {
    
    private AbstractObjekat korisnik;
    private List<AbstractObjekat> listaKorisnika;
    
    public SOPrijaviKorisnika(AbstractObjekat korisnik){
        this.korisnik = korisnik;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
       Korisnik korUserPas = (Korisnik) korisnik;
       listaKorisnika  = db.vratiSveObjekte(new Korisnik());
       boolean nema = false;
       
        for (AbstractObjekat aKorisnik : listaKorisnika) {
            Korisnik kor = (Korisnik) aKorisnik;
            if(kor.equals(korUserPas)){
//                korisnik = kor;
                Korisnik k = kor;
                //k.setStatusKorisnika("online");
                int indeks = Kontroler.vratiKontrolera().getListaKorisnika().indexOf(k);
                
                ((Korisnik)Kontroler.vratiKontrolera().getListaKorisnika().get(indeks)).setStatusKorisnika("online");
                Korisnik x = (Korisnik) Kontroler.vratiKontrolera().getListaKorisnika().get(indeks);
                System.out.println("Pronadjen");
                System.out.println("STATUS: "+x.getStatusKorisnika());
                nema = true;
                break;
            }
            
        }
        
        if(nema == false){
            korisnik = null;
            System.out.println("Nije pronadjen");
        }
        //korisnik = null;
        //System.out.println("Nije pronadjen");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void izvrsiValidaciju() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void proveriPreduslove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setKorisnik(AbstractObjekat korisnik) {
        this.korisnik = korisnik;
    }

    public AbstractObjekat getKorisnik() {
        return korisnik;
    }
    
    
}
