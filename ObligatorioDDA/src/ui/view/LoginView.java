/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Usuario.Usuario;
/**
 *
 * @author HOLA
 */
public interface LoginView {
       public void Login(String name, String contra);
    public void mostrarMensaje(String msg);
    public void cargarSiguientePantalla(Usuario u);
}
