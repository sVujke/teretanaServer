/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.net.Socket;
import java.util.List;

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
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
