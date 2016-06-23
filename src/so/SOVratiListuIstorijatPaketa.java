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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOVratiListuIstorijatPaketa extends AbstractSO {

    private List<AbstractObjekat> listaIstorijatPaketa;
   
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        listaIstorijatPaketa = db.vratiSveObjekte(new IstorijatPaketa());
        ucitajClanovePakete();
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

    public List<AbstractObjekat> getListaIstorijatPaketa() {
        return listaIstorijatPaketa;
    }
    
    public void ucitajClanovePakete(){
        for (AbstractObjekat abs : listaIstorijatPaketa) {
            try {
                IstorijatPaketa ip = (IstorijatPaketa) abs;
                ip.setClan((Clan) db.vratiObjekatPoKljucu(new Clan(), Integer.parseInt(ip.getClan().getClanId())));
                ip.setPaket((Paket) db.vratiObjekatPoKljucu(new Paket(), Integer.parseInt(ip.getPaket().getPaketId())));
            } catch (SQLException ex) {
                Logger.getLogger(SOVratiListuIstorijatPaketa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    
}
