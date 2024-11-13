/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.EventoMesa;
import Dominio.Fachada;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import ui.view.InicioJugadorView;
import ui.view.PokerView;

/**
 *
 * @author HOLA
 */
public class PokerController implements observador{
 Fachada fachada;
    PokerView vista;
   
    

    public PokerController(PokerView vista) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        
        Fachada.getInstancia().agregar(this);
    }
 

   

 
    
    @Override
      public void actualizar(observable o, Object evento) {
        
        if (evento.equals(EventoFachada.NUEVO_MESA_INICIADA)) {
            vista.mostrarJugadoresEnMesa();
        }
        
     
    }
      
      
      
    }
    
    
    
    