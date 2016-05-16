/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import java.util.List;
import so.SOVratiListuMesta;

/**
 *
 * @author vujke
 */
public class Kontroler {
    
    private static Kontroler instance;
    
    public static Kontroler vratiKontrolera(){
        if(instance == null){
            instance = new Kontroler();
        }
        return instance;
    }
    
    public static List<AbstractObjekat> vratiListuMesta() throws Exception {
        SOVratiListuMesta som = new SOVratiListuMesta();

        som.izvrsiOperaciju();
        return som.getListaMesta();
     //   return 
    }
}
