/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.EventoMesa;
import Dominio.Fachada;
import Dominio.Mesa;
import Observador.observable;
import Observador.observador;
import ui.view.EsperaMesaView;
import ui.view.InciarMesaView;

/**
 *
 * @author HOLA
 */
public class EsperandoMesaController implements observador{
    
      Fachada fachada;
    EsperaMesaView vista;
    Mesa mesa;

    public EsperandoMesaController( EsperaMesaView vista, Mesa mesa) {
         fachada=Fachada.getInstancia();
        this.vista = vista;
        this.mesa = mesa;
        fachada.agregar(this);
    }
    
    

    @Override
    public void actualizar(observable o, Object evento) {
        
         if (evento.equals(EventoFachada.NUEVO_JUGADOR_MESA)) {
            vista.CambiarInterfaz();
        }
        
    }
    
    
    
}
