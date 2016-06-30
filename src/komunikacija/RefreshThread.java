/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import kontroler.Kontroler;
import model.TblModelKorisnik;

/**
 *
 * @author vujke
 */
public class RefreshThread extends Thread {
        TblModelKorisnik tbl;

    public RefreshThread(TblModelKorisnik tbl) {
        this.tbl = tbl;
    }
    
    @Override
    public void run() {
        while(true){
            tbl.resetujTabelu(Kontroler.vratiKontrolera().getListaKorisnika());
            
        }
        
        
        //super.run(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
