/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.EventoMesa;
import Dominio.Exceptions.UsuarioException;
import Dominio.Fachada;
import Dominio.Mesa;
import Dominio.Usuario.Admin;
import Dominio.Usuario.Jugador;
import Observador.observable;
import Observador.observador;
import iuswing.InicioMesa;
import java.util.List;
import javax.swing.JOptionPane;
import ui.view.InciarMesaView;
import ui.view.InicioJugadorView;


/**
 *
 * @author HOLA
 */
public class InicioJugadorController implements observador{
    Fachada fachada;
    InicioJugadorView vista;
    Jugador jugador;


    public InicioJugadorController(InicioJugadorView vista, Jugador jugador) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.jugador = jugador;
        Fachada.getInstancia().agregar(this);
    }
 

   

    public Jugador getJugador() {
          return jugador;
    }
    
    
 @Override
      public void actualizar(observable o, Object evento) {
        
        if (evento.equals(EventoMesa.NUEVA_MESA)) {
            vista.mostrarMesasCreadas(fachada.getMesas());
        }
        
          if (evento.equals(EventoFachada.NUEVA_INFO)) {
            vista.cargarSaldo(jugador);
        }
     
    }
      
      public boolean jugadorEnMesa(Jugador jugador){
      
       return fachada.jugadorEnMesa(jugador);
      
      }
      
      public void cerrarSesion (){
           try{
        fachada.CerrarSesion(jugador);
        vista.salir();
       }
       catch (UsuarioException ux) {
            vista.mostrarMensaje(ux.getMessage());
        }
      
      }
      
      public void EntrarAMesa(int index){
      
      List<Mesa> mesas=fachada.getMesas();
      Mesa mesaSeleccionada = mesas.get(index);
      
      if(jugador.getSaldoInicial()>mesaSeleccionada.getApuestaBase()*10){
            if(mesaSeleccionada.getCantidadJugadores()==mesaSeleccionada.obtenerLargoListaJugadores()){
                vista.mostrarMensaje("Mesa Completa");
            }else if(jugadorEnMesa(jugador)){
                vista.mostrarMensaje("Ya estas en una mesa");
            }else{
                vista.cargarSiguientePantalla(mesaSeleccionada,jugador);
            }     
      }else{
      
        vista.mostrarMensaje("Saldo Insuficiente");
      
      }
      
      
      
      }
      
      
       
    }
    
      
    
    
    
    
    