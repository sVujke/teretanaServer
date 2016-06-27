/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOZapamtiPaket extends AbstractSO{
    
    private AbstractObjekat paket;
    List<AbstractObjekat> termini;

    public SOZapamtiPaket(List<Object> lista) {
        this.paket = (AbstractObjekat) lista.get(0);
        this.termini = (List<AbstractObjekat>) lista.get(1);
    }
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
            db.sacuvajObjekat(paket);
            
            for (AbstractObjekat abs : termini) {
            zapamtiTermin(abs);
        }
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

    private void zapamtiTermin(AbstractObjekat abs) {
        db.sacuvajObjekat(abs);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
