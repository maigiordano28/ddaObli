/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import iuswing.Login;


import Dominio.Usuario.Jugador;

import Dominio.Usuario.Admin;
import Dominio.Fachada;
import ui.view.LoginView;
import Dominio.Exceptions.UsuarioException;
/**
 *
 * @author HOLA
 */
public class LoginController {
     Fachada fachada;
     LoginView vista;
    
    
    public LoginController(LoginView v){
        fachada = Fachada.getInstancia();
        vista = v;
    }
    
    public void LoginAdmin(String usr, String contra){
    
            
    try{
    
        //llama login en sistema
        Admin a = fachada.LoginAdmin(usr, contra);
       
        
        vista.mostrarMensaje("login exitoso");
        vista.cargarSiguientePantalla(a);
    }   catch (UsuarioException ex) {
            vista.mostrarMensaje(ex.getMessage());
       
        }
    }
    
    
     public void LoginJugador(String usr, String contra){
    
            
      try{
    
        Jugador j = fachada.LoginJugador(usr, contra);
        vista.mostrarMensaje("login exitoso");
        vista.cargarSiguientePantalla(j);
     
    }   catch (UsuarioException ex) {
          vista.mostrarMensaje(ex.getMessage());
       
        }
    }
          
    
    }
