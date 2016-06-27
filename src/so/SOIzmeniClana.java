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
public class SOIzmeniClana extends AbstractSO {

    private AbstractObjekat clan;

    public SOIzmeniClana(AbstractObjekat clan) {
        this.clan = clan;
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
