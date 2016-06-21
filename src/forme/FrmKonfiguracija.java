/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Aco Kandic
 */
public class FrmKonfiguracija extends javax.swing.JFrame {

    /**
     * Creates new form FrmPodesavanja
     */
    public FrmKonfiguracija() {
        initComponents();
        centrirajFormu();
        cbSUBP.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbSUBP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSema = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKorIme = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSifra = new javax.swing.JPasswordField();
        btnPonisti = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Podesavanja parametara baze");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("SUBP:");

        cbSUBP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MySQL", "Oracle", "MicrosoftSQLServer" }));
        cbSUBP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSUBPActionPerformed(evt);
            }
        });

        jLabel2.setText("IP:");

        jLabel6.setText("Port:");

        jLabel3.setText("DB naziv:");

        jLabel4.setText("Korisnicko ime:");

        jLabel5.setText("Šifra:");

        btnPonisti.setText("Poništi");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnTest.setText("Test");
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSUBP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(67, 67, 67))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKorIme, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSifra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPonisti, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSUBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTest)
                            .addComponent(btnSacuvaj))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPonisti)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSUBPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSUBPActionPerformed
        ucitajProperty();
    }//GEN-LAST:event_cbSUBPActionPerformed

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        cbSUBP.setSelectedIndex(0);
        txtIP.setText("");
        txtPort.setText("");
        txtSema.setText("");
        txtKorIme.setText("");
        txtSifra.setText("");
    }//GEN-LAST:event_btnPonistiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        sacuvaj();
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed

        try {
            String korisnickoIme = txtKorIme.getText().trim();
            String sifra = new String(txtSifra.getPassword());
            String url = url() + txtIP.getText().trim() + ":" + txtPort.getText().trim() + "/" + txtSema.getText().trim();
            Class.forName(driver());
            Connection connection = DriverManager.getConnection(url, korisnickoIme, sifra);
            String poruka = "Test konekcije je uspesan. Zalis li da sacuvas podatke?";
            Object[] opcije = {"Da", "Ne"};
            int izbor = JOptionPane.showOptionDialog(this, poruka, "test", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, opcije[0]);
            if (izbor == 0) {
                sacuvaj();
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Drajver nije ucitan!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Konekcija nije uspostavljena! Proverite parametre koje ste uneli!");
        }
    }//GEN-LAST:event_btnTestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmKonfiguracija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKonfiguracija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKonfiguracija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKonfiguracija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmKonfiguracija().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnTest;
    private javax.swing.JComboBox<String> cbSUBP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtKorIme;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtSema;
    private javax.swing.JPasswordField txtSifra;
    // End of variables declaration//GEN-END:variables

    private void sacuvaj() {

        String korisnickoIme = txtKorIme.getText().trim();
        String sifra = new String(txtSifra.getPassword());
        String ip = txtIP.getText().trim();
        String port = txtPort.getText().trim();
        String sema = txtSema.getText().trim();

        try {
            Properties props = new Properties();
            props.load(new FileInputStream(System.getProperty("user.home") + "\\props.properties"));
            String prefix = cbSUBP.getSelectedItem().toString();

            props.setProperty("prefix", prefix);
            props.setProperty(prefix + "_drajver", driver());
            props.setProperty(prefix + "_link", url());
            props.setProperty(prefix + "_korisnickoIme", korisnickoIme);
            props.setProperty(prefix + "_sifra", sifra);
            props.setProperty(prefix + "_ip", ip);
            props.setProperty(prefix + "_port", port);
            props.setProperty(prefix + "_sema", sema);
            props.setProperty(prefix + "_url", url() + ip + ":" + port + "/" + sema);
            String home = System.getProperty("user.home") + "\\props.properties";
            File f = new File(home);
            OutputStream out = new FileOutputStream(f);
            props.store(out, "Property fajl za cuvanje parametara za konekciju sa bazom!");
            JOptionPane.showMessageDialog(this, "Parametri su uspesno sacuvani!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Parametri nisu uspesno sacuvani!");
            e.printStackTrace();
        }
    }

    private void ucitajProperty() {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            String props = System.getProperty("user.home") + "\\props.properties";

            input = new FileInputStream(props);
            // load a properties file
            prop.load(input);

            // get the property value and print it out
            String prefix = cbSUBP.getSelectedItem().toString();
            String port = prop.getProperty(prefix + "_port");
            String ip = prop.getProperty(prefix + "_ip");
            String sifra = prop.getProperty(prefix + "_sifra");
            String korisnickoIme = prop.getProperty(prefix + "_korisnickoIme");
            String sema = prop.getProperty(prefix + "_sema");

            txtIP.setText(ip);
            txtPort.setText(port);
            txtSifra.setText(sifra);
            txtSema.setText(sema);
            txtKorIme.setText(korisnickoIme);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void centrirajFormu() {
        setLocationRelativeTo(null);
    }

    private String driver() {
        switch (cbSUBP.getSelectedIndex()) {
            case 0:
                return "com.mysql.jdbc.Driver";
            case 1:
                return "oracle.jdbc.OracleDriver";
            case 2:
                return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            default:
                return "N/A";
        }
    }

    private String url() {
        switch (cbSUBP.getSelectedIndex()) {
            case 0:
                return "jdbc:mysql://";
            case 1:
                return "jdbc:oracle:thin:@//";
            case 2:
                return "...";
            default:
                return "N/A";
        }
    }

}