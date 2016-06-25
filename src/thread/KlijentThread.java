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
            while (true) {
                KlijentTransfer kt = (KlijentTransfer) in.readObject();
                int operacija = kt.getOperacija();
                ServerTransfer st = new ServerTransfer();

                if (operacija == Konstante.VRATI_LISTU_MESTA) {
//                    ServerTransfer st = new ServerTransfer();

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

                if (operacija == Konstante.VRATI_LISTU_PAKETA) {
//                    ServerTransfer st = new ServerTransfer();

                    try {
                        List<AbstractObjekat> paketi = kontroler.Kontroler.vratiListuPaketa();
                        st.setUspesnostOperacije(1);
                        st.setPodaci(paketi);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    out.writeObject(st);
                }

                if (operacija == Konstante.VRATI_LISTU_CLANOVA) {
//                    ServerTransfer st = new ServerTransfer();

                    try {
                        List<AbstractObjekat> clanovi = kontroler.Kontroler.vratiListuClanova();
                        st.setUspesnostOperacije(1);
                        st.setPodaci(clanovi);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    out.writeObject(st);
                }

                if (operacija == Konstante.VRATI_LISTU_IP) {
//                    ServerTransfer st = new ServerTransfer();

                    try {
                        List<AbstractObjekat> listaIp = kontroler.Kontroler.vratiListuIP();
                        st.setUspesnostOperacije(1);
                        st.setPodaci(listaIp);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    out.writeObject(st);
                }

                if (operacija == Konstante.VRATI_LISTU_PRETPLATA) {
//                    ServerTransfer st = new ServerTransfer();

                    try {
                        List<AbstractObjekat> pretplate = kontroler.Kontroler.vratiListuPretplata();
                        st.setUspesnostOperacije(1);
                        st.setPodaci(pretplate);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    out.writeObject(st);
                }

                if (operacija == Konstante.PRETRAZI_CLANOVE) {
//                    ServerTransfer st = new ServerTransfer();

                    try {

                        List<AbstractObjekat> clanovi = kontroler.Kontroler.pretraziClanove((String) kt.getParametar());
                        st.setUspesnostOperacije(1);
                        System.out.println("DUZINNA THREAD" + clanovi.size());
                        st.setPodaci(clanovi);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    out.writeObject(st);
                }

                if (operacija == Konstante.ZAPAMTI_CLANA) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        List<Object> parametri = (List<Object>) kt.getParametar();
                        AbstractObjekat kor = kontroler.Kontroler.zapamtiClana(parametri);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(kor);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor ZAPAMTI_CLANA");
                    out.writeObject(st);
                }

//                if(operacija == Konstante.ZAPAMTI_CLANA){  
//                    //ServerTransfer st = new ServerTransfer();
//            
//                    try {
//                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
//                        List<Object> parametri =  (List<Object>) kt.getParametar();
//                        AbstractObjekat kor = kontroler.Kontroler.zapamtiClana(parametri);
//                        st.setUspesnostOperacije(1);
//                        st.setPodaci(kor);
//                    } catch (Exception ex) {
//                        st.setUspesnostOperacije(-1);
//                        st.setException(ex);
//                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    System.out.println("salje se odgovor ZAPAMTI_CLANA");
//                    out.writeObject(st);
//                }
                if (operacija == Konstante.ZAPAMTI_PRETPLATU) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        AbstractObjekat pret = (AbstractObjekat) kt.getParametar();
                        AbstractObjekat pr = kontroler.Kontroler.zapamtiPretplatu(pret);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(pr);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor");
                    out.writeObject(st);
                }

                if (operacija == Konstante.VRATI_LISTU_KORISNIKA) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        List<AbstractObjekat> korisnici = kontroler.Kontroler.vratiListuKorisnika();
                        st.setUspesnostOperacije(1);
                        st.setPodaci(korisnici);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor");
                    out.writeObject(st);
                }

                if (operacija == Konstante.ZAPAMTI_KORISNIKA) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        Korisnik korisnik = (Korisnik) kt.getParametar();
                        AbstractObjekat kor = kontroler.Kontroler.zapamtiKorisnika(korisnik);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(kor);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor");
                    out.writeObject(st);
                }

                if (operacija == Konstante.OBRISI_KORISNIKA) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        AbstractObjekat korisnik = (AbstractObjekat) kt.getParametar();
                        AbstractObjekat kor = kontroler.Kontroler.obrisiKorisnika(korisnik);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(kor);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor");
                    out.writeObject(st);
                }

                if (operacija == Konstante.VRATI_CLANA_PK) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        String id = (String) kt.getParametar();
                        AbstractObjekat clan = kontroler.Kontroler.vratiClanaPoPK(id);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(clan);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor");
                    out.writeObject(st);
                }

                if (operacija == Konstante.ZAPAMTI_IP) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        AbstractObjekat ip = (AbstractObjekat) kt.getParametar();
                        AbstractObjekat isp = kontroler.Kontroler.zapamtiIP(ip);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(isp);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor ZAPAMTI_IP KlijentThread");
                    out.writeObject(st);
                }

                if (operacija == Konstante.VRATI_LISTU_DOLAZAKA) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        List<AbstractObjekat> dolasci = kontroler.Kontroler.vratiListuDolazaka();
                        st.setUspesnostOperacije(1);
                        st.setPodaci(dolasci);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor");
                    out.writeObject(st);
                }

                if (operacija == Konstante.ZAPAMTI_DOLAZAK) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        AbstractObjekat dolazak = (AbstractObjekat) kt.getParametar();
                        AbstractObjekat dol = kontroler.Kontroler.zapamtiDolazak(dolazak);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(dol);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor ZAPAMTI_DOLAZAK");
                    out.writeObject(st);
                }

