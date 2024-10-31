/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOLA
 */
public abstract class observable {
    private final List<observador> observadores = new ArrayList<>();
    
    
    
    
      public void agregar(observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }
    
    public void quitar(observador observador) {
        if (observadores.contains(observador)) {
            observadores.remove(observador);
        }
    }
    
    public void avisar(Object evento) {
        List<observador> observadoresTemporal = new ArrayList<>(observadores);
        for (observador observador : observadoresTemporal) {
            observador.actualizar(this, evento);
        }
    }
}
