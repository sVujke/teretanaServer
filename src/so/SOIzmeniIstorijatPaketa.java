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
public class SOIzmeniIstorijatPaketa extends AbstractSO {

    private AbstractObjekat istorijatPaketa;
    IstorijatPaketa istorijatP;
    List<AbstractObjekat> izBaze;

    public SOIzmeniIstorijatPaketa(AbstractObjekat istorijatPaketa) {
        this.istorijatPaketa = istorijatPaketa;
        this.istorijatP = (IstorijatPaketa) istorijatPaketa;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        izBaze = db.vratiSveObjekte(new IstorijatPaketa());
        ucatijaClanovePakete();
        
        if(daLiMenjam()){
            dekativiraj();
            dodaj();
        }
//        String idPaketa = DaLiJePaketUBazi();

//        System.out.println("ID PAKETA: "+idPaketa);
        
//        if(idPaketa.equals("0")){
//            deaktiviraj();
//            dodaj();
//        }else{
//            deaktiviraj();
////            aktiviraj(idPaketa);
//            dodaj();
//        }
        
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private IstorijatPaketa imaVecAktivan(List<AbstractObjekat> izBaze) {
        for (AbstractObjekat abs : izBaze) {
            IstorijatPaketa ip = (IstorijatPaketa) abs;
            System.out.println(ip.getClan().getClanId() + "-----" + ip.getPaket().getPaketId() + "-------" + ip.isAktivan());
            if (ip.getClan().equals(istorijatP.getClan())
                    && ip.getPaket().equals(istorijatP.getPaket())
                    && ip.isAktivan() == true) {
                return ip;
            }
        }

        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private String DaLiJePaketUBazi() {
        for (AbstractObjekat abs : izBaze) {
            IstorijatPaketa ip = (IstorijatPaketa) abs;
            if (ip.getPaket().equals(istorijatP.getPaket())
                    && ip.getClan().equals(istorijatP.getClan())) {
                return istorijatP.getPaket().getPaketId();
            }
        }

        return "0";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void deaktiviraj() {
        for (AbstractObjekat abs : izBaze) {
            IstorijatPaketa ip = (IstorijatPaketa) abs;
            System.out.println("PRe IF-a");
            if ( ip.getClan().equals(istorijatP.getClan())
                    && ip.isAktivan() == true) {
                ip.setAktivan(false);
                System.out.println("DEAKTIVIRAN paket: "+ip.getPaket().getPaketId());
//                AbstractObjekat ab = ip;
                db.sacuvajIliAzurirajObjekat(ip);
            }
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void dodaj() {
        db.sacuvajObjekat(istorijatPaketa);
        System.out.println("DODAT PAKET!");
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
