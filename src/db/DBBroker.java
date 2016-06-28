/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.AbstractObjekat;
import domen.Mesto;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class DBBroker {

    private Connection konekcija;
    private static DBBroker instance;
    Properties props;
    InputStream input;

    public DBBroker() {
        props = new Properties();
        input = null;
        try {
            System.out.println(System.getProperty("user.home"));
            String prop = System.getProperty("user.home") + "\\props.properties";

            input = new FileInputStream(prop);
            props.load(input);
            System.out.println(props);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void konektujSe() {

        try {

            String prefix = props.getProperty("prefix");
//            System.out.println("Prefiks: " + prefix);
//            System.out.println(props.getProperty(prefix + "_drajver"));
//            System.out.println(props.getProperty(prefix + "_url"));
            Class.forName(props.getProperty(prefix + "_drajver"));
            System.out.println("Driver je ucitan");
            String url = props.getProperty(prefix + "_url");
            String user = props.getProperty(prefix + "_korisnickoIme");
            String sifra = props.getProperty(prefix + "_sifra");
            konekcija = DriverManager.getConnection(url, user, sifra);
            konekcija.setAutoCommit(false);
            System.out.println("Konekcija je uspostavljena");

            /* Class.forName("com.mysql.jdbc.Driver");
            pred refactor
            String url = util.Konstante.url;
            String user = util.Konstante.user;
            String password = util.Konstante.pass; 
            
            konekcija = DriverManager.getConnection(url, user, password);*/
            konekcija.setAutoCommit(false);
            System.out.println("Konekcija uspesna");

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Nije uspostavljena konekcija");
        }
    }

    public void diskonektujSe() {
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

    public AbstractObjekat sacuvajObjekat(AbstractObjekat o) {
        try {

            String tipUpita = "INSERT";
            String upit = String.format("INSERT INTO %s VALUES (%s)", o.vratiImeTabele(), o.vratiParametre());

            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() as last_id from " + o.vratiImeTabele());
            while (rs.next()) {
                String lastid = rs.getString("last_id");
                System.out.println(lastid);
                o.postaviVrednostPK(lastid);
                break;
            }

            s.close();
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            //throw new ServerskiException(ex.getMessage());
        }

        return null;
    }

    public List<AbstractObjekat> vratiSveObjekte(AbstractObjekat o) {

        List<AbstractObjekat> listaObjekata = new ArrayList<>();

        try {

            String upit = "SELECT * FROM " + o.vratiImeTabele();

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

//    public AbstractObjekat sacuvajObjekat(AbstractObjekat o) throws SQLException{
//        String upit = "";
//        System.out.println(o.vratiParametre());
//        upit = "INSERT INTO "+ o.vratiImeTabele() + " VALUES ("+
//                o.vratiParametre() + ")";
//        Statement s = konekcija.createStatement();
//        s.executeUpdate(upit);
//        s.close();
//        System.out.println("Uspesan INSERT");
//        return o;
//    }
    public AbstractObjekat vratiObjekatPoKljucu(AbstractObjekat o, int id) throws SQLException {
        String upit = "";

        if (o.vratiPK() != null) {
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

    public AbstractObjekat obrisiObjekat(AbstractObjekat o) throws SQLException, SQLException, SQLException {

        String upit = "";

        if (o.vratiPK() != null) {
            upit = "DELETE FROM " + o.vratiImeTabele() + " WHERE " + o.vratiPK()
                    + "=" + o.vratiVrednostiPK();
        } else {
            upit = "DELETE FROM " + o.vratiImeTabele() + o.vratiSlozeniPK();
        }
        Statement s = konekcija.createStatement();
        System.out.println("4. UPIT: " + upit + "#");
        s.executeUpdate(upit);
        potvrdiTransakciju();
        s.close();
        return o;
    }

    public AbstractObjekat azurirajObjekat(AbstractObjekat o) {
        try {
            String upit;
            if (o.vratiPK() != null) {
                upit = String.format("UPDATE %s SET %s WHERE %s = %s", o.vratiImeTabele(), o.vratiUpdateUpit(), o.vratiPK(), o.vratiVrednostiPK());
            } else {
                upit = String.format("UPDATE %s SET %s WHERE %s", o.vratiImeTabele(), o.vratiUpdateUpit(), o.vratiSlozeniPK());
            }
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public AbstractObjekat sacuvajIliAzurirajObjekat(AbstractObjekat o) {
        try {
            List<AbstractObjekat> lista = vratiSveObjekte(o);
            String upit;
            String tipUpita;
            if (lista.contains(o)) {
                tipUpita = "UPDATE";
                if (o.vratiPK() != null) {
                    upit = String.format("UPDATE %s SET %s WHERE %s = %s", o.vratiImeTabele(), o.vratiUpdateUpit(), o.vratiPK(), o.vratiVrednostiPK());
                } else {
                    upit = String.format("UPDATE %s SET %s WHERE %s", o.vratiImeTabele(), o.vratiUpdateUpit(), o.vratiSlozeniPK());
                }
            } else {
                tipUpita = "INSERT";
                upit = String.format("INSERT INTO %s VALUES (%s)", o.vratiImeTabele(), o.vratiParametre());
            }
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            if (tipUpita.equals("INSERT")) {
                ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() as last_id from " + o.vratiImeTabele());
                while (rs.next()) {
                    String lastid = rs.getString("last_id");
                    System.out.println(lastid);
                    o.postaviVrednostPK(lastid);
                    break;
                }

            }
            s.close();
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            //throw new ServerskiException(ex.getMessage());
        }
        return null;
    }

}
