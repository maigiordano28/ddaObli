/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuswing;

import Dominio.Carta;
import Dominio.EstadoMano;
import Dominio.Fachada;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasListener;
import panelCartasPoker.PanelCartasPokerException;
import ui.controller.PokerController;
import ui.view.PokerView;

/**
 *
 * @author PC
 */
public class Poker extends javax.swing.JDialog implements PanelCartasListener,PokerView {
private Jugador j;
private List<Jugador> jugadores;
private Mesa m;
private PokerController controller;
   
    public Poker(java.awt.Frame parent, boolean modal,List<Jugador> listJugadores,Jugador jugador,Mesa mesa) {
        super(parent, modal);
        initComponents();
        this.jugadores=listJugadores;
         this.j=jugador;
         this.m=mesa;
          
    
        controller= new PokerController(this);
         EmpezarJuego(); 
      
        
    }
    

    public Poker(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void EmpezarJuego() {
        AgregarMano();
        mostrarJugadoresEnMesa();



    }
    public void  DescontarLuz(){
      m.PagarLuz(j);
      
      
    
    }
    
    public void AgregarMano(){
        DescontarLuz();
        cargarInfo(); 
        //controller.agregarMano(m);

    } 
            
@Override
    public void cargarInfo(){
            
            txtPozo.setText("Pozo: "+Double.toString(m.getPozo()));
           txtNombreJugador.setText("Jugador: " + j.getNombreCompleto()); // Ajusta para mostrar en la interfaz
            txtSaldo.setText("Saldo: "+ Double.toString(j.getSaldoInicial()));
           txtNombreMesa.setText("Mesa: "+String.valueOf(m.getNumero())); // Ajusta para mostrar en la interfaz;
           
    
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        panelCartasPoker1 = new panelCartasPoker.PanelCartasPoker();
        habilitarPanel = new javax.swing.JCheckBox();
        checkListener = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFiguras = new javax.swing.JList<>();
        txtFigurActual = new javax.swing.JLabel();
        txtNombreMesa = new javax.swing.JLabel();
        txtNombreJugador = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JLabel();
        txtNumeroDeMano = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listJugadores = new javax.swing.JList<>();
        txtPozo = new javax.swing.JLabel();
        txtEstadoActualMano = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EJEMPLO PANEL DE CARTAS POKER");
        getContentPane().setLayout(null);
        getContentPane().add(panelCartasPoker1);
        panelCartasPoker1.setBounds(40, 290, 910, 257);

        habilitarPanel.setSelected(true);
        habilitarPanel.setText("Habilitar Panel");
        habilitarPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarPanelActionPerformed(evt);
            }
        });
        getContentPane().add(habilitarPanel);
        habilitarPanel.setBounds(420, 580, 150, 20);

        checkListener.setText("Escuchar clicks del panel");
        checkListener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkListenerActionPerformed(evt);
            }
        });
        getContentPane().add(checkListener);
        checkListener.setBounds(420, 620, 210, 20);

        jScrollPane1.setViewportView(listFiguras);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 50, 90, 130);
        getContentPane().add(txtFigurActual);
        txtFigurActual.setBounds(60, 210, 37, 16);
        getContentPane().add(txtNombreMesa);
        txtNombreMesa.setBounds(60, 10, 120, 20);
        getContentPane().add(txtNombreJugador);
        txtNombreJugador.setBounds(750, 10, 150, 20);
        getContentPane().add(txtSaldo);
        txtSaldo.setBounds(920, 10, 120, 20);
        getContentPane().add(txtNumeroDeMano);
        txtNumeroDeMano.setBounds(240, 10, 37, 16);

        jScrollPane2.setViewportView(listJugadores);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(180, 50, 300, 130);
        getContentPane().add(txtPozo);
        txtPozo.setBounds(440, 230, 110, 30);
        getContentPane().add(txtEstadoActualMano);
        txtEstadoActualMano.setBounds(440, 250, 0, 0);

        setBounds(0, 0, 1064, 705);
    }// </editor-fold>//GEN-END:initComponents

    private void habilitarPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarPanelActionPerformed
        // TODO add your handling code here:
        panelCartasPoker1.setEnabled(habilitarPanel.isSelected());
    }//GEN-LAST:event_habilitarPanelActionPerformed

    private void checkListenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkListenerActionPerformed
        // TODO add your handling code here:
        if(checkListener.isSelected()){
            panelCartasPoker1.setListener(this);
        }else panelCartasPoker1.setListener(null);
    }//GEN-LAST:event_checkListenerActionPerformed

    
    private List<String> cargarNombresJugadores(List<Jugador> nombresJugadores) {
        List<String> nombresJugadoresString = new ArrayList<>();
        for (Jugador j: nombresJugadores) {
            nombresJugadoresString.add(formatearNombreJugadores(j));
        }
        return nombresJugadoresString;
    }
    
    private String formatearNombreJugadores(Jugador jugador) {
        return jugador.getNombreCompleto();
                
    }
    
    
    
    @Override
    public void mostrarJugadoresEnMesa() {
        List<Jugador> nombresJugadores = m.getJugadores();
        List<String> nombreJugadoresFormateados = cargarNombresJugadores(nombresJugadores);
        String[] listaNombreJugadoresArray = new String[nombreJugadoresFormateados.size()];
        listJugadores.setListData(nombreJugadoresFormateados.toArray(listaNombreJugadoresArray));
        }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkListener;
    private javax.swing.JCheckBox habilitarPanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listFiguras;
    private javax.swing.JList<String> listJugadores;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker1;
    private javax.swing.JLabel txtEstadoActualMano;
    private javax.swing.JLabel txtFigurActual;
    private javax.swing.JLabel txtNombreJugador;
    private javax.swing.JLabel txtNombreMesa;
    private javax.swing.JLabel txtNumeroDeMano;
    private javax.swing.JLabel txtPozo;
    private javax.swing.JLabel txtSaldo;
    // End of variables declaration//GEN-END:variables

  // public void RecibirCartas(ArrayList<Carta> cartas){
       
          
   //     controller.repartirCartas(m, cartas);
    
     
   //}
      
   

    

    @Override
    public void mostrarMensaje(String msg) {
         JOptionPane.showMessageDialog(this, msg);  }

    @Override
    public void cargarSiguientePantalla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    @Override
    public void clickEnCarta(CartaPoker carta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cargarCartas(ArrayList<CartaPoker> cartas) {
        try {
            panelCartasPoker1.cargarCartas(cartas);
        } catch (PanelCartasPokerException ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }



}
