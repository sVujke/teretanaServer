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
import domen.Pretplata;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOObrisiClana extends AbstractSO {

    private AbstractObjekat clan;
    private List<AbstractObjekat> listaPretplata;
    private List<AbstractObjekat> listaIstorijatPaketa;

    public SOObrisiClana(AbstractObjekat clan) {
        this.clan = clan;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
        try {
            listaPretplata = db.vratiSveObjekte(new Pretplata());
            ucitajClanovePakete();
            for (AbstractObjekat abs : listaPretplata) {
                Pretplata p = (Pretplata) abs;
                if (p.getClan().equals(clan)) {
                    db.obrisiObjekat(abs);
                }
            }
            
            listaIstorijatPaketa = db.vratiSveObjekte(new IstorijatPaketa());
            ucitajClanovePaketeIP();
//            ucitajClanovePakete();
            for (AbstractObjekat abs : listaIstorijatPaketa) {
                IstorijatPaketa ip = (IstorijatPaketa) abs;
                if (ip.getClan().equals(clan)) {
                    db.obrisiObjekat(abs);
                }
            }

            db.obrisiObjekat(clan);

//            db.obrisiObjekat(clan);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(SOObrisiClana.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void ucitajClanovePakete() {
        for (AbstractObjekat abs : listaPretplata) {
            try {
                Pretplata ip = (Pretplata) abs;
                ip.setClan((Clan) db.vratiObjekatPoKljucu(new Clan(), Integer.parseInt(ip.getClan().getClanId())));
                ip.setPaket((Paket) db.vratiObjekatPoKljucu(new Paket(), Integer.parseInt(ip.getPaket().getPaketId())));
            } catch (SQLException ex) {
                Logger.getLogger(SOVratiListuIstorijatPaketa.class.getName()).log(Level.SEVERE, null, ex);
            }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    private void ucitajClanovePaketeIP() {
        for (AbstractObjekat abs : listaIstorijatPaketa) {
            try {
                IstorijatPaketa ip = (IstorijatPaketa) abs;
                ip.setClan((Clan) db.vratiObjekatPoKljucu(new Clan(), Integer.parseInt(ip.getClan().getClanId())));
                ip.setPaket((Paket) db.vratiObjekatPoKljucu(new Paket(), Integer.parseInt(ip.getPaket().getPaketId())));
            } catch (SQLException ex) {
                Logger.getLogger(SOVratiListuIstorijatPaketa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
