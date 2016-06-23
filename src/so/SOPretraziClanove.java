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
        this.pretraga = pretraga.toLowerCase();
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() {
//        List<AbstractObjekat> sviClanovi = db.vratiSveObjekte(new Clan());
        SOVratiListuClanova sov = new SOVratiListuClanova();
        sov.izvrsiOperaciju();
        List<AbstractObjekat> sviClanovi = sov.getListaClanova();
        for (AbstractObjekat clanIzBaze : sviClanovi) {
            Clan clb = (Clan) clanIzBaze;

            if (clb.getIme().toLowerCase().contains(pretraga) || clb.getAdresa().toLowerCase().contains(pretraga)
                    || clb.getEmail().toLowerCase().contains(pretraga)
                    || clb.getMesto().getNaziv().toLowerCase().contains(pretraga)
                    || clb.getPrezime().toLowerCase().contains(pretraga)||
                    clb.getTelefon().toLowerCase().contains(pretraga)) {

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
