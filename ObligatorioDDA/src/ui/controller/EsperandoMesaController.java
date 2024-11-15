/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EstadoMesa;
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
        boolean YaCargoMesa = false;

    public EsperandoMesaController( EsperaMesaView vista, Mesa mesa,Jugador jugador) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.mesaSeleccionada = mesa;
        this.jugador=jugador;
        fachada.agregar(this);
    }
    
    
    public void validarEntradaMesa(){
    
        
        if(!YaCargoMesa){
         vista.cargarSiguientePantalla(jugador, mesaSeleccionada);
         actualizarMesa(mesaSeleccionada);
         this.YaCargoMesa = true;
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
         
         if(evento.equals(EventoFachada.ACTIVAR_POKER)){
         vista.activarPoker();
         
         }
        
    }
    
 
    


    public void actualizarCantidadJugadores(Mesa m, Jugador j) {
        fachada.actualizarCantidadJugadores(m,j);
    }
}
