/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;

/**
 *
 * @author bsout
 */
public class Figura {
    
    private String nombre;
    private ArrayList<Carta> cartas;
    private tipoFigura tipoFigura;

    public Figura(String nombre, ArrayList<Carta> cartas, tipoFigura tipoFigura) {
        this.nombre = nombre;
        this.cartas = cartas;
        this.tipoFigura = tipoFigura;
    }

    public Figura(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Figura(String nombre) {
        this.nombre = nombre;
    }
    
     public tipoFigura determinarFigura(ArrayList<Carta> cartas ) {
        ArrayList<tipoFigura> tiposFigura = new ArrayList<>();
    
    // Agrega los diferentes tipos de figuras posibles
    tiposFigura.add(new Par());  
    tiposFigura.add(new Pierna());      
    tiposFigura.add(new Escalera()); 
    tiposFigura.add(new Poker());    
        for (tipoFigura tipo : tiposFigura) {
            if (tipo.esFigura(cartas)) {
                return tipo;
            }
        }
       
        return this.tipoFigura; // Si no se encuentra figura, retorna null
    }

    
    public boolean determinarFiguraGanadora(){
    return tipoFigura.esFigura(cartas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public tipoFigura getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(tipoFigura tipoFigura) {
        this.tipoFigura = tipoFigura;
    }
    
    public void DeterminarFiguraGanadora(){
        
    }
    
    @Override
    public String toString() {
      return this.getNombre();
    }
}
