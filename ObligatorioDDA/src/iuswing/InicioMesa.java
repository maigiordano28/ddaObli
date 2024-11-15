/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuswing;

import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import java.awt.Frame;
import ui.controller.InicioMesaController;
import ui.view.InicioMesaView;

/**
 *
 * @author HOLA
 */
public class InicioMesa extends javax.swing.JDialog implements InicioMesaView {
    Frame padre;
    private InicioMesaController controller;
    public InicioMesa(java.awt.Frame parent, boolean modal, Mesa mesaSeleccionada,Jugador jugador) {
        super(parent, modal);
        initComponents();
        this.controller=new InicioMesaController(this,mesaSeleccionada,jugador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        btnEntrarAMesa = new javax.swing.JButton();
        btnSalirMesa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEntrarAMesa.setText("Si");
        btnEntrarAMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarAMesaActionPerformed(evt);
            }
        });

        btnSalirMesa.setText("No");
        btnSalirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMesaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Desea Ingresar a esta mesa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEntrarAMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnSalirMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalirMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrarAMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarAMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarAMesaActionPerformed
         controller.EntrarAMesa();
         this.dispose();
    }//GEN-LAST:event_btnEntrarAMesaActionPerformed

    private void btnSalirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMesaActionPerformed
      this.setVisible(false);
    }//GEN-LAST:event_btnSalirMesaActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrarAMesa;
    private javax.swing.JButton btnSalirMesa;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarSiguientePantalla(Mesa mesa,Jugador jugador) {
        EsperandoMesa j= new EsperandoMesa(padre,false,mesa,jugador);
         j.setVisible(true);
    }
}
