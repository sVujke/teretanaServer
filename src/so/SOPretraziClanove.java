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
    private AbstractObjekat clan; 

    public SOPretraziClanove(AbstractObjekat clan) {
        //this.clanovi = clanovi;
        this.clan = clan;
    }
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        List<AbstractObjekat> sviClanovi = db.vratiSveObjekte(clan);
        for (AbstractObjekat clanIzBaze : sviClanovi) {
            Clan clb = (Clan) clanIzBaze;
            System.out.println(clb);
            Clan c = (Clan) clan;
            System.out.println(c);
            
            if(clb.getIme().equals(c.getIme())){
                AbstractObjekat cb = clb;
                clanovi.add(cb);
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

    public AbstractObjekat getClan() {
        return clan;
    }
    
}
