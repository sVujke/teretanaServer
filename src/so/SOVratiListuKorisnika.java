/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Korisnik;
import java.util.List;

/**
 *
 * @author vujke
 */
public class SOVratiListuKorisnika extends AbstractSO {
    
    private List<AbstractObjekat> listaKorisnika;

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        listaKorisnika = db.vratiSveObjekte(new Korisnik());
                
    }

    @Override
    protected void izvrsiValidaciju() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void proveriPreduslove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<AbstractObjekat> getListaKorisnika() {
        return listaKorisnika;
    }
    
}
