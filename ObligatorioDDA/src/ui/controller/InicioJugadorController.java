/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.EventoMesa;
import Dominio.Fachada;
import Dominio.Usuario.Admin;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import ui.view.InciarMesaView;
import ui.view.InicioJugadorView;


/**
 *
 * @author HOLA
 */
public class InicioJugadorController implements observador{
 Fachada fachada;
    InicioJugadorView vista;
    Jugador j;
    

    public InicioJugadorController(InicioJugadorView vista, Jugador j) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.j = j;
        Fachada.getInstancia().agregar(this);
    }
 

   

    public Jugador getJugador() {
          return j;
    }
    
    
 @Override
      public void actualizar(observable o, Object evento) {
        
        if (evento.equals(EventoMesa.NUEVA_MESA)) {
            vista.mostrarMesasCreadas();
        }
        
          if (evento.equals(EventoFachada.NUEVA_INFO)) {
            vista.cargarSaldo();
        }
     
    }
      
      public boolean jugadorEnMesa(Jugador jugador){
      
       return fachada.jugadorEnMesa(jugador);
      
      }
      
      
      
    
      
    }
    
    
    
    