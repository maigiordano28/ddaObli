/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.Fachada;
import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import iuswing.InicioMesa;
import ui.view.InicioMesaView;

/**
 *
 * @author HOLA
 */
public class InicioMesaController  {
    Fachada fachada;
    InicioMesaView vista;
    private Mesa mesaSeleccionada;
    private Jugador jugador;

    public InicioMesaController(InicioMesaView vista, Mesa mesaSeleccionada, Jugador jugador) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.mesaSeleccionada = mesaSeleccionada;
        this.jugador = jugador;
        
    }

    public void EntrarAMesa(){
            vista.cargarSiguientePantalla(mesaSeleccionada,jugador);
         if(!mesaSeleccionada.getJugadores().contains(jugador)){
            mesaSeleccionada.AgregarJugador(jugador);
          }
    
    }
}
