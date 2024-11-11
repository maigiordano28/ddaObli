/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Exceptions.MesaException;
import Dominio.Usuario.Jugador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bsout
 */
public class SistemaMesa {
    public ArrayList<Mesa> mesas=new ArrayList();

    public List<Mesa> getMesas() {
        return mesas;
    }
    
    
    
    
    public double TotalApostado(){
         int i=0;
     for(Mesa m:mesas){
          i += (m.TotalApostado()*m.getPorcentajeComision())/100;
     
     }
     return i;
    }
    
    
    
    
    
    public Mesa AgregarMesa(int cantJugadores, double apuestaBase, double porcentajeComision) throws MesaException {
         Mesa mesa = new Mesa(cantJugadores,apuestaBase,porcentajeComision);
         mesa.Validar();
         mesas.add(mesa);
         return mesa;
         
    }

   public Mesa ActualizarMesa(Mesa m) {
        m.setEstadoMesa(EstadoMesa.iniciada);
        return m;
}

    void actualizarCantidadJugadores(Mesa m, Jugador j) {
       m.getJugadores().add(j);
    }
}
