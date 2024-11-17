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
public class SistemaFigura {
    
     private ArrayList<Figura> figuras=new ArrayList();

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }
    
    
    public void agregarFigura(String palo){
    this.figuras.add(new Figura(palo));
    }
}
