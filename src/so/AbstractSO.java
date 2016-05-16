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
public abstract class AbstractSO {
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

    protected abstract void izvrsiKonkretnuOperaciju();

    protected abstract void izvrsiValidaciju();

    protected abstract void proveriPreduslove();
    

    
}
