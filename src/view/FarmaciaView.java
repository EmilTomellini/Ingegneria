/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.Farmacia.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emil
 */
public class FarmaciaView extends javax.swing.JFrame {

    private final model.Farmacia fm;
   // private final String username;
    
    /**
     * Creates new form Farmacia
     */
    public FarmaciaView(model.Farmacia fm) {
        
        this.fm = fm;
        initComponents();
        //jLabelError.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esci = new javax.swing.JButton();
        NomeFarmaco = new javax.swing.JLabel();
        jLabelQuantita = new javax.swing.JLabel();
        jLabelFarmacia = new javax.swing.JLabel();
        jTextFieldNomeFarmaco = new javax.swing.JTextField();
        jTextFieldQuantita = new javax.swing.JTextField();
        jButtonOrdina = new javax.swing.JButton();
        jCheckBoxGenerico = new javax.swing.JCheckBox();
        jLabelQuantitaMax = new javax.swing.JLabel();
        jLabelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Esci.setText("ESCI");
        Esci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EsciMouseClicked(evt);
            }
        });

        NomeFarmaco.setText("Nome Farmaco");

        jLabelQuantita.setText("Quantità");

        jLabelFarmacia.setText("Farmacia: "+ fm.getNome());

        jButtonOrdina.setText("Ordina");
        jButtonOrdina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOrdinaMouseClicked(evt);
            }
        });
        jButtonOrdina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdinaActionPerformed(evt);
            }
        });

        jCheckBoxGenerico.setText("Generico");
        jCheckBoxGenerico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGenericoActionPerformed(evt);
            }
        });

        jLabelQuantitaMax.setText("Max Quantità 100");

        jLabelError.setText("\t \t \t \t");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jButtonOrdina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Esci)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NomeFarmaco)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxGenerico)
                            .addComponent(jLabelQuantita))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNomeFarmaco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldQuantita, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelQuantitaMax)))
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabelFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeFarmaco)
                    .addComponent(jTextFieldNomeFarmaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantita)
                    .addComponent(jTextFieldQuantita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuantitaMax))
                .addGap(18, 18, 18)
                .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jCheckBoxGenerico)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Esci)
                    .addComponent(jButtonOrdina))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOrdinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOrdinaActionPerformed

    private void jCheckBoxGenericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGenericoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxGenericoActionPerformed

    private void EsciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EsciMouseClicked
        Login.occupied=false;
        dispose();
    }//GEN-LAST:event_EsciMouseClicked

    private void jButtonOrdinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrdinaMouseClicked
        String farmaco=jTextFieldNomeFarmaco.getText();
        String quantitaString=jTextFieldQuantita.getText();
        int quantitaInt=0;
        try {
            quantitaInt = Integer.parseInt(quantitaString);
        }
        catch(NumberFormatException e){
            //bloccare qui senzA ANDARE AVANTI
            jLabelError.setText("Quantità del farmaco non è numerica");
            jLabelError.setVisible(true);
            System.out.print("quantita non è un numero");
            
        }
        
        if(!control.FarmaciaControl.checkQuantita(quantitaInt)) {
            System.out.print("quantità negativa");
            jLabelError.setText("Quantità del farmaco errata");
            jLabelError.setVisible(true);
            }
        else {
            if(control.FarmaciaControl.checkEsistenza(farmaco)) {
                   if(jCheckBoxGenerico.isSelected()) {
                       control.FarmaciaControl.updateFaramcoGenerico(farmaco, fm.getPsw(), quantitaInt);
                   } 
                   else
                       control.FarmaciaControl.updateFaramcoMarca(farmaco, fm.getPsw(), quantitaInt);
                }
            else {
                if(jCheckBoxGenerico.isSelected()) {
                    control.FarmaciaControl.inserimentoNuovoFaramcoGenerico(farmaco, fm, quantitaInt);
                }
                else 
                    control.FarmaciaControl.inserimentoNuovoFaramcoMarca(farmaco, fm, quantitaInt);
            }
            
            
    }

    }//GEN-LAST:event_jButtonOrdinaMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Esci;
    private javax.swing.JLabel NomeFarmaco;
    private javax.swing.JButton jButtonOrdina;
    private javax.swing.JCheckBox jCheckBoxGenerico;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelFarmacia;
    private javax.swing.JLabel jLabelQuantita;
    private javax.swing.JLabel jLabelQuantitaMax;
    private javax.swing.JTextField jTextFieldNomeFarmaco;
    private javax.swing.JTextField jTextFieldQuantita;
    // End of variables declaration//GEN-END:variables
}
