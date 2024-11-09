/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Mesa;

/**
 *
 * @author HOLA
 */
public interface MesaAdminView {
     public void agregarMesa(int cantJugadores, Double apuestaBase, Double porcentajeComision);
      public void mostrarMensaje(String msg);
    public void cargarSiguientePantalla(Mesa m);
}
