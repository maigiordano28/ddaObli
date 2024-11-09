/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Mesa;
import java.util.List;

/**
 *
 * @author HOLA
 */
public interface MesaAdminView {
  
      public void mostrarMensaje(String msg);
     public void mostrarMesasCreadas();
      public void mostrarMesas(List<Mesa> m);
}
