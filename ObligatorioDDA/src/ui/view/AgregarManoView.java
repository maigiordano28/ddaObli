/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Mano;
import java.util.List;

/**
 *
 * @author HOLA
 */
public interface AgregarManoView {
    
    
     public void mostrarManosCreadas(List<Mano> manos);
      public void mostrarMensaje(String msg);
    public void cargarSiguientePantalla();
    
}
