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
public class SOIzmeniClana extends AbstractSO {

    private AbstractObjekat clan;
    private AbstractObjekat istorijatPaketa;
    IstorijatPaketa istorijatP;
    List<AbstractObjekat> izBaze;

    public SOIzmeniClana(List<Object> parametri) {
        this.clan = (AbstractObjekat) parametri.get(0);
        this.istorijatPaketa = (AbstractObjekat) parametri.get(1);
        this.istorijatP = (IstorijatPaketa) parametri.get(1);
    }

//    public SOIzmeniClana(List<Object> lista) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
        db.sacuvajIliAzurirajObjekat(clan);
        System.out.println("UPDATE CLANA");
        
        izBaze = db.vratiSveObjekte(new IstorijatPaketa());
        ucatijaClanovePakete();
        
        if(daLiMenjam()){
            dekativiraj();
            dodaj();
        }
        
        System.out.println("UPDATE IP Clana");
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

    private void ucatijaClanovePakete() {
         for (AbstractObjekat abs : izBaze) {
            try {
                IstorijatPaketa ip = (IstorijatPaketa) abs;
                ip.setClan((Clan) db.vratiObjekatPoKljucu(new Clan(), Integer.parseInt(ip.getClan().getClanId())));
                ip.setPaket((Paket) db.vratiObjekatPoKljucu(new Paket(), Integer.parseInt(ip.getPaket().getPaketId())));
            } catch (SQLException ex) {
                Logger.getLogger(SOVratiListuIstorijatPaketa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean daLiMenjam() {
        for (AbstractObjekat abs : izBaze) {
            IstorijatPaketa ip = (IstorijatPaketa) abs;
            if(ip.getClan().equals(istorijatP.getClan())
                    && !ip.getPaket().equals(istorijatP.getPaket())
                    && ip.isAktivan() == true){
                return true;
            }
            
//            if(ip.get)
        }
        
        return false;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void dekativiraj() {
        for (AbstractObjekat abs : izBaze) {
            IstorijatPaketa ip = (IstorijatPaketa) abs;
            if(ip.getClan().equals(istorijatP.getClan())
                    && !ip.getPaket().equals(istorijatP.getPaket())
                    && ip.isAktivan() == true){
//                return true;
                  ip.setAktivan(false);
                  System.out.println("CLANID: "+ip.getClan().getClanId() 
                          +" PAKET ID: "+ip.getPaket().getPaketId()+
                          "AKTIVAN: "+ip.isAktivan());
                  db.azurirajObjekat(ip);
            }
            
//            if(ip.get)
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void dodaj() {
        db.sacuvajObjekat(istorijatPaketa);
        System.out.println("DODAT PAKET!");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
