/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Clan;
import domen.Mesto;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOVratiListuClanova extends AbstractSO{
    private List<AbstractObjekat> listaClanova;
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        listaClanova = db.vratiSveObjekte(new Clan());
        ucitajMesta();
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

    public List<AbstractObjekat> getListaClanova() {
        return listaClanova;
    }

    private void ucitajMesta() {
        for (AbstractObjekat abs : listaClanova) {
            try {
                Clan cl = (Clan) abs;
                cl.setMesto((Mesto) db.vratiObjekatPoKljucu(new Mesto(), Integer.parseInt(cl.getMesto().getMestoid())));
                System.out.println(cl.getMesto());
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            catch (SQLException ex) {
                Logger.getLogger(SOVratiListuClanova.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