//                if(operacija == Konstante.VRATI_LISTU_PRETPLATA){  
//                    //ServerTransfer st = new ServerTransfer();
//            
//                    try {
//                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
//                        List<AbstractObjekat> pretplate = kontroler.Kontroler.vratiListuPretplata();
//                        st.setUspesnostOperacije(1);
//                        st.setPodaci(pretplate);
//                    } catch (Exception ex) {
//                        st.setUspesnostOperacije(-1);
//                        st.setException(ex);
//                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    System.out.println("salje se odgovor");
//                    out.writeObject(st);
//                }
//                if(operacija == Konstante.ZAPAMTI_CLANA){  
//                    //ServerTransfer st = new ServerTransfer();
//            
//                    try {
//                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
//                        List<Object> parametri =  (List<Object>) kt.getParametar();
//                        AbstractObjekat kor = kontroler.Kontroler.zapamtiClana(parametri);
//                        st.setUspesnostOperacije(1);
//                        st.setPodaci(kor);
//                    } catch (Exception ex) {
//                        st.setUspesnostOperacije(-1);
//                        st.setException(ex);
//                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    System.out.println("salje se odgovor ZAPAMTI_CLANA");
//                    out.writeObject(st);
//                }
                if (operacija == Konstante.PRETRAZI_PRETPLATE) {
                    //ServerTransfer st = new ServerTransfer();

                    try {
                        //System.out.println("VRATI_LISTU_KORISNIKA u CT");
                        List<AbstractObjekat> parametri = (List<AbstractObjekat>) kt.getParametar();
                        List<AbstractObjekat> pretplate = kontroler.Kontroler.pretraziPretplate(parametri);
                        st.setUspesnostOperacije(1);
                        st.setPodaci(pretplate);
                    } catch (Exception ex) {
                        st.setUspesnostOperacije(-1);
                        st.setException(ex);
                        Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("salje se odgovor PRETRAZI_PRETPLATE");
                    out.writeObject(st);
                }
            }

            //super.run(); //To change body of generated methods, choose Tools | Templates.
        } catch (SocketException sex) {
            System.out.println("Jedan klijent manje");
        } catch (IOException ex) {
            Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlijentThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Socket getSoket() {
        return s;
    }
    ///throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
