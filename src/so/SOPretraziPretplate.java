/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Clan;
import domen.Paket;
import domen.Pretplata;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOPretraziPretplate extends AbstractSO{

    private List<AbstractObjekat> parametri;
    private Clan clan;
    private Paket paket;
    private List<AbstractObjekat> pretplate = new ArrayList<>();

    public SOPretraziPretplate(List<AbstractObjekat> parametri) {
        this.parametri = parametri;
        this.clan = (Clan) parametri.get(1);
        this.paket = (Paket) parametri.get(0);
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        List<AbstractObjekat> izBaze = db.vratiSveObjekte(new Pretplata());
        ucitajClanovePakete(izBaze);
        System.out.println("IZVUCENO PRETPLATA "+izBaze.size());
        System.out.println("pre fora");
        for (AbstractObjekat abs : izBaze) {
            System.out.println("usao u for");
            Pretplata p = (Pretplata) abs;
            if(p.getClan().equals(clan) && p.getPaket().equals(paket)){
                System.out.println("USLOV ISPUNJEN");
                pretplate.add(abs);
            }
        }
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

    public List<AbstractObjekat> getPretplate() {
        return pretplate;
    }

    private void ucitajClanovePakete(List<AbstractObjekat> izBaze) {
        for (AbstractObjekat abs : izBaze) {
            try {
                Pretplata ip = (Pretplata) abs;
                ip.setClan((Clan) db.vratiObjekatPoKljucu(new Clan(), Integer.parseInt(ip.getClan().getClanId())));
                ip.setPaket((Paket) db.vratiObjekatPoKljucu(new Paket(), Integer.parseInt(ip.getPaket().getPaketId())));
            } catch (SQLException ex) {
                Logger.getLogger(SOVratiListuIstorijatPaketa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
   
    
    
    
}
