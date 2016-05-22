/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Pretplata;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vujke
 */
public class SOPretraziPretplate extends AbstractSO{

    private AbstractObjekat pretplata;
    private List<AbstractObjekat> pretplate = new ArrayList<>();

    public SOPretraziPretplate(AbstractObjekat pretplata) {
        this.pretplata = pretplata;
    }
    
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju(){
        List<AbstractObjekat> svePretplate = db.vratiSveObjekte(pretplata);
        
        for (AbstractObjekat pretplataIzBaze : svePretplate) {
            Pretplata prb = (Pretplata) pretplataIzBaze;
            Pretplata p = (Pretplata) pretplata;
            
            if(p.getClan().getClanId() != null){
                if(prb.getClan().getClanId().equalsIgnoreCase(p.getClan().getClanId())){
                    AbstractObjekat pr = prb;
                    pretplate.add(pr);
                }
            }
            
            if(p.getPaket().getPaketId() != null){
                if(prb.getPaket().getPaketId().equalsIgnoreCase(p.getPaket().getPaketId())){
                    AbstractObjekat pr = prb;
                    pretplate.add(pr);
                }
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

    public AbstractObjekat getPretplata() {
        return pretplata;
    }

    public List<AbstractObjekat> getPretplate() {
        return pretplate;
    }
    
    
    
}
