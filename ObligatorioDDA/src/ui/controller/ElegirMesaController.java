/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.Exceptions.MesaException;
import Dominio.Exceptions.UsuarioException;
import Dominio.Fachada;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import ui.view.ElegirMesaView;

/**
 *
 * @author HOLA
 */
public class ElegirMesaController implements observador {
    
    Fachada fachada;
    Jugador jugador;
    ElegirMesaView vista;

    public ElegirMesaController(Jugador jugador, ElegirMesaView vista) {
        fachada=Fachada.getInstancia();
        this.jugador = jugador;
        this.vista = vista;
        fachada.agregar(this);
    }

     public void cargarMesa(Mesa mesa) throws MesaException{
       
            
        mesa.agregarJugador(jugador);
        
        vista.cargarSiguientePantalla(mesa);
      
    }
         
    @Override
    public void actualizar(observable o, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
