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
public class SOZapamtiClana extends AbstractSO {
    
    private List<Object> parametri;
    private AbstractObjekat clan;
    private AbstractObjekat paket;
    
    public SOZapamtiClana(List<Object> parametri) {
        this.clan = (AbstractObjekat) parametri.get(0);
        this.paket = (AbstractObjekat) parametri.get(1);
    }
  
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
            db.sacuvajIliAzurirajObjekat(clan);
       
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

    public AbstractObjekat getClan() {
        return clan;
    }

    

    
    
}
