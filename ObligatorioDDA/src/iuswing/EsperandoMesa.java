/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuswing;

import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import ui.controller.EsperandoMesaController;
import ui.controller.MesaAdminController;
import ui.view.EsperaMesaView;

/**
 *
 * @author HOLA
 */
public class EsperandoMesa extends javax.swing.JDialog implements EsperaMesaView {
    private Mesa mesa;
    private Jugador jugador;

    private java.awt.Frame padre;
    private EsperandoMesaController controller;
    /**
     * Creates new form Jugar
     */
    public EsperandoMesa(java.awt.Frame parent, boolean modal,Mesa mesaSeleccionada,Jugador jugador) {
        super(parent, modal);
        initComponents();
        this.mesa=mesaSeleccionada;
        this.jugador=jugador;

         controller= new EsperandoMesaController(this, mesa);
        CambiarInterfaz();
    }
    
    
    public void CambiarInterfaz(){
     if(mesa.getJugadores().size()+1==mesa.getCantidadJugadores()){
        Pocker a= new Pocker(padre,false,jugador);
        a.setVisible(true);
        controller.actualizarMesa(mesa);
        this.dispose();
        
     }else{
         lblJugadores.setText("Esperando inicio del juego, hay "+mesa.getJugadores().size()+"jugadores de "+mesa.getCantidadJugadores()+" en la mesa");
     
     }
    
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJugadores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(lblJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblJugadores;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarMensaje(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
