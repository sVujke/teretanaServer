/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import domen.AbstractObjekat;
import domen.Korisnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;
import transfer.KlijentTransfer;
import transfer.ServerTransfer;

/**
 *
 * @author vujke
 */
public class KlijentThread extends Thread {
    
    Socket s;
    List<KlijentThread> klijenti;

    public KlijentThread(Socket s, List<KlijentThread> klijenti) {
        this.s = s;
        this.klijenti = klijenti;
    }

    @Override
    public void run() {
        ObjectInputStream in = null;
        try {
            //hvatanje objekta    
            in = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            // ovde treba da radim obradu zahtev sa servera :)
            while(true){
            KlijentTransfer kt = (KlijentTransfer) in.readObject();
            int operacija = kt.getOperacija();
            
            
                if(operacija == Konstante.VRATI_LISTU_MESTA){  
                    ServerTransfer st = new ServerTransfer();
            
                    try {
                        List<AbstractObjekat> mesta = kontroler.Kontroler.vratiListuMesta();
                        st.setUspesnostOperacije(1);
                        st.setPodaci(mesta);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    out.writeObject(st);
                }
                
                if(operacija == Konstante.PRIJAVI_KORISNIKA){
                    ServerTransfer st = new ServerTransfer();
                    
                    try{
                        Korisnik korisnik = (Korisnik) kt.getParametar();
                        //ServerTransfer st = new ServerTransfer();
                    
                        Korisnik kor = (Korisnik) kontroler.Kontroler.prijaviKorisnika(korisnik);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(kor);
                    } catch (Exception ex){
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    out.writeObject(st);
                    //AbstractObjekat korisnik = 
                    //AbstractObjekat korisnik = kontroler.Kontroler.prijaviKorisnika(korisnik);
                }
            }
            
         
        //super.run(); //To change body of generated methods, choose Tools | Templates.
        } catch (SocketException sex){    
            System.out.println("Jedan klijent manje");
        } catch (IOException ex) {
            Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
           
    
    
    }
}
