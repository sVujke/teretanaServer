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
public class SOZapamtiPretplatu extends AbstractSO {
    
    private AbstractObjekat pretplata;

    public SOZapamtiPretplatu(AbstractObjekat pretplata) {
        this.pretplata = pretplata;
    }
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
            db.sacuvajIliAzurirajObjekat(pretplata);
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

    public AbstractObjekat getPretplata() {
        return pretplata;
    }
    
    
    
}
