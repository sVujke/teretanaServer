/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Paket;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static kontroler.Kontroler.obrisiTermin;

/**
 *
 * @author vujke
 */
public class SOIzmeniPaket extends AbstractSO {
    
    private AbstractObjekat paket;
//    Paket paket;
    List<AbstractObjekat> zaBrisanje;
    List<AbstractObjekat> zaUbacivanje;

//    public SOIzmeniPaket(List<Objekat> lista) {
//        this.paket = (Paket) lista.get(0);
//        this.zaBrisanje = (List<AbstractObjekat>) lista.get(1);
//        this.zaUbacivanje = (List<AbstractObjekat>) lista.get(2);    
//    }

//    public SOIzmeniPaket(List<Objekat> lista) {
//        
//    }

    public SOIzmeniPaket(List<Object> lista) {
        this.paket = (AbstractObjekat) lista.get(1);
        this.zaBrisanje = (List<AbstractObjekat>) lista.get(0);
        this.zaUbacivanje = (List<AbstractObjekat>) lista.get(2);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        System.out.println("-----------------------------------------------"
                + "SOOOOOOOOOOOOOOOO--------------------------------------");
         
        for (AbstractObjekat abs : zaBrisanje) {
            obrisiTermin(abs);
            System.out.println("BRISEM TERMIN");
        }
        
        db.sacuvajIliAzurirajObjekat(paket);
        
        Paket p = (Paket) getPaket();
        String idPaketa = p.getPaketId();
        
        for (AbstractObjekat abs : zaUbacivanje) {
            zapamtiTermin(abs);
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

    public AbstractObjekat getPaket() {
        return paket;
    }

    private void obrisiTermin(AbstractObjekat abs) {
        try {
            db.obrisiObjekat(abs);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(SOIzmeniPaket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void zapamtiTermin(AbstractObjekat abs) {
        db.sacuvajObjekat(abs);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
