/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.Exceptions.MesaException;
import Dominio.Fachada;
import Dominio.Mesa;
import Dominio.Usuario.Admin;
import Observador.observable;
import ui.view.MesaAdminView;
import Observador.observador;
import iuswing.InicioAdmin;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author HOLA
 */
public class MesaAdminController  {
    
    MesaAdminView vista;
    Admin admin;
    Fachada fachada=Fachada.getInstancia();
    
    

    public MesaAdminController(MesaAdminView vista, Admin admin) {    
        this.vista = vista;
        this.admin = admin;
        //fachada.agregar(this);
        
    }


    
    public Admin getAdmin() {
        return admin;
    }
    
    
    public void agregarMesa(int cantJugadores, Double apuestaBase,Double porcentajeComision){
    
     try{
           Mesa m= Fachada.getInstancia().AgregarMesa(cantJugadores,apuestaBase,porcentajeComision);
           vista.mostrarMensaje("Se creó la mesa:"+m.getNumero());
           
             
        } catch (MesaException ex) {
          vista.mostrarMensaje(ex.getMessage());
        }
     
    
    }
}
