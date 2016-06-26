/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;

/**
 *
 * @author vujke
 */
public class SOIzmeniPaket extends AbstractSO {
    
    private AbstractObjekat paket;

    public SOIzmeniPaket(AbstractObjekat paket) {
        this.paket = paket;
    }
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        db.sacuvajIliAzurirajObjekat(paket);
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

    public AbstractObjekat getPaket() {
        return paket;
    }
    
}
