/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.Exceptions.UsuarioException;
import Dominio.Fachada;
import Dominio.Mesa;
import ui.view.InciarMesaView;
import Dominio.Usuario.Admin;
import Observador.observable;
import Observador.observador;
import iuswing.ManosAdmin;
import java.util.List;
import java.util.logging.Logger;
/**
 *
 * @author HOLA
 */
public class IniciarMesaController implements observador{
    Fachada fachada;
    InciarMesaView vista;
    Admin admin;
    

    public IniciarMesaController(InciarMesaView vista, Admin admin) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.admin = admin;
        fachada.agregar(this);
    }
   
    public void TotalApostado(){
    
    Double totalApostado=fachada.TotalApostado();
    vista.CargarTotalApostado(totalApostado);
    
    
    }

   public void obtenerMesaSeleccionada(int index){
    List<Mesa> mesas=Fachada.getInstancia().getMesas();
    Mesa mesaSeleccionada = mesas.get(index);
    vista.cargarSiguientePantalla(mesaSeleccionada);
   }

    public Admin getAdmin() {
          return admin;
    }
    
    public void ObtenerMesas(){
    
    List<Mesa> mesas= fachada.getMesas();
    vista.CargarMesas(mesas);
    }
    
      public void actualizar(observable o, Object evento) {
        
        if (evento.equals(EventoFachada.NUEVA_MESA)) {
            vista.mostrarMesasCreadas(fachada.getMesas());
        }
        
     
    }
      
        public void logout(){
    try{
        fachada.CerrarSesion(admin);
        vista.cerrarVentana();
    }   catch (UsuarioException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    
    }
      
      
      
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

