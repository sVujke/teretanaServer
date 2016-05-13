/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author vujke
 */
public class DBBroker {
    private Connection konekcija;
    private static DBBroker instance;

    public DBBroker() {
    }
    
    public static DBBroker vratiInstancu(){
        if(instance==null){
            instance = new DBBroker();
        }
        
        return instance;
    }
    
    public void konektujSe(){
    
    }
    
    public void diskonektujSe(){
    
    }
    
    public void potvrdiTransakciju() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            System.out.println("Neuspesan commit.");
        }
    }
    
    public void ponistiTransakciju() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            System.out.println("Neuspesan rollback.");
        }
    }
}
