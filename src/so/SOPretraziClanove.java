/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Clan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vujke
 */
public class SOPretraziClanove extends AbstractSO {

    private List<AbstractObjekat> clanovi = new ArrayList<>();
    private String pretraga;

    public SOPretraziClanove(String pretraga) {
        //this.clanovi = clanovi;
        this.pretraga = pretraga;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
//        List<AbstractObjekat> sviClanovi = db.vratiSveObjekte(new Clan());
        SOVratiListuClanova sov = new SOVratiListuClanova();
        sov.izvrsiOperaciju();
        List<AbstractObjekat> sviClanovi = sov.getListaClanova();
        for (AbstractObjekat clanIzBaze : sviClanovi) {
            Clan clb = (Clan) clanIzBaze;

            if (clb.getIme().contains(pretraga) || clb.getAdresa().contains(pretraga)
                    || clb.getEmail().contains(pretraga)
                    || clb.getMesto().getNaziv().contains(pretraga)
                    || clb.getPrezime().contains(pretraga)) {

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

}
