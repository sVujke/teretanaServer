/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Clan;
import domen.Paket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vujke
 */
public class SOPretraziPakete extends AbstractSO{
    
    private List<AbstractObjekat> paketi = new ArrayList<>();
    private String pretraga;
    
    public SOPretraziPakete(String pretraga) {
        //this.clanovi = clanovi;
        this.pretraga = pretraga.toLowerCase();
        System.out.println("U KONSTRUKTORU: "+pretraga);
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
        List<AbstractObjekat> sviPaketi = db.vratiSveObjekte(new Paket());
        for (AbstractObjekat abs : sviPaketi) {
            Paket pak = (Paket) abs;

            if (pak.getNaziv().contains(pretraga) || pak.getCena().contains(pretraga)) {
                System.out.println("EVO GA");
                paketi.add(pak);
            }
        }
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

    public List<AbstractObjekat> getPaketi() {
        return paketi;
    }
    
}
