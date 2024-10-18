/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.util.ArrayList;

/**
 *
 * @author bsout
 */
public class Figura {
    
    private String nombre;
    private ArrayList<Carta> cartas;
    private tipoFigura tipoFigura;

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
}
