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
            
            
            String upit = "SELECT * FROM "+ o.vratiImeTabele();
            
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
    
    public AbstractObjekat sacuvajObjekat(AbstractObjekat o) throws SQLException{
        String upit = "";
        
        upit = "INSERT INTO "+ o.vratiImeTabele() + " VALUES ("+
                o.vratiParametre() + ")";
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
        s.close();
        return o;
    }
    
    public AbstractObjekat vratiObjekatPoKljucu(AbstractObjekat o, int id) throws SQLException{
        String upit = "";
        
        if(o.vratiPK() != null){
            upit = "SELECT * FROM " + o.vratiImeTabele() + " WHERE " + o.vratiPK() + "=" + id;
        } else {
            upit = "SELECT * FROM " + o.vratiImeTabele() + o.vratiSlozeniPK();
        }
        
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        List<AbstractObjekat> lista = new ArrayList<>();
        lista = o.izRsUTabelu(rs);
        s.close();
        return lista.get(0);
    }
    
    public AbstractObjekat obrisiObjekat(AbstractObjekat o) throws SQLException{
    
    String upit = "";
    
    if(o.vratiPK() != null){
        upit = "DELETE FROM "+o.vratiImeTabele()+" WHERE "+o.vratiPK()+
                "="+ o.vratiVrednostiPK();
    }else {
        upit = "DELETE FROM "+o.vratiImeTabele()+ o.vratiSlozeniPK();
    }
        Statement s = konekcija.createStatement();
        System.out.println("4. UPIT: "+upit+"#");
        s.executeUpdate(upit);
        potvrdiTransakciju();
        s.close();
        return o;
    }
    
    public AbstractObjekat sacuvajIliAzurirajObjekat(AbstractObjekat o) throws SQLException {
        List<AbstractObjekat> lista = vratiSveObjekte(o);

        String upit = "";
        if (!lista.contains(o)) {
            upit = "INSERT INTO " + o.vratiImeTabele() + " VALUES (" + o.vratiParametre() + ")";
            System.out.println("1.UPIT: "+upit);
        } else {
            if (o.getStatus() == -1) {
                upit = "DELETE FROM " + o.vratiImeTabele() + o.vratiSlozeniPK();
                System.out.println("UPIT: " + upit);

            } else {
                if (o.vratiPK() != null) {

                    upit = "UPDATE " + o.vratiImeTabele() + " SET " + o.vratiUpdateUpit() + " WHERE " + o.vratiPK() + "=" + o.vratiVrednostiPK();
                    System.out.println("2.UPIT: "+upit);
                } else {

                    upit = "UPDATE " + o.vratiImeTabele() + " SET " + o.vratiUpdateUpit() + o.vratiSlozeniPK();
                    System.out.println("3.UPIT: "+upit);
                }
            }

        }

        Statement s = (Statement) konekcija.createStatement();
        int i = s.executeUpdate(upit);
        s.close();
        return o;
    }
}
