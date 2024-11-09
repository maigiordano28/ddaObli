/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.Fachada;
import ui.view.InciarMesaView;
import Dominio.Usuario.Admin;
import Observador.observable;
import Observador.observador;
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
        Fachada.getInstancia().agregar(this);
    }
   
    
    public void iniciarMesa(){
        
    }

   

    public Admin getAdmin() {
          return admin;
    }
    
    
      public void actualizar(observable o, Object evento) {
        
        if (evento.equals(EventoFachada.NUEVA_MESA)) {
            vista.mostrarMesasCreadas();
        }
        
     
    }
      
      
      
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

