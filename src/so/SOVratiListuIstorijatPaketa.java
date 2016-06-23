/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.IstorijatPaketa;
import java.util.List;

/**
 *
 * @author vujke
 */
public class SOVratiListuIstorijatPaketa extends AbstractSO {

    List<AbstractObjekat> listaIstorijatPaketa ;
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        listaIstorijatPaketa = db.vratiSveObjekte(new IstorijatPaketa());
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
    
}
