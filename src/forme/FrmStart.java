/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import start.SocketServer;

/**
 *
 * @author vujke
 */
public class FrmStart extends javax.swing.JFrame {

    SocketServer socketServer;

    /**
     * Creates new form GlavnaFrm
     */
    public FrmStart() {
        initComponents();
        jPanel1.setVisible(false);
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlblStatusServera = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbtUpravljanjeKorisnicima = new javax.swing.JButton();
        jbtPodesavanja = new javax.swing.JButton();
        jbtPokreniServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Prozor");

        jlblStatusServera.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblStatusServera.setForeground(new java.awt.Color(255, 51, 51));
        jlblStatusServera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblStatusServera.setText("Server nije pokrenut");
        jlblStatusServera.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlblStatusServera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin opcije"));

        jbtUpravljanjeKorisnicima.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtUpravljanjeKorisnicima.setText("Upravljanje korisnicima");
        jbtUpravljanjeKorisnicima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpravljanjeKorisnicimaActionPerformed(evt);
            }
        });

        jbtPodesavanja.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtPodesavanja.setText("Konfiguracija");
        jbtPodesavanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPodesavanjaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtUpravljanjeKorisnicima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jbtPodesavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtUpravljanjeKorisnicima, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtPodesavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jbtPokreniServer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtPokreniServer.setText("Pokreni Server");
        jbtPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPokreniServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jlblStatusServera, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jbtPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblStatusServera, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPokreniServerActionPerformed
        // TODO add your handling code here:\
        /*if (socketServer == null) {
            //socketServer = new SocketServer(9000);
            //socketServer.start();
            SocketServer.setRadi(true);
            jlblStatusServera.setForeground(Color.GREEN);
            jlblStatusServera.setText("Server je pokrenut");
            jbtPokreniServer.setText("Zaustavi server");
            jPanel1.setVisible(true);*/
        
            if (SocketServer.radi) {
                System.out.println("USAO GDE GASI SERVER");
                zaustaviServer();
                jlblStatusServera.setForeground(Color.RED);
                jlblStatusServera.setText("Server je zaustavljen");
                jbtPokreniServer.setText("Pokreni server");
            }else {
                try {
                    pokreniServer();
                    System.out.println("USAO GDE POKRECE SERVER");
                    jlblStatusServera.setForeground(Color.GREEN);
                    jlblStatusServera.setText("Server je pokrenut");
                    jbtPokreniServer.setText("Zaustavi server");
                    jPanel1.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FrmStart.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        

        //new SocketServer(9000).start();
        //jlblStatusServera.setForeground(Color.GREEN);
        //jlblStatusServera.setText("Server je pokrenut");
        //jbtPokreniServer.setEnabled(false);
        //jbtUpravljanjeKorisnicima.setVisible(true);
    }//GEN-LAST:event_jbtPokreniServerActionPerformed

    private void jbtUpravljanjeKorisnicimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpravljanjeKorisnicimaActionPerformed
        // TODO add your handling code here:
        FrmUpravljanjeKorisnicima frm = new FrmUpravljanjeKorisnicima();
        frm.setVisible(true);      
    }//GEN-LAST:event_jbtUpravljanjeKorisnicimaActionPerformed

    private void jbtPodesavanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPodesavanjaActionPerformed
        // TODO add your handling code here:
        FrmKonfiguracija konfig = new FrmKonfiguracija();
        konfig.setVisible(true);
    }//GEN-LAST:event_jbtPodesavanjaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmStart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtPodesavanja;
    private javax.swing.JButton jbtPokreniServer;
    private javax.swing.JButton jbtUpravljanjeKorisnicima;
    private javax.swing.JLabel jlblStatusServera;
    // End of variables declaration//GEN-END:variables

    private void zaustaviServer() {
        socketServer.interrupt();
        socketServer.zaustaviNiti();
        SocketServer.setRadi(false);
        System.out.println("Server je zaustavljen");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pokreniServer() throws IOException {
        //int rand = (int) (Math.random()*9000);
        socketServer = new SocketServer(9000);
        socketServer.start();
        System.out.println("Server je PONOVO pokrenut");
        SocketServer.setRadi(true);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
