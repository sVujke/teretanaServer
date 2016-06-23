/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Clan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOVratiClanaPoPK extends AbstractSO{
    String id;
    AbstractObjekat clan;
    public SOVratiClanaPoPK(String id) {
        this.id = id;
    }
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        try {
            db.vratiObjekatPoKljucu(new Clan(), Integer.parseInt(id));
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(SOVratiClanaPoPK.class.getName()).log(Level.SEVERE, null, ex);
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

    public AbstractObjekat getClan() {
        return clan;
    }

    
    
    
    
}
