/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Mesto;
import java.util.List;

/**
 *
 * @author vujke
 */
public class SOVratiListuMesta extends AbstractSO {
    
    private List<AbstractObjekat> listaMesta;

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        listaMesta = db.vratiSveObjekte(new Mesto());
        //super.izvrsiKonkretnuOperaciju(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<AbstractObjekat> getListaMesta() {
        return listaMesta;
    }

    @Override
    protected void izvrsiValidaciju() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void proveriPreduslove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
