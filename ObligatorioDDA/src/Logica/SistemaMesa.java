/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Logica.Exceptions.MesaException;
import java.util.ArrayList;

/**
 *
 * @author bsout
 */
public class SistemaMesa {
    public ArrayList<Mesa> mesas=new ArrayList();
    
    
    
    
    public double TotalApostado(){
         int i=0;
     for(Mesa m:mesas){
          i += m.TotalApostado();
     
     }
     return i;
    }
    
    
    
    
    
    public Mesa AgregarMesa(int cantJugadores, double apuestaBase, double porcentajeComision) throws MesaException {
         Mesa mesa = new Mesa(cantJugadores,apuestaBase,porcentajeComision);
         mesa.Validar();
         return mesa;
    }
}
