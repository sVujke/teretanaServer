/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Clan;
import domen.IstorijatPaketa;
import domen.Paket;
import domen.Termin;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOVratiListuTermina extends AbstractSO{
    
    private List<AbstractObjekat> termini;
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
        termini = db.vratiSveObjekte(new Termin());
        ucitajPakete();
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

    public List<AbstractObjekat> getTermini() {
        return termini;
    }

    private void ucitajPakete() {
        for (AbstractObjekat abs : termini) {
            try {
                Termin t = (Termin) abs;
//                System.out.println(t);
//                System.out.println(t.getPaket().getPaketId());
                Paket p = (Paket)  db.vratiObjekatPoKljucu(new Paket(), Integer.parseInt(t.getPaket().getPaketId()));
                System.out.println("EVO ID PAKETA: "+p.getPaketId());
                t.setPaket(p);
//                System.out.println(t.getPaket().getPaketId());
            } catch (SQLException ex) {
                Logger.getLogger(SOVratiListuIstorijatPaketa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
