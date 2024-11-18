/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.EventoFachada;
import Dominio.Fachada;
import Dominio.Mesa;
import Observador.observable;
import Observador.observador;
import java.awt.Frame;
import ui.view.AgregarManoView;
import ui.view.EsperaMesaView;

/**
 *
 * @author HOLA
 */
public class AgregarManoController implements observador{
     Frame padre;
     Fachada fachada;
        AgregarManoView vista;
private Mesa mesa;

    public AgregarManoController( AgregarManoView vista,Mesa mesa) {
         fachada=Fachada.getInstancia();
        this.vista = vista;
        this.mesa=mesa;
       
        fachada.agregar(this);
    }

    @Override
    public void actualizar(observable o, Object evento) {
        if (evento.equals(EventoFachada.NUEVA_MANO)) {
            vista.mostrarManosCreadas(mesa.getManos());
        }
    }
    
    
    
    
    
    
    
    
    
    
}
