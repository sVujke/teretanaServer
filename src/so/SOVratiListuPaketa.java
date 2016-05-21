/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Paket;
import java.util.List;

/**
 *
 * @author vujke
 */
public class SOVratiListuPaketa extends AbstractSO {
    
    private List<AbstractObjekat> paketi;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        paketi = db.vratiSveObjekte(new Paket());
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

    public List<AbstractObjekat> getPaketi() {
        return paketi;
    }
    
}
