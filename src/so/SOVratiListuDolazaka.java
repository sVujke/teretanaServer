/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Clan;
import domen.Dolazak;
import domen.Mesto;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOVratiListuDolazaka extends AbstractSO {
    List<AbstractObjekat> listaDolazaka;
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        listaDolazaka = db.vratiSveObjekte(new Dolazak());
        ucitajClanove();
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

    public List<AbstractObjekat> getListaDolazaka() {
        return listaDolazaka;
    }

    private void ucitajClanove() {
        for (AbstractObjekat abs : listaDolazaka) {
            try {
                Dolazak dl = (Dolazak) abs;
                dl.setClan((Clan) db.vratiObjekatPoKljucu(new Clan(), Integer.parseInt(dl.getClan().getClanId())));
                //System.out.println(cl.getMesto());
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            catch (SQLException ex) {
                Logger.getLogger(SOVratiListuClanova.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
