/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasPokerException;

/**
 *
 * @author PC
 */
public class EjemploUsoPanelCartas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<CartaPoker> cartas = new ArrayList();
        cartas.add(new CartaEjemplo(1,CartaPoker.CORAZON));
        cartas.add(new CartaEjemplo(1,CartaPoker.DIAMANTE));
        cartas.add(new CartaEjemplo(1,CartaPoker.TREBOL));
        cartas.add(new CartaEjemplo(1,CartaPoker.PIQUE));
        cartas.add(new CartaEjemplo(11,CartaPoker.PIQUE));
        
        DialogoEjemplo dialogo = new DialogoEjemplo(null, false);
        dialogo.setVisible(true);  
       
        dialogo.cargarCartas(cartas);
        
     
        cartas.set(0, new CartaEjemplo(10,CartaPoker.PIQUE));
        dialogo.cargarCartas(cartas);
        cartas.set(0, new CartaEjemplo(9,CartaPoker.PIQUE));
        dialogo.cargarCartas(cartas);
        
        
    }
    
}
