/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.view;

import Dominio.Mesa;
import Dominio.Usuario.Usuario;
import Observador.observable;
import java.util.List;

/**
 *
 * @author HOLA
 */
public interface InciarMesaView {

   public void mostrarMesasCreadas(List<Mesa> mesasCreadas);
public void CargarTotalApostado(Double totalApostado);
    public void cargarSiguientePantalla(Mesa mesaSeleccionada);
    public void CargarMesas(List<Mesa> mesas);
}
