/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KlijentThread;

/**
 *
 * @author vujke
 */
public class SocketServer extends Thread {
    
    ServerSocket ss;
    private int port;
    public static List<KlijentThread> klijenti = new ArrayList<>();
    public static boolean radi = false;

    public SocketServer(int port) {
        this.port = port;
        
        try {
            ss = new ServerSocket(port);
            System.out.println("Kreiran je server socket");
        } catch (IOException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isRadi() {
        return radi;
    }

    public static void setRadi(boolean radi) {
        SocketServer.radi = radi;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            try {
                System.out.println("Usao u thread SocketServer");
                Socket s = ss.accept();
                System.out.println("prihvacen");
                
                KlijentThread k = new KlijentThread(s, klijenti);
                
                int i = klijenti.size()+1;
                k.start();
                klijenti.add(k);
                System.out.println("Klijent broj "+i+" se povezao");
            } catch (SocketException sex){
                System.out.println("Uhvacen soket eks");
            
            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //super.run(); //To change body of generated methods, choose Tools | Templates.
    }

    public void zaustaviNiti() {
        try {
            ss.close();
            
           // for (KlijentThread nitKlijent : klijenti) {
            //    nitKlijent.getSoket().close();
//                
           // }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
