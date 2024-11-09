/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuswing;

import Dominio.EventoMesa;
import Dominio.Exceptions.MesaException;
import Dominio.Fachada;
import Dominio.Mesa;
import Dominio.Usuario.Admin;
import Observador.observable;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import ui.controller.IniciarMesaController;
import ui.controller.MesaAdminController;
import ui.view.InciarMesaView;
/**
 *
 * @author HOLA
 */
public class InicioAdmin extends javax.swing.JDialog implements InciarMesaView{
    Fachada fachada= Fachada.getInstancia();
  private java.awt.Frame padre;
   private IniciarMesaController controller;
    /**
     * Creates new form InicioAdmin
     */
    public InicioAdmin(java.awt.Frame parent, boolean modal, Admin u) {
        super(parent, modal);
        initComponents();
        CargarTotalApostado();
        CargarMesas();
        controller= new IniciarMesaController(this,u);
        
     
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMontoTotal = new javax.swing.JLabel();
        btnCrarMesa = new javax.swing.JButton();
        labelMontoTotalH = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListMesas = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelMontoTotal.setText("Monto Total Recaudado:");

        btnCrarMesa.setText("Crear Mesa");
        btnCrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrarMesaActionPerformed(evt);
            }
        });

        ListMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListMesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListMesas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMontoTotal)
                        .addGap(32, 32, 32)
                        .addComponent(labelMontoTotalH, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrarMesa))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMontoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMontoTotalH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnCrarMesa)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrarMesaActionPerformed
     this.cargarSiguientePantalla();
       
    }//GEN-LAST:event_btnCrarMesaActionPerformed

    private void ListMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListMesasMouseClicked
       this.CargarMesas();
    }//GEN-LAST:event_ListMesasMouseClicked


    
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
                mesa.getApuestaBase() + "|"+
                mesa.getJugadores().size() + "|"+
                mesa.getManos().size() + "|" + mesa.TotalApostado()+"|"+
                mesa.getPorcentajeComision()+"|"+ mesa.getEstadoMesa();
    }
public void CargarMesas(){
   List<Mesa> mesas=fachada.getMesas();
   ListMesas.setListData( mesas.toArray());

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListMesas;
    private javax.swing.JButton btnCrarMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMontoTotal;
    private javax.swing.JLabel labelMontoTotalH;
    // End of variables declaration//GEN-END:variables

    private void CargarTotalApostado() {
         labelMontoTotalH.setText(Double.toString(fachada.TotalApostado()));
    }

    @Override
    public void iniciarMesa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cargarSiguientePantalla() {
        
        AgregarMesa a= new AgregarMesa(null,false,controller.getAdmin());
        a.setVisible(true);
    }

    @Override
    public void mostrarMesasCreadas() {
    
        List<Mesa> mesasCreadas = Fachada.getInstancia().getMesas();
        List<String> mesasFormateadas = formatearMesasCreadas(mesasCreadas);
        String[] listaMesasCreadasArray = new String[mesasFormateadas.size()];
        ListMesas.setListData(mesasFormateadas.toArray(listaMesasCreadasArray));
    }

    @Override
    public void cargarManos() {
   ManosAdmin a= new ManosAdmin(padre, false);
        a.setVisible(true);
    }
   

    }

      


    
    
    

