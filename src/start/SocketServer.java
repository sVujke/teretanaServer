/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.ClientThread;
import thread.KlijentThread;

/**
 *
 * @author vujke
 */
public class SocketServer extends Thread {
    
    ServerSocket ss;
    private int port;
    public static List<KlijentThread> klijenti = new ArrayList<>();

    public SocketServer(int port) {
        this.port = port;
        
        try {
            ss = new ServerSocket(port);
            System.out.println("Kreiran je server socket");
        } catch (IOException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                Socket s = ss.accept();
                
                KlijentThread k = new KlijentThread(s, klijenti);
                
                int i = klijenti.size()+1;
                k.start();
                klijenti.add(k);
                System.out.println("Klijent broj "+i+" se povezao");
            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //super.run(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
