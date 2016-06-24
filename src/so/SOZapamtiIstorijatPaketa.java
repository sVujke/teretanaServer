/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;

/**
 *
 * @author vujke
 */
public class SOZapamtiIstorijatPaketa extends AbstractSO{
    
    private AbstractObjekat istorijatPaketa;
    
    
    public SOZapamtiIstorijatPaketa(AbstractObjekat istorijatPaketa){
        this.istorijatPaketa = istorijatPaketa;
    }
    
    protected void izvrsiKonkretnuOperaciju() {
        db.sacuvajObjekat(istorijatPaketa);
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

    public AbstractObjekat getIstorijatPaketa() {
        return istorijatPaketa;
    }
    
}
