/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Mesa;
import Dominio.Usuario.Jugador;
import Dominio.Usuario.Usuario;
import java.util.List;

/**
 *
 * @author HOLA
 */
public interface EsperaMesaView {
    public void CambiarInterfaz();
    public void mostrarMensaje(String msg);
       public void cargarSiguientePantalla(List<Jugador> js,Jugador j, Mesa mesa);

}
