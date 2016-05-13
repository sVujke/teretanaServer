/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;

/**
 *
 * @author vujke
 */
public class AbstractSO {
    protected DBBroker db;

    public AbstractSO() {
        db = new DBBroker();
    }
    
    public void izvrsiOperaciju(){
        db.konektujSe();
        //izvrsiValidaciju();
        //proveriPreduslove();
        izvrsiKonkretnuOperaciju();
        db.potvrdiTransakciju();
        db.diskonektujSe();
    }

    private void izvrsiKonkretnuOperaciju() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void izvrsiValidaciju() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void proveriPreduslove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
