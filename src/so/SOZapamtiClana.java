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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class SOZapamtiClana extends AbstractSO {
    
    private List<Object> parametri;
    private AbstractObjekat clan;
    private AbstractObjekat paket;
    private List<AbstractObjekat> listaIP;
    
    public SOZapamtiClana(List<Object> parametri) {
        this.clan = (AbstractObjekat) parametri.get(0);
        this.paket = (AbstractObjekat) parametri.get(1);
    }
  
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
            db.sacuvajIliAzurirajObjekat(clan);
            Clan c = (Clan) clan;
            Paket p = (Paket) paket;
            SOVratiListuIstorijatPaketa som = new SOVratiListuIstorijatPaketa();
            listaIP = som.getListaIstorijatPaketa();
            
            IstorijatPaketa izEvidencije = clanVecImaAktivanPaket(listaIP, c, p);
            if(izEvidencije != null){
                IstorijatPaketa istorijatP = promeniStatusAktuelnogPaketa(izEvidencije);
                ubaciNovuEvidenciju(istorijatP,c,p);
            }else{
                ubaciPrvuEvidenciju(c,p);
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

    public AbstractObjekat getClan() {
        return clan;
    }

    private IstorijatPaketa clanVecImaAktivanPaket(List<AbstractObjekat> listaIP, Clan c, Paket p) {
         for (AbstractObjekat abs : listaIP) {
                IstorijatPaketa ip = (IstorijatPaketa) abs;
                if(ip.getClan().getClanId().equals(c.getClanId())
                        && ip.getPaket().getPaketId().equals(p.getPaketId())
                        && ip.getStatus() == 1){
                    System.out.println("NADJEN PAKET KOJI JE VEC AKTIVAN!");
                    return ip;
                }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private IstorijatPaketa promeniStatusAktuelnogPaketa(IstorijatPaketa izEvidencije) {
        izEvidencije.setStatus(0);
        
        return izEvidencije;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ubaciAktuelnuEvidenciju(IstorijatPaketa torijatP, Clan c, Paket p) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ubaciNovuEvidenciju(IstorijatPaketa torijatP, Clan c, Paket p) {
        
        SOZapamtiIstorijatPaketa som = new SOZapamtiIstorijatPaketa(torijatP);
        som.izvrsiKonkretnuOperaciju();
        
        IstorijatPaketa isp = new IstorijatPaketa(true, danasnjiDatum(), c, p, "0");
        SOZapamtiIstorijatPaketa so = new SOZapamtiIstorijatPaketa(isp);
        so.izvrsiKonkretnuOperaciju();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ubaciPrvuEvidenciju(Clan c, Paket p) {
        IstorijatPaketa isp = new IstorijatPaketa(true, danasnjiDatum(), c, p, "0");
        SOZapamtiIstorijatPaketa so = new SOZapamtiIstorijatPaketa(isp);
        so.izvrsiKonkretnuOperaciju();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Date danasnjiDatum(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
        return date;
//        String string = "01.11.2011.";
//       DateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
//       Date date = format.parse(string);
    }

    

    
    
}
