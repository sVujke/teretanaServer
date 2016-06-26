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
public class SOObrisiTermin extends AbstractSO  {

    private AbstractObjekat termin;

    public SOObrisiTermin(AbstractObjekat termin) {
        this.termin = termin;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        try {
            db.obrisiObjekat(termin);
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(SOObrisiTermin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void izvrsiValidaciju() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void proveriPreduslove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AbstractObjekat getTermin() {
        return termin;
    }
    
}
