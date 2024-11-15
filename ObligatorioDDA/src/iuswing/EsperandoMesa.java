/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuswing;

import Dominio.EventoFachada;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import java.util.List;
import ui.controller.EsperandoMesaController;
import ui.controller.MesaAdminController;
import ui.view.EsperaMesaView;

/**
 *
 * @author HOLA
 */
public class EsperandoMesa extends javax.swing.JDialog implements EsperaMesaView {
    private java.awt.Frame padre;
    private EsperandoMesaController controller;

    public EsperandoMesa(java.awt.Frame parent, boolean modal,Mesa mesaSeleccionada,Jugador jugador) {
        super(parent, modal);
        initComponents();
        controller= new EsperandoMesaController(this, mesaSeleccionada,jugador);
           CambiarInterfaz(mesaSeleccionada);
        
     
    }
    
    @Override
    public void CambiarInterfaz(Mesa mesaSeleccionada){
        controller.validarEntradaMesa();
         
        //controller.actualizarMesa(mesaSeleccionada);
       
        lblJugadores.setText("Esperando inicio del juego, hay "+mesaSeleccionada.obtenerLargoListaJugadores()+" jugadores de "+mesaSeleccionada.getCantidadJugadores()+" en la mesa");
     
  
    
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

    @Override
    public void cargarSiguientePantalla(Jugador j, Mesa mesa) {
        this.setVisible(false);
      this.dispose();
          Poker a= new Poker(padre,false,j,mesa);
          a.setVisible(true);
         
         
    //a.RecibirCartas(mesa.obtenerArrayMazo());
    }


   
}
