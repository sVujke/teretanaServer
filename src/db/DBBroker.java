/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.AbstractObjekat;
import domen.Mesto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class DBBroker {
    private Connection konekcija;
    private static DBBroker instance;

    public DBBroker() {
    }
    
    
    
    public void konektujSe(){
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = util.Konstante.url;
            String user = util.Konstante.user;
            String password = util.Konstante.pass;
            
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);
            System.out.println("Konekcija uspesna");
     
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException ex){
            System.out.println("Nije uspostavljena konekcija");
        }
    }
    
    public void diskonektujSe(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public List<AbstractObjekat> vratiSveObjekte(AbstractObjekat o) {
        
        List<AbstractObjekat> listaObjekata = new ArrayList<>();
        
        try {
            
            
            String upit = "SELECT * FROM"+ o.vratiImeTabele();
            
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            listaObjekata = o.izRsUTabelu(rs);
            s.close();
            System.out.println("Uspesan SELECT");
            
          
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            System.out.println("greska kod SELECT");
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaObjekata;
    }
    
    
}
