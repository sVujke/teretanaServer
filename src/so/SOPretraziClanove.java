/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Clan;
import domen.Mesto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOPretraziClanove extends AbstractSO {

    private List<AbstractObjekat> clanovi = new ArrayList<>();
    List<AbstractObjekat> sviClanovi;
    private String pretraga;

    public SOPretraziClanove(String pretraga) {
        //this.clanovi = clanovi;
        this.pretraga = pretraga.toLowerCase();
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
//        List<AbstractObjekat> sviClanovi = db.vratiSveObjekte(new Clan());
        sviClanovi = db.vratiSveObjekte(new Clan());
        ucitajMesta();
        for (AbstractObjekat clanIzBaze : sviClanovi) {
            Clan clb = (Clan) clanIzBaze;

            if (clb.getIme().toLowerCase().contains(pretraga) || clb.getAdresa().toLowerCase().contains(pretraga)
                    || clb.getEmail().toLowerCase().contains(pretraga)
                    || clb.getMesto().getNaziv().toLowerCase().contains(pretraga)
                    || clb.getPrezime().toLowerCase().contains(pretraga)||
                    clb.getTelefon().toLowerCase().contains(pretraga)
                    || clb.getMesto().getNaziv().contains(pretraga)) {

                clanovi.add(clb);
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

    public List<AbstractObjekat> getClanovi() {
        return clanovi;
    }

    private void ucitajMesta() {
        for (AbstractObjekat abs : sviClanovi) {
            try {
                Clan cl = (Clan) abs;
                cl.setMesto((Mesto) db.vratiObjekatPoKljucu(new Mesto(), Integer.parseInt(cl.getMesto().getMestoid())));
                //System.out.println(cl.getMesto());
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            catch (SQLException ex) {
                Logger.getLogger(SOVratiListuClanova.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
