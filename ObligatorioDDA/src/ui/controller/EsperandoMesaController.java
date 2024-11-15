/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.EventoMesa;
import Dominio.Exceptions.MesaException;
import Dominio.Fachada;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import iuswing.Poker;
import java.awt.Frame;
import java.util.List;
import ui.view.EsperaMesaView;
import ui.view.InciarMesaView;

/**
 *
 * @author HOLA
 */
public class EsperandoMesaController implements observador{
        Frame padre;
        Fachada fachada;
        EsperaMesaView vista;
        Mesa mesaSeleccionada;
        Jugador jugador;

    public EsperandoMesaController( EsperaMesaView vista, Mesa mesa,Jugador jugador) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.mesaSeleccionada = mesa;
        this.jugador=jugador;
        fachada.agregar(this);
    }
    
    
    public void validarEntradaMesa(){
     if(mesaSeleccionada.obtenerLargoListaJugadores()==mesaSeleccionada.getCantidadJugadores() && (!mesaSeleccionada.EnJuego() || mesaSeleccionada.jugadorEnMesa(jugador))){
         mesaSeleccionada.setMesaEnJuego(true);
         vista.cargarSiguientePantalla(jugador, mesaSeleccionada);
         actualizarMesa(mesaSeleccionada);
     }
    }
    
        public void actualizarMesa(Mesa mesa){
        
        fachada.ActualizarMesa(mesa); 
    }   

    @Override
    public void actualizar(observable o, Object evento) {
        
         if (evento.equals(EventoFachada.NUEVO_JUGADOR_MESA)) {
           vista.CambiarInterfaz(mesaSeleccionada);
        }
        
    }
    
 
    


    public void actualizarCantidadJugadores(Mesa m, Jugador j) {
        fachada.actualizarCantidadJugadores(m,j);
    }
}
