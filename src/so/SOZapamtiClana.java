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
    private AbstractObjekat istorijatPaketa;
//    private AbstractObjekat paket;
//    private List<AbstractObjekat> listaIP;
    
    public SOZapamtiClana(List<Object> parametri) {
        this.clan = (AbstractObjekat) parametri.get(0);
        this.istorijatPaketa = (AbstractObjekat) parametri.get(1);
    }
  
    @Override
    protected void izvrsiKonkretnuOperaciju() {
        
            db.sacuvajObjekat(clan);
            
            //db.potvrdiTransakciju();
            System.out.println("SACUVAN JE CLAN");
            
            db.sacuvajObjekat(istorijatPaketa);
            
            System.out.println("SACUVAN JE IP za CLANA");
            
            //Clan c = (Clan) clan;
            //Paket p = (Paket) paket;
            
            //ubaciPrvuEvidenciju(c, p);
            //System.out.println("SACUVAN JE ISTORIJA PAKETA");
            
//            listaIP = db.vratiSveObjekte(new IstorijatPaketa());
//            
//            IstorijatPaketa izEvidencije = clanVecImaAktivanPaket(listaIP, c, p);
//            
//            if(izEvidencije != null){
//                IstorijatPaketa istorijatP = promeniStatusAktuelnogPaketa(izEvidencije);
//                System.out.println("ubaci NovuEvidenciju");
                   // ubaciNovuEvidenciju(istorijatP,c,p);
//                System.out.println("POSLE ubaci  NovuEvidenciju");
//            }else{
//                System.out.println("ubaci prvu evidenciju");
//                ubaciPrvuEvidenciju(c,p);
//                System.out.println("POSLE ubaci prvu evidenciju");
//            }
           
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

  
    private Date danasnjiDatum(){
       // DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
        return date;
//        String string = "01.11.2011.";
//       DateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
//       Date date = format.parse(string);
    }

//    private void ubaciEvidencijuPaketa() {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    

    
    
}
