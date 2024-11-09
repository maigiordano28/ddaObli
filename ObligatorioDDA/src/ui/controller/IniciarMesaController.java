/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import Dominio.Fachada;
import ui.view.InciarMesaView;
import Dominio.Usuario.Admin;
import java.util.logging.Logger;
/**
 *
 * @author HOLA
 */
public class IniciarMesaController {
    Fachada fachada;
    InciarMesaView vista;
    Admin admin;

    public IniciarMesaController(InciarMesaView vista, Admin admin) {
        fachada=Fachada.getInstancia();
        this.vista = vista;
        this.admin = admin;
    }
   
    
    public void iniciarMesa(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
