/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOZapamtiDolazak extends AbstractSO {
    
    private AbstractObjekat dolazak;

    public SOZapamtiDolazak(AbstractObjekat dolazak) {
        this.dolazak = dolazak;
    }
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
            db.sacuvajObjekat(dolazak);
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    protected void izvrsiValidaciju() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void proveriPreduslove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AbstractObjekat getDolazak() {
        return dolazak;
    }
    
    
    
}
