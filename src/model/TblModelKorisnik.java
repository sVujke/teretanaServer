/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Korisnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vujke
 */
public class TblModelKorisnik extends AbstractTableModel{
    List<Korisnik> korisnici;
    String[] kolone = new String[]{"email","ime","username","status"};

    public TblModelKorisnik(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
    
    
    @Override
    public int getRowCount() {
        return korisnici.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik kor = korisnici.get(rowIndex);
        switch(columnIndex){
            case 0: return kor.getEmail();
            case 1: return kor.getIme();
            case 2: return kor.getUsername();
            case 3: return kor.getStatusKorisnika();
            default: return "n/a";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];//return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void dodajUTabelu(Korisnik k){
        korisnici.add(k);
        fireTableDataChanged();
    }
    
    public List<Korisnik> vratiListu(){
        return korisnici;
    }

    public void izbaciIzListe(Korisnik k) {
        korisnici.remove(k);
        fireTableDataChanged();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void resetujTabelu(List<AbstractObjekat> listaKorisnika) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
