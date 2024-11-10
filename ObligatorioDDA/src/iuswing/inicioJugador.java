/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuswing;

import Dominio.Exceptions.UsuarioException;
import Dominio.Fachada;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import Dominio.Usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ui.controller.InicioJugadorController;
import ui.view.InicioJugadorView;
/**
 *
 * @author HOLA
 */
public class inicioJugador extends javax.swing.JDialog implements InicioJugadorView {

    Fachada fachada= Fachada.getInstancia();
    private Jugador jugador;
    private Double saldo;

    private String nombre;
    private InicioJugadorController controller;

    private java.awt.Frame padre;
    public inicioJugador(java.awt.Frame parent, boolean modal,Jugador jugador ) {
        
        super(parent, modal);
        initComponents();
        this.jugador=jugador;
        this.saldo = jugador.getSaldoInicial();
        
        this.nombre=jugador.getNombreCompleto();
        controller=new InicioJugadorController(this,jugador);
       cargarNombre();
    cargarSaldo();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datosPrueba1 = new Inicio.DatosPrueba();
        labelSaldo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMesasAbiertas = new javax.swing.JList<>();
        txtNombreCompleto = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        txtSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelSaldo.setText("Saldo:");

        listMesasAbiertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMesasAbiertasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listMesasAbiertas);

        btnCerrarSesion.setText("Cerrar sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(547, 547, 547)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCompleto)
                    .addComponent(btnCerrarSesion))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
       try{
        fachada.CerrarSesion((Usuario)jugador);
        salir();
       }
       catch (UsuarioException ux) {
            JOptionPane.showMessageDialog(
                    this,
                    ux.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void listMesasAbiertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMesasAbiertasMouseClicked
        List<Mesa> mesas=Fachada.getInstancia().getMesas();
        int index=listMesasAbiertas.getSelectedIndex();
        Mesa mesaSeleccionada = mesas.get(index);
      
      if(saldo>mesaSeleccionada.getApuestaBase()*10){
             if(mesaSeleccionada.getCantidadJugadores()==mesaSeleccionada.getJugadores().size()){
      
      this.mostrarMensaje("Mesa Completa");
      
      }
      
        InicioMesa a= new InicioMesa(padre,false,mesaSeleccionada,jugador);
        a.setVisible(true);
      
      }else{
      
      this.mostrarMensaje("Saldo Insuficiente");
      
      }
      
   
    }//GEN-LAST:event_listMesasAbiertasMouseClicked

   

    private List<String> formatearMesasCreadas(List<Mesa> mesasCreadas) {
        List<String> mesasFormateadas = new ArrayList<>();
        for (Mesa mesa: mesasCreadas) {
            mesasFormateadas.add(formatearMesasCreadas(mesa));
        }
        return mesasFormateadas;
    }

    private String formatearMesasCreadas(Mesa mesa) {
        return mesa.getNumero()+ "|" +
                mesa.getCantidadJugadores() + "|" +
                mesa.getApuestaBase() + "|"+ mesa.getJugadores().size() + "|"+
                mesa.getManos().size() + "|" + mesa.TotalApostado()+"|"+
                mesa.getPorcentajeComision()+"|"+ mesa.getEstadoMesa();
    }
    private void salir() {
        int opcion = JOptionPane.showConfirmDialog(this, "Desea Salir?");
        if (opcion == JOptionPane.YES_OPTION) {
            this.setVisible(false);
          
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private Inicio.DatosPrueba datosPrueba1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelSaldo;
    private javax.swing.JList<String> listMesasAbiertas;
    private javax.swing.JLabel txtNombreCompleto;
    private javax.swing.JLabel txtSaldo;
    // End of variables declaration//GEN-END:variables

    private void cargarSaldo() {
        
      txtSaldo.setText(Double.toString(saldo));
    }

    private void cargarNombre() {
        txtNombreCompleto.setText(nombre);
      
    }

    @Override
    public void cargarSiguientePantalla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarMesasCreadas() {
        List<Mesa> mesasCreadas = Fachada.getInstancia().getMesas();
        List<String> mesasFormateadas = formatearMesasCreadas(mesasCreadas);
        String[] listaMesasCreadasArray = new String[mesasFormateadas.size()];
        listMesasAbiertas.setListData(mesasFormateadas.toArray(listaMesasCreadasArray));
        }

    @Override
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);  
    }
}